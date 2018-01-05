package org.teamsmarteat.model;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class IngredientEntity {

    @Id
    @GeneratedValue()
    @Column(name = "idingredients")
    private int ingredientId;

    @Column(name = "name")
    private String name;

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
