package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "dish", schema = "smarteatschema", catalog = "")
public class DishEntity {
    private int iddish;
    private String name;
    private double price;
    private String description;
    private int categoryIdcategory;
    private int menuIdmenu;
    private CategoryEntity categoryByCategoryIdcategory;
    private MenuEntity menuByMenuIdmenu;
    private Collection<DishHasIngredientsEntity> dishHasIngredientsByIddish;
    private Collection<OrderLineEntity> orderLinesByIddish;
    private Collection<PromotionMenuEntity> promotionMenusByIddish;

    @Id
    @Column(name = "iddish")
    public int getIddish() {
        return iddish;
    }

    public void setIddish(int iddish) {
        this.iddish = iddish;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishEntity that = (DishEntity) o;
        return iddish == that.iddish &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(iddish, name, price, description);
    }

    @Basic
    @Column(name = "category_idcategory")
    public int getCategoryIdcategory() {
        return categoryIdcategory;
    }

    public void setCategoryIdcategory(int categoryIdcategory) {
        this.categoryIdcategory = categoryIdcategory;
    }

    @Basic
    @Column(name = "menu_idmenu")
    public int getMenuIdmenu() {
        return menuIdmenu;
    }

    public void setMenuIdmenu(int menuIdmenu) {
        this.menuIdmenu = menuIdmenu;
    }

    @ManyToOne
    @JoinColumn(name = "category_idcategory", referencedColumnName = "idcategory", nullable = false)
    public CategoryEntity getCategoryByCategoryIdcategory() {
        return categoryByCategoryIdcategory;
    }

    public void setCategoryByCategoryIdcategory(CategoryEntity categoryByCategoryIdcategory) {
        this.categoryByCategoryIdcategory = categoryByCategoryIdcategory;
    }

    @ManyToOne
    @JoinColumn(name = "menu_idmenu", referencedColumnName = "idmenu", nullable = false)
    public MenuEntity getMenuByMenuIdmenu() {
        return menuByMenuIdmenu;
    }

    public void setMenuByMenuIdmenu(MenuEntity menuByMenuIdmenu) {
        this.menuByMenuIdmenu = menuByMenuIdmenu;
    }

    @OneToMany(mappedBy = "dishByDishIddish")
    public Collection<DishHasIngredientsEntity> getDishHasIngredientsByIddish() {
        return dishHasIngredientsByIddish;
    }

    public void setDishHasIngredientsByIddish(Collection<DishHasIngredientsEntity> dishHasIngredientsByIddish) {
        this.dishHasIngredientsByIddish = dishHasIngredientsByIddish;
    }

    @OneToMany(mappedBy = "dishByDishIddish")
    public Collection<OrderLineEntity> getOrderLinesByIddish() {
        return orderLinesByIddish;
    }

    public void setOrderLinesByIddish(Collection<OrderLineEntity> orderLinesByIddish) {
        this.orderLinesByIddish = orderLinesByIddish;
    }

    @OneToMany(mappedBy = "dishByDishIddish")
    public Collection<PromotionMenuEntity> getPromotionMenusByIddish() {
        return promotionMenusByIddish;
    }

    public void setPromotionMenusByIddish(Collection<PromotionMenuEntity> promotionMenusByIddish) {
        this.promotionMenusByIddish = promotionMenusByIddish;
    }
}
