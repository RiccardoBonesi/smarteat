package org.teamsmarteat.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_line")

public class OrderLineEntity {

    @Embeddable
    public static class OrderLinePK implements Serializable {
        private int dish_iddish;
        private int order_idorder;
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int idorderline;

        public OrderLinePK () {}

        public OrderLinePK (int dishId, int orderId, int idorderline) {
            this.dish_iddish = dishId;
            this.order_idorder = orderId;
            this.idorderline = idorderline;
        }

        public int getDish_iddish() {
            return dish_iddish;
        }

        public void setDish_iddish(int dish_iddish) {
            this.dish_iddish = dish_iddish;
        }

        public int getOrder_idorder() {
            return order_idorder;
        }

        public void setOrder_idorder(int order_idorder) {
            this.order_idorder = order_idorder;
        }

        public int getIdorderline() {
            return idorderline;
        }

        public void setIdorderline(int orderLineId) {
            this.idorderline = orderLineId;
        }
    }

    @EmbeddedId
    private OrderLinePK pk;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "note")
    private String notes;

    @ManyToOne
    @JoinColumn(name="dish_iddish", insertable = false, updatable = false)
    private DishEntity dish;

    @ManyToOne
    @JoinColumn(name="order_idorder", insertable = false, updatable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name="promotion_idpromotion", insertable = false, updatable = false)
    private PromotionEntity promotion;

    public OrderLinePK getPk() {
        return pk;
    }

    public void setPk(OrderLinePK pk) {
        this.pk = pk;
    }

    public DishEntity getDish() {
        return dish;
    }

    public void setDish(DishEntity dish) {
        this.dish = dish;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public PromotionEntity getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
