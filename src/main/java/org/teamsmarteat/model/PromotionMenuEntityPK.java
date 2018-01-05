package org.teamsmarteat.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PromotionMenuEntityPK implements Serializable {
    private int promotionIdpromotion;
    private int dishIddish;
    private int categoryIdcategory;

    @Column(name = "promotion_idpromotion")
    @Id
    public int getPromotionIdpromotion() {
        return promotionIdpromotion;
    }

    public void setPromotionIdpromotion(int promotionIdpromotion) {
        this.promotionIdpromotion = promotionIdpromotion;
    }

    @Column(name = "dish_iddish")
    @Id
    public int getDishIddish() {
        return dishIddish;
    }

    public void setDishIddish(int dishIddish) {
        this.dishIddish = dishIddish;
    }

    @Column(name = "category_idcategory")
    @Id
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
        PromotionMenuEntityPK that = (PromotionMenuEntityPK) o;
        return promotionIdpromotion == that.promotionIdpromotion &&
                dishIddish == that.dishIddish &&
                categoryIdcategory == that.categoryIdcategory;
    }

    @Override
    public int hashCode() {

        return Objects.hash(promotionIdpromotion, dishIddish, categoryIdcategory);
    }
}
