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

import java.util.List;

public class CreateDishAction extends ActionSupport {

    private List<IngredientEntity> resultIngredient;
    private IngredientEntity ingredientEntity;

    private static Logger logger = LogManager.getLogger(DishListAction.class);
    private EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");

    public String execute() {
        EntityManager em = factory.createEntityManager();
        Query queryDish = em.createQuery("select d from IngredientEntity d");
        resultIngredient = queryDish.getResultList();
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


}
