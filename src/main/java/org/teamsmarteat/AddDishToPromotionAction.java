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
import java.util.List;
import java.util.Map;

public class AddDishToPromotionAction extends ActionSupport implements SessionAware {


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
    public void setSession(Map session) {
        this.sessionMap = session;
    }


}
