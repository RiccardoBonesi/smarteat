package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ingredients", schema = "smarteatschema", catalog = "")
public class IngredientsEntity {
    private int idingredients;
    private String name;
    private Collection<DishHasIngredientsEntity> dishHasIngredientsByIdingredients;

    @Id
    @Column(name = "idingredients")
    public int getIdingredients() {
        return idingredients;
    }

    public void setIdingredients(int idingredients) {
        this.idingredients = idingredients;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientsEntity that = (IngredientsEntity) o;
        return idingredients == that.idingredients &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idingredients, name);
    }

    @OneToMany(mappedBy = "ingredientsByIngredientsIdingredients")
    public Collection<DishHasIngredientsEntity> getDishHasIngredientsByIdingredients() {
        return dishHasIngredientsByIdingredients;
    }

    public void setDishHasIngredientsByIdingredients(Collection<DishHasIngredientsEntity> dishHasIngredientsByIdingredients) {
        this.dishHasIngredientsByIdingredients = dishHasIngredientsByIdingredients;
    }
}
