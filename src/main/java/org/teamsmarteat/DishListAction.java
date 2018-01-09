package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.teamsmarteat.model.CategoryEntity;
import org.teamsmarteat.model.DishEntity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class DishListAction extends ActionSupport{
    private int dishId;
    private DishEntity dishEntity;
    public DishEntity getDishEntity() {
        return dishEntity;
    }
    public void setDishEntity(DishEntity dishEntity) {
        this.dishEntity = dishEntity;
    }

    private List<DishEntity> resultDish;
    private List<CategoryEntity> resultCategory;


    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    private static Logger logger = LogManager.getLogger(DishListAction.class);
    private EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");

    private List<DishEntity> result;

    public String execute() {
        EntityManager em = factory.createEntityManager();
        Query queryDish = em.createQuery("select d from DishEntity d inner join CategoryEntity c on d.category=c.categoryId order by c.categoryId");
        resultDish = queryDish.getResultList();

        em = factory.createEntityManager();
        Query queryCategory = em.createQuery("select c from CategoryEntity c");
        resultCategory = queryCategory.getResultList();

        return SUCCESS;
    }

    public String delete_dish () {
        EntityManager em1 = factory.createEntityManager();

        if (dishId != 0) {
           dishEntity = em1.find(DishEntity.class, dishId);
            em1.getTransaction().begin();
            em1.remove(dishEntity);
            em1.getTransaction().commit();
            execute();
           return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public List getResult() {
        return result;
    }

    public List getResultCategory() {
        return resultCategory;
    }

    public List getResultDish() {
        return resultDish;
    }



}
