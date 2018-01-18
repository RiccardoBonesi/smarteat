package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.teamsmarteat.model.CategoryEntity;
import org.teamsmarteat.model.DishEntity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DishListAction extends ActionSupport implements SessionAware {
    Map sessionMap;
    private int dishId;
    private String dishName;
    private DishEntity dishEntity;


    public DishEntity getDishEntity() {
        return dishEntity;
    }

    public void setDishEntity(DishEntity dishEntity) {
        this.dishEntity = dishEntity;
    }

    private List<DishEntity> resultDish;
    private List<DishEntity> search_result;
    private List<CategoryEntity> resultCategory;


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

    private static Logger logger = LogManager.getLogger(DishListAction.class);
    private EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");

    private List<DishEntity> result;

    public String execute() {
        if (sessionMap==null || sessionMap.isEmpty()) {
            return "noParameter";
        }

        String userId = (String) sessionMap.get("user");

        EntityManager em = factory.createEntityManager();
        if (resultDish == null) {
            Query queryDish = em.createQuery("select d from DishEntity d " +
                    "inner join CategoryEntity c on d.category.id = c.categoryId  " +
                    "inner join RestaurantEntity r on d.menu = r.menu where r.username = ? " +
                    "order by c.categoryId");
            resultDish = queryDish.setParameter(0, userId).getResultList();
        }
        em = factory.createEntityManager();
        Query queryCategory = em.createQuery("select c from CategoryEntity c");
        resultCategory = queryCategory.getResultList();
        return SUCCESS;
    }

    public String delete_dish(){
        if (dishId != 0) {
            EntityManager em = factory.createEntityManager();
            DishEntity dishEntity = em.find(DishEntity.class, dishId);
            em.getTransaction().begin();
            dishEntity.setEnabled(false);
            em.getTransaction().commit();
            execute();
            return SUCCESS;
        } else {
            return ERROR;
        }
    }


    public String search_dish() {
        EntityManager em = factory.createEntityManager();
        String userId = (String) sessionMap.get("user");

        if (dishName != null && !dishName.isEmpty()) {
            Query query = em.createQuery("SELECT d FROM DishEntity d " +
                    "INNER JOIN RestaurantEntity r on d.menu = r.menu " +
                    "WHERE d.name LIKE ? AND r.username = ?");
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

    @Override
    public void setSession(Map session)
    {
        this.sessionMap=session;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {

    }
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {

    }
}
