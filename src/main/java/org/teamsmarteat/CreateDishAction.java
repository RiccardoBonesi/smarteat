package org.teamsmarteat;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.teamsmarteat.model.CategoryEntity;
import org.teamsmarteat.model.DishEntity;
import org.teamsmarteat.model.IngredientEntity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import java.util.List;

public class CreateDishAction extends ActionSupport {

    private DishEntity dishEntity;
    private List<IngredientEntity> resultIngredient;
    private List<CategoryEntity> resultCategory;
    private IngredientEntity ingredientEntity;
    private CategoryEntity categoryEntity;
    private static Logger logger = LogManager.getLogger(DishListAction.class);
    private EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");

    public String execute() {
        EntityManager em = factory.createEntityManager();
        Query queryDish = em.createQuery("select d from IngredientEntity d");
        resultIngredient = queryDish.getResultList();

        em = factory.createEntityManager();
        Query queryCategory = em.createQuery("select c from CategoryEntity c");
        resultCategory = queryCategory.getResultList();

        return SUCCESS;
    }


    public String confirm_dish () {

        EntityManager em = factory.createEntityManager();

        dishEntity.setEnabled(true);



        return SUCCESS;
    }



    public IngredientEntity getIngredientEntity() {
        return ingredientEntity;
    }

    public void setIngredientEntity(IngredientEntity ingredientEntity) {
        this.ingredientEntity = ingredientEntity;
    }

    public List getResultIngredient() {
        return resultIngredient;
    }

    public void setDishEntity(DishEntity dishEntity) {
        this.dishEntity = dishEntity;
    }

    public DishEntity getDishEntity() {
        return dishEntity;
    }

    public List getResultCategory() {
        return resultCategory;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

}
