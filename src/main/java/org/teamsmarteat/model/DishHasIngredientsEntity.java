package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dish_has_ingredients", schema = "smarteatschema", catalog = "")
@IdClass(DishHasIngredientsEntityPK.class)
public class DishHasIngredientsEntity {
    private int dishIddish;
    private int ingredientsIdingredients;

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
}
