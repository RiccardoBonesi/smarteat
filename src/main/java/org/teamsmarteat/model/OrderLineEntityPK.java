package org.teamsmarteat.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderLineEntityPK implements Serializable {
    private int dishIddish;
    private int orderIdorder;
    private int promotionIdpromotion;

    @Column(name = "dish_iddish")
    @Id
    public int getDishIddish() {
        return dishIddish;
    }

    public void setDishIddish(int dishIddish) {
        this.dishIddish = dishIddish;
    }

    @Column(name = "order_idorder")
    @Id
    public int getOrderIdorder() {
        return orderIdorder;
    }

    public void setOrderIdorder(int orderIdorder) {
        this.orderIdorder = orderIdorder;
    }

    @Column(name = "promotion_idpromotion")
    @Id
    public int getPromotionIdpromotion() {
        return promotionIdpromotion;
    }

    public void setPromotionIdpromotion(int promotionIdpromotion) {
        this.promotionIdpromotion = promotionIdpromotion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineEntityPK that = (OrderLineEntityPK) o;
        return dishIddish == that.dishIddish &&
                orderIdorder == that.orderIdorder &&
                promotionIdpromotion == that.promotionIdpromotion;
    }

    @Override
    public int hashCode() {

        return Objects.hash(dishIddish, orderIdorder, promotionIdpromotion);
    }
}
