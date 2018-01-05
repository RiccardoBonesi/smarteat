package org.teamsmarteat.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DishHasIngredientsEntityPK implements Serializable {
    private int dishIddish;
    private int ingredientsIdingredients;

    @Column(name = "dish_iddish")
    @Id
    public int getDishIddish() {
        return dishIddish;
    }

    public void setDishIddish(int dishIddish) {
        this.dishIddish = dishIddish;
    }

    @Column(name = "ingredients_idingredients")
    @Id
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
        DishHasIngredientsEntityPK that = (DishHasIngredientsEntityPK) o;
        return dishIddish == that.dishIddish &&
                ingredientsIdingredients == that.ingredientsIdingredients;
    }

    @Override
    public int hashCode() {

        return Objects.hash(dishIddish, ingredientsIdingredients);
    }
}
