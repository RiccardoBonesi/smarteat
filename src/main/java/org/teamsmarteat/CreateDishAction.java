package org.teamsmarteat;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.teamsmarteat.model.CategoryEntity;
import org.teamsmarteat.model.DishEntity;
import org.teamsmarteat.model.IngredientEntity;
import org.teamsmarteat.model.MenuEntity;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import java.util.*;

public class CreateDishAction extends ActionSupport {

    private DishEntity dishEntity;
    private List<IngredientEntity> resultIngredient;
    private List<IngredientEntity> checkboxIngredient;
    private List<CategoryEntity> resultCategory;
    private IngredientEntity ingredientEntity;
    private CategoryEntity categoryEntity;
    private static Logger logger = LogManager.getLogger(DishListAction.class);
    private EntityManagerFactory factory = PersistenceManager.getInstance().getEntityManagerFactory("unit1");
    private String action_value;
    private String ingredientName;
    private List<String> checkBoxes;


    //TODO TENERE SEMPRE VISIBILI LE CHECKBOXE GIA SELEZIONATE APPENDENDO QUELLE SELEZIONATE AL RISULTATO DELLA QUERY SUGLI INGREDIENTI

    public String execute() {
        EntityManager em = factory.createEntityManager();


        if (resultIngredient == null) {
            Query queryDish = em.createQuery("select d from IngredientEntity d");
            resultIngredient = queryDish.getResultList();
        } else {
            resultIngredient.addAll(checkboxIngredient);

            Set<IngredientEntity> hs = new LinkedHashSet<>(resultIngredient);
            resultIngredient.clear();
            resultIngredient.addAll(hs);
        }
        em = factory.createEntityManager();
        Query queryCategory = em.createQuery("select c from CategoryEntity c");
        resultCategory = queryCategory.getResultList();


        return SUCCESS;
    }

    public String confirm_dish() {

        EntityManager em = factory.createEntityManager();
        if (action_value.equalsIgnoreCase("search_ing")) {

            Query query = em.createQuery("SELECT i FROM IngredientEntity i WHERE i.name LIKE ?");
            resultIngredient = query.setParameter(0, "%" + ingredientName + "%").getResultList();

            checkboxIngredient = new ArrayList<IngredientEntity>();

            if (!(checkBoxes == null)) {
                for (String ingId : checkBoxes) {
                    checkboxIngredient.add(em.find(IngredientEntity.class, Integer.valueOf(ingId)));
                }
            }


            execute();
            return ERROR;

        } else {
            dishEntity.setEnabled(true);
            if (categoryEntity!=null && dishEntity.getName().isEmpty() && dishEntity.getPrice()>0){
                categoryEntity = em.find(CategoryEntity.class, categoryEntity.getCategoryId());
                dishEntity.setCategory(categoryEntity);
            } else{
                return "nocategory";
            }


            checkboxIngredient = new ArrayList<IngredientEntity>();
            if (!(checkBoxes == null)) {
                for (String ingId : checkBoxes) {
                    checkboxIngredient.add(em.find(IngredientEntity.class, Integer.valueOf(ingId)));
                }
            }

            dishEntity.setIngredients(checkboxIngredient);

            dishEntity.setMenu(em.find(MenuEntity.class, 1));


            em.getTransaction().begin();
            em.persist(dishEntity); //em.merge(u); for updates
            em.getTransaction().commit();
            em.close();

            return SUCCESS;
        }


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

    public List<String> getCheckBoxes() {
        return checkBoxes;
    }

    public List<IngredientEntity> getCheckboxIngredient() {
        return checkboxIngredient;
    }

    public void setCheckboxIngredient(List<IngredientEntity> checkboxIngredient) {
        this.checkboxIngredient = checkboxIngredient;
    }

    public String getAction_value() {
        return action_value;
    }

    public void setAction_value(String action_value) {
        this.action_value = action_value;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public void setCheckBoxes(List<String> checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

}
