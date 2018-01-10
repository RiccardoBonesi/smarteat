package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.teamsmarteat.model.CategoryEntity;
import org.teamsmarteat.model.DishEntity;
import org.teamsmarteat.model.UserEntity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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

    public String execute() throws Exception {
        UserEntity currentUser = (UserEntity) sessionMap.get("userEntity");

        int userId = currentUser.getUserId();

        EntityManager em = factory.createEntityManager();
        if (resultDish == null) {
            Query queryDish = em.createQuery("select d from DishEntity d inner join CategoryEntity c on d.category=c.categoryId order by c.categoryId");
            resultDish = queryDish.getResultList();
            /*Query queryDish = em.createQuery("select d from DishEntity d " +
                    "inner join CategoryEntity c on d.category=c.categoryId  " +
                    "inner join RestaurantEntity r on d.menu = r.menu where r.user= :userId" +
                    "order by c.categoryId" );
            resultDish = queryDish.setParameter("userId", userId).getResultList();*/
        }
        em = factory.createEntityManager();
        Query queryCategory = em.createQuery("select c from CategoryEntity c");
        resultCategory = queryCategory.getResultList();

        //TODO BONNY: aggiungere check del menù assegnato all'utente in uso
        return SUCCESS;
    }

    public String delete_dish() throws Exception {
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


    public String search_dish() throws Exception {
        EntityManager em = factory.createEntityManager();

        if (!(dishName.isEmpty() && dishName == null)) {
            Query query = em.createQuery("SELECT d FROM DishEntity d WHERE d.name LIKE :dishName");
            resultDish = query.setParameter("dishName", "%" + dishName + "%").getResultList();
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


}
