package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordination")
public class OrderEntity {

    @Id
    @Column(name = "idorder")
    private int orderId;

    @Column(name = "total_price")
    private double amount;

    @Column(name ="date")
    private Date date;

    @Column(name = "checkout")
    private  boolean checkout;

    @Column(name = "table_number")
    private String tableNumber;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "order")
    private List<OrderLineEntity> orderLines;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public List<OrderLineEntity> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineEntity> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                ", date=" + date +
                ", checkout=" + checkout +
                ", tableNumber='" + tableNumber + '\'' +
                ", orderLines=" + orderLines +
                '}';
    }
}
