package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.teamsmarteat.model.DishEntity;
import org.teamsmarteat.model.PromotionEntity;
import org.teamsmarteat.model.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PromotionAction extends ActionSupport implements SessionAware {

    Map sessionMap;
    private int promotionId;
    private String promotionName;

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    private int dishId;
    private List<PromotionEntity> result;
    private EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");


    private PromotionAction() {
    }

    public List getResult() {
        return result;
    }

    public void setResult(List<PromotionEntity> result) {
        this.result = result;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }


    @Override
    public String execute() {
        if (result == null) {
            queryPromotions();
        }
        return SUCCESS;
    }

    private void queryPromotions() {
        result = new ArrayList<PromotionEntity>();
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT p from PromotionEntity p");
        result = query.getResultList();
    }

    public String deleteDish() {
        EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory("unit1").createEntityManager();
        DishEntity dish = em.find(DishEntity.class, dishId);
        PromotionEntity promo = em.find(PromotionEntity.class, promotionId);
        if (promo != null && dish != null) {
            em.getTransaction().begin();
            if (promo.getDishes().contains(dish))
                promo.getDishes().remove(dish);
            em.getTransaction().commit();
        }
        queryPromotions();
        return SUCCESS;
    }

    public String deletePromo() {

        EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory("unit1").createEntityManager();

        PromotionEntity promo = em.find(PromotionEntity.class, promotionId);
        em.getTransaction().begin();

        em.remove(promo);
        em.getTransaction().commit();
        queryPromotions();
        return SUCCESS;
    }

    public String search_promotion() {
        EntityManager em = factory.createEntityManager();
        UserEntity currentUser = (UserEntity) sessionMap.get("userEntity");
        int userId = currentUser.getUserId();

        if (!(promotionName.isEmpty() && promotionName == null)) {
            Query query = em.createQuery("SELECT p FROM PromotionEntity p " +
                    "INNER JOIN RestaurantEntity r on p.restaurant.restaurantId = r.restaurantId " +
                    "WHERE p.name LIKE ? AND r.user.id= ?");
            result = query.setParameter(0, "%" + promotionName + "%")
                    .setParameter(1, userId)
                    .getResultList();
            execute();
            return SUCCESS;
        } else {
            execute();
            return SUCCESS;
        }

    }

    @Override
    public void setSession(Map session) {
        this.sessionMap = session;
    }

}
