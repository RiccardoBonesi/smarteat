package org.teamsmarteat.model;

import javax.persistence.*;

@Entity
@Table(name = "ordination")
public class OrderEntity {

    @Id
    @GeneratedValue()
    @Column(name = "idorder")
    private int orderId;

    @Column(name = "total_price")
    private double amount;

    @Column(name = "table_number")
    private String tableNumber;

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

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }
}
