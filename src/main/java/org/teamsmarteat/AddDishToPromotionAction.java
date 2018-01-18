package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.teamsmarteat.model.CategoryEntity;
import org.teamsmarteat.model.DishEntity;
import org.teamsmarteat.model.PromotionEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddDishToPromotionAction extends ActionSupport implements SessionAware {


    private static final String INVALID = "invalid";
    Map sessionMap;
    private int dishId;
    private String dishName;
    private int promotionId;
    private List<DishEntity> resultDish;
    private List<DishEntity> search_result;
    private List<CategoryEntity> resultCategory;
    private static Logger logger = LogManager.getLogger(DishListAction.class);
    private EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
    private boolean errorAdd;
    private List<DishEntity> result;

    public Map getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String execute() {
        if (sessionMap.isEmpty()) {
            return "noParameter";
        }
        EntityManager em = factory.createEntityManager();
        if (resultDish == null) {

            Query queryDish = em.createQuery("select d from DishEntity d " +
                    "inner join CategoryEntity c on d.category.id = c.categoryId  " +
                    "inner join RestaurantEntity r on d.menu = r.menu where r.username = ? " +
                    "order by c.categoryId");
            String userId = (String) sessionMap.get("user");
            resultDish = queryDish.setParameter(0, userId).getResultList();
        }
        em = factory.createEntityManager();
        Query queryCategory = em.createQuery("select c from CategoryEntity c");
        resultCategory = queryCategory.getResultList();
        return SUCCESS;
    }


    public String addDish() {

        EntityManager em = factory.createEntityManager();


        DishEntity dish = em.find(DishEntity.class, dishId);
        PromotionEntity promo = em.find(PromotionEntity.class, promotionId);

        if (promo != null && dish != null) {
            execute();
            if (!promo.getDishes().contains(dish)) {
                em.getTransaction().begin();
                promo.getDishes().add(dish);
                em.getTransaction().commit();
            } else {
                execute();
                errorAdd = true;
                return INVALID;
            }

        }
//        queryPromotions();

        return SUCCESS;
    }

    public String search_dish() {
        EntityManager em = factory.createEntityManager();
        String userId = (String) sessionMap.get("user");

        if (dishName != null && !dishName.isEmpty()) {
            Query query = em.createQuery("select d from DishEntity d " +
                    "inner join CategoryEntity c on d.category.id = c.categoryId  " +
                    "inner join RestaurantEntity r on d.menu = r.menu where  d.name like ? " +
                    "and  r.username = ? " +
                    "order by c.categoryId");
            resultDish = query.setParameter(0, "%" + dishName + "%")
                    .setParameter(1, userId)
                    .getResultList();
            execute();
            return SUCCESS;
        } else {
            execute();
            return SUCCESS;
        }

    }

    public List getResult() {
        return result;
    }

    public List getSearchResult() {
        return search_result;
    }

    public List getResultCategory() {
        return resultCategory;
    }

    public List getResultDish() {
        return resultDish;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    private DishEntity dishEntity;

    public DishEntity getDishEntity() {
        return dishEntity;
    }

    public void setDishEntity(DishEntity dishEntity) {
        this.dishEntity = dishEntity;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public boolean isErrorAdd() {
        return errorAdd;
    }

    public void setErrorAdd(boolean errorAdd) {
        this.errorAdd = errorAdd;
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
