package org.teamsmarteat.model;

import javax.persistence.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Locale;

@Entity
@Table(name = "dish")
public class DishEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "iddish")
    private int DishId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToOne
    private CategoryEntity category;

    @ManyToOne
    private MenuEntity menu;

    @ManyToMany
    @JoinTable(name = "dish_has_ingredients",
            joinColumns = @JoinColumn(name = "dish_iddish"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_idingredients"))
    private Collection<IngredientEntity> ingredients;

    public int getDishId() {
        return DishId;
    }

    public void setDishId(int dishId) {
        DishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() { return enabled; }

    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public MenuEntity getMenu() {
        return menu;
    }

    public void setMenu(MenuEntity menu) {
        this.menu = menu;
    }

    public Collection<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

}
