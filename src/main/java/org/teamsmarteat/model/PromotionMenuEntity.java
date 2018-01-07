package org.teamsmarteat.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "promotion_menu")
public class PromotionMenuEntity {

    @Embeddable
    public static class PromotionMenuEntityPK implements Serializable {

        private int promotion_idpromotion;
        private int dish_iddish;
        private int category_idcategory;

        public PromotionMenuEntityPK() {}

        public PromotionMenuEntityPK(int promotionId, int dish, int category) {
            this.promotion_idpromotion = promotionId;
            this.dish_iddish = dish;
            this.category_idcategory = category;
        }

        public int getPromotion_idpromotion() {
            return promotion_idpromotion;
        }

        public void setPromotion_idpromotion(int promotionId) {
            this.promotion_idpromotion = promotionId;
        }

        public int getDish_iddish() {
            return dish_iddish;
        }

        public void setDish_iddish(int dish) {
            this.dish_iddish = dish;
        }

        public int getCategory_idcategory() {
            return category_idcategory;
        }

        public void setCategory_idcategory(int category) {
            this.category_idcategory = category;
        }
    }

    @EmbeddedId
    private PromotionMenuEntityPK pk;

    @ManyToOne
    @JoinColumn(name = "dish_iddish", insertable = false, updatable = false)
    private DishEntity dish;

    @ManyToOne
    @JoinColumn(name = "category_idcategory", insertable = false, updatable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "promotion_idpromotion", insertable = false, updatable = false)
    private PromotionEntity promotion;

    public PromotionMenuEntityPK getPk() {
        return pk;
    }

    public void setPk(PromotionMenuEntityPK pk) {
        this.pk = pk;
    }

    public DishEntity getDish() {
        return dish;
    }

    public void setDish(DishEntity dish) {
        this.dish = dish;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public PromotionEntity getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }
}