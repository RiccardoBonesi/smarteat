package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.teamsmarteat.model.DishEntity;
import org.teamsmarteat.model.OrderEntity;
import org.teamsmarteat.model.PromotionEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PromotionAction extends ActionSupport {

    private int promotionId;
    private int dishId;
    private List<PromotionEntity> result;

    private PromotionAction() {}

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
        queryPromotions();
        return SUCCESS;
    }

    private void queryPromotions() {
        result = new ArrayList<PromotionEntity>();
        EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT p from PromotionEntity p");
        result = query.getResultList();
        for (int i = 0; i <= result.size(); i++) {
            if (result.get(i).getDishes().size() == 0) {
                result.remove(i);
            }
        }
    }

    public String deleteDish() {
        EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory("unit1").createEntityManager();
        DishEntity dish = em.find(DishEntity.class, dishId);
        PromotionEntity promo = em.find(PromotionEntity.class, promotionId);
        em.getTransaction().begin();
        if (promo.getDishes().contains(dish))
            promo.getDishes().remove(dish);
        em.getTransaction().commit();
        queryPromotions();
        return SUCCESS;
    }

}
