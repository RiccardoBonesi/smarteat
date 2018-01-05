package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "promotion_menu", schema = "smarteatschema", catalog = "")
@IdClass(PromotionMenuEntityPK.class)
public class PromotionMenuEntity {
    private int promotionIdpromotion;
    private int dishIddish;
    private int categoryIdcategory;
    private PromotionEntity promotionByPromotionIdpromotion;
    private DishEntity dishByDishIddish;
    private CategoryEntity categoryByCategoryIdcategory;

    @Id
    @Column(name = "promotion_idpromotion")
    public int getPromotionIdpromotion() {
        return promotionIdpromotion;
    }

    public void setPromotionIdpromotion(int promotionIdpromotion) {
        this.promotionIdpromotion = promotionIdpromotion;
    }

    @Id
    @Column(name = "dish_iddish")
    public int getDishIddish() {
        return dishIddish;
    }

    public void setDishIddish(int dishIddish) {
        this.dishIddish = dishIddish;
    }

    @Id
    @Column(name = "category_idcategory")
    public int getCategoryIdcategory() {
        return categoryIdcategory;
    }

    public void setCategoryIdcategory(int categoryIdcategory) {
        this.categoryIdcategory = categoryIdcategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromotionMenuEntity that = (PromotionMenuEntity) o;
        return promotionIdpromotion == that.promotionIdpromotion &&
                dishIddish == that.dishIddish &&
                categoryIdcategory == that.categoryIdcategory;
    }

    @Override
    public int hashCode() {

        return Objects.hash(promotionIdpromotion, dishIddish, categoryIdcategory);
    }

    @ManyToOne
    @JoinColumn(name = "promotion_idpromotion", referencedColumnName = "idpromotion", nullable = false)
    public PromotionEntity getPromotionByPromotionIdpromotion() {
        return promotionByPromotionIdpromotion;
    }

    public void setPromotionByPromotionIdpromotion(PromotionEntity promotionByPromotionIdpromotion) {
        this.promotionByPromotionIdpromotion = promotionByPromotionIdpromotion;
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
    @JoinColumn(name = "category_idcategory", referencedColumnName = "idcategory", nullable = false)
    public CategoryEntity getCategoryByCategoryIdcategory() {
        return categoryByCategoryIdcategory;
    }

    public void setCategoryByCategoryIdcategory(CategoryEntity categoryByCategoryIdcategory) {
        this.categoryByCategoryIdcategory = categoryByCategoryIdcategory;
    }
}
