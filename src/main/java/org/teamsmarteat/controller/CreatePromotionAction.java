package org.teamsmarteat.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.teamsmarteat.PersistenceManager;
import org.teamsmarteat.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.io.IOException;
import java.util.*;

public class CreatePromotionAction extends ActionSupport implements SessionAware {

    Map sessionMap;
    private static final String INVALID = "invalid";
    private boolean loginFailed = false;
    private List<DishEntity> resultDish;
    private List<CategoryEntity> resultCategory;
    private List checkboxDish;
    private PromotionEntity promotionEntity;
    private String dishName;
    private String action_value;
    private List<String> checkBoxes;
    private EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");

    public boolean isLoginFailed() {
        return loginFailed;
    }

    public void setLoginFailed(boolean loginFailed) {
        this.loginFailed = loginFailed;
    }

    public String execute() {
        if (sessionMap == null || sessionMap.isEmpty()) {
            return "noParameter";
        }

        EntityManager em = factory.createEntityManager();

        if (resultDish == null) {
            Query queryDish = em.createQuery("select d from DishEntity d");
            resultDish = queryDish.getResultList();
        } else {
            resultDish.addAll(checkboxDish);

            Set<DishEntity> hs = new LinkedHashSet<>(resultDish);
            resultDish.clear();
            resultDish.addAll(hs);
        }
        em = factory.createEntityManager();
        Query queryCategory = em.createQuery("select c from CategoryEntity c");
        resultCategory = queryCategory.getResultList();
        return SUCCESS;
    }

    public String confirm_promotion() {

        EntityManager em = factory.createEntityManager();
        if ("search_dish".equalsIgnoreCase(action_value)) {

            Query query = em.createQuery("SELECT i FROM DishEntity i WHERE i.name LIKE ?");
            resultDish = query.setParameter(0, "%" + dishName + "%").getResultList();

            checkboxDish = new ArrayList<DishEntity>();

            if (!(checkBoxes == null)) {
                for (String dishId : checkBoxes) {
                    checkboxDish.add(em.find(DishEntity.class, Integer.valueOf(dishId)));
                }
            }


            execute();
            return ERROR;

        } else {
            if (checkBoxes == null || promotionEntity.getName().isEmpty() || promotionEntity.getPrice() <= 0) {
                loginFailed = true;
                execute();
                return INVALID;
            }
            String user = (String) sessionMap.get("user");
            String pwd = (String) sessionMap.get("psw");

            checkboxDish = new ArrayList<DishEntity>();
            for (String dishId : checkBoxes) {
                checkboxDish.add(em.find(DishEntity.class, Integer.valueOf(dishId)));
            }


            promotionEntity.setDishes(checkboxDish);

            Query query = em.createQuery("select r from RestaurantEntity r " +
                    "where r.username= :userUsername " +
                    "and r.keyid= :userPassword");

            List<RestaurantEntity> result = query.setParameter("userUsername", user).setParameter("userPassword", pwd).getResultList();

            promotionEntity.setRestaurant(result.get(0));
            em.getTransaction().begin();
            em.persist(promotionEntity); //em.merge(u); for updates
            em.getTransaction().commit();
            em.close();

            return SUCCESS;
        }


    }


    public List<DishEntity> getResultDish() {
        return resultDish;
    }

    public void setResultDish(List<DishEntity> resultDish) {
        this.resultDish = resultDish;
    }

    public List<DishEntity> getCheckboxDish() {
        return checkboxDish;
    }

    public void setCheckboxDish(List<DishEntity> checkboxDish) {
        this.checkboxDish = checkboxDish;
    }

    public PromotionEntity getPromotionEntity() {
        return promotionEntity;
    }

    public void setPromotionEntity(PromotionEntity promotionEntity) {
        this.promotionEntity = promotionEntity;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getAction_value() {
        return action_value;
    }

    public void setAction_value(String action_value) {
        this.action_value = action_value;
    }

    public List<String> getCheckBoxes() {
        return checkBoxes;
    }

    public void setCheckBoxes(List<String> checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

    public List<CategoryEntity> getResultCategory() {
        return resultCategory;
    }

    public void setResultCategory(List<CategoryEntity> resultCategory) {
        this.resultCategory = resultCategory;
    }

    @Override
    public void setSession(Map session) {
        this.sessionMap = session;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {

    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {

    }
}
