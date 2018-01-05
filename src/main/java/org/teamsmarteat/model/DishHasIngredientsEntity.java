package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dish_has_ingredients", schema = "smarteatschema", catalog = "")
@IdClass(DishHasIngredientsEntityPK.class)
public class DishHasIngredientsEntity {
    private int dishIddish;
    private int ingredientsIdingredients;
    private DishEntity dishByDishIddish;
    private IngredientsEntity ingredientsByIngredientsIdingredients;

    @Id
    @Column(name = "dish_iddish")
    public int getDishIddish() {
        return dishIddish;
    }

    public void setDishIddish(int dishIddish) {
        this.dishIddish = dishIddish;
    }

    @Id
    @Column(name = "ingredients_idingredients")
    public int getIngredientsIdingredients() {
        return ingredientsIdingredients;
    }

    public void setIngredientsIdingredients(int ingredientsIdingredients) {
        this.ingredientsIdingredients = ingredientsIdingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishHasIngredientsEntity that = (DishHasIngredientsEntity) o;
        return dishIddish == that.dishIddish &&
                ingredientsIdingredients == that.ingredientsIdingredients;
    }

    @Override
    public int hashCode() {

        return Objects.hash(dishIddish, ingredientsIdingredients);
    }

    @ManyToOne
    @JoinColumn(name = "dish_iddish", referencedColumnName = "iddish", nullable = false)
    public DishEntity getDishByDishIddish() {
        return dishByDishIddish;
    }

    public void setDishByDishIddish(DishEntity dishByDishIddish) {
        this.dishByDishIddish = dishByDishIddish;
    }

    @ManyToOne
    @JoinColumn(name = "ingredients_idingredients", referencedColumnName = "idingredients", nullable = false)
    public IngredientsEntity getIngredientsByIngredientsIdingredients() {
        return ingredientsByIngredientsIdingredients;
    }

    public void setIngredientsByIngredientsIdingredients(IngredientsEntity ingredientsByIngredientsIdingredients) {
        this.ingredientsByIngredientsIdingredients = ingredientsByIngredientsIdingredients;
    }
}
