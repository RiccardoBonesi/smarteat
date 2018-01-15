package org.teamsmarteat;

import com.opensymphony.xwork2.ActionSupport;
import org.teamsmarteat.model.CategoryEntity;
import org.teamsmarteat.model.DishEntity;
import org.teamsmarteat.model.IngredientEntity;
import org.teamsmarteat.model.PromotionEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CreatePromotionAction extends ActionSupport {




    private List<DishEntity> resultDish;
    private List<DishEntity> checkboxDish;
    private List<CategoryEntity> resultCategory;
    private PromotionEntity promotionEntity;



    private String dishName;
    private EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");

    public String execute() {
        EntityManager em = factory.createEntityManager();


        if (resultDish == null) {
            Query queryDish = em.createQuery("select d from IngredientEntity d");
            resultDish = queryDish.getResultList();
        }else{
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


    public List<DishEntity> getCheckboxDish() {
        return checkboxDish;
    }

    public void setCheckboxDish(List<DishEntity> checkboxDish) {
        this.checkboxDish = checkboxDish;
    }

    public List<CategoryEntity> getResultCategory() {
        return resultCategory;
    }

    public void setResultCategory(List<CategoryEntity> resultCategory) {
        this.resultCategory = resultCategory;
    }

    public List<DishEntity> getResultDish() {
        return resultDish;
    }

    public void setResultDish(List<DishEntity> resultDish) {
        this.resultDish = resultDish;
    }
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
    public PromotionEntity getPromotionEntity() {
        return promotionEntity;
    }

    public void setPromotionEntity(PromotionEntity promotionEntity) {
        this.promotionEntity = promotionEntity;
    }
}
