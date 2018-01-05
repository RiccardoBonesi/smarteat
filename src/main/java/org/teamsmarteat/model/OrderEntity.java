package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "order", schema = "smarteatschema", catalog = "")
public class OrderEntity {
    private int idorder;
    private Double totalPrice;
    private String tableNumber;
    private Collection<OrderLineEntity> orderLinesByIdorder;

    @Id
    @Column(name = "idorder")
    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    @Basic
    @Column(name = "total_price")
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "table_number")
    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return idorder == that.idorder &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(tableNumber, that.tableNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idorder, totalPrice, tableNumber);
    }

    @OneToMany(mappedBy = "orderByOrderIdorder")
    public Collection<OrderLineEntity> getOrderLinesByIdorder() {
        return orderLinesByIdorder;
    }

    public void setOrderLinesByIdorder(Collection<OrderLineEntity> orderLinesByIdorder) {
        this.orderLinesByIdorder = orderLinesByIdorder;
    }
}
