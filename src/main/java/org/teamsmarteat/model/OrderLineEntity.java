package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_line", schema = "smarteatschema", catalog = "")
@IdClass(OrderLineEntityPK.class)
public class OrderLineEntity {
    private int dishIddish;
    private int orderIdorder;
    private int promotionIdpromotion;
    private int quantity;
    private String note;
    private DishEntity dishByDishIddish;
    private OrderEntity orderByOrderIdorder;
    private PromotionEntity promotionByPromotionIdpromotion;

    @Id
    @Column(name = "dish_iddish")
    public int getDishIddish() {
        return dishIddish;
    }

    public void setDishIddish(int dishIddish) {
        this.dishIddish = dishIddish;
    }

    @Id
    @Column(name = "order_idorder")
    public int getOrderIdorder() {
        return orderIdorder;
    }

    public void setOrderIdorder(int orderIdorder) {
        this.orderIdorder = orderIdorder;
    }

    @Id
    @Column(name = "promotion_idpromotion")
    public int getPromotionIdpromotion() {
        return promotionIdpromotion;
    }

    public void setPromotionIdpromotion(int promotionIdpromotion) {
        this.promotionIdpromotion = promotionIdpromotion;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineEntity that = (OrderLineEntity) o;
        return dishIddish == that.dishIddish &&
                orderIdorder == that.orderIdorder &&
                promotionIdpromotion == that.promotionIdpromotion &&
                quantity == that.quantity &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dishIddish, orderIdorder, promotionIdpromotion, quantity, note);
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
    @JoinColumn(name = "order_idorder", referencedColumnName = "idorder", nullable = false)
    public OrderEntity getOrderByOrderIdorder() {
        return orderByOrderIdorder;
    }

    public void setOrderByOrderIdorder(OrderEntity orderByOrderIdorder) {
        this.orderByOrderIdorder = orderByOrderIdorder;
    }

    @ManyToOne
    @JoinColumn(name = "promotion_idpromotion", referencedColumnName = "idpromotion", nullable = false)
    public PromotionEntity getPromotionByPromotionIdpromotion() {
        return promotionByPromotionIdpromotion;
    }

    public void setPromotionByPromotionIdpromotion(PromotionEntity promotionByPromotionIdpromotion) {
        this.promotionByPromotionIdpromotion = promotionByPromotionIdpromotion;
    }
}
