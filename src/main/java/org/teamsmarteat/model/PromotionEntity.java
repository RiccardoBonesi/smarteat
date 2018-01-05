package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "promotion", schema = "smarteatschema", catalog = "")
public class PromotionEntity {
    private int idpromotion;
    private String name;
    private double pricepromo;
    private String description;
    private Collection<OrderLineEntity> orderLinesByIdpromotion;
    private Collection<PromotionMenuEntity> promotionMenusByIdpromotion;

    @Id
    @Column(name = "idpromotion")
    public int getIdpromotion() {
        return idpromotion;
    }

    public void setIdpromotion(int idpromotion) {
        this.idpromotion = idpromotion;
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
    @Column(name = "pricepromo")
    public double getPricepromo() {
        return pricepromo;
    }

    public void setPricepromo(double pricepromo) {
        this.pricepromo = pricepromo;
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
        PromotionEntity that = (PromotionEntity) o;
        return idpromotion == that.idpromotion &&
                Double.compare(that.pricepromo, pricepromo) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idpromotion, name, pricepromo, description);
    }

    @OneToMany(mappedBy = "promotionByPromotionIdpromotion")
    public Collection<OrderLineEntity> getOrderLinesByIdpromotion() {
        return orderLinesByIdpromotion;
    }

    public void setOrderLinesByIdpromotion(Collection<OrderLineEntity> orderLinesByIdpromotion) {
        this.orderLinesByIdpromotion = orderLinesByIdpromotion;
    }

    @OneToMany(mappedBy = "promotionByPromotionIdpromotion")
    public Collection<PromotionMenuEntity> getPromotionMenusByIdpromotion() {
        return promotionMenusByIdpromotion;
    }

    public void setPromotionMenusByIdpromotion(Collection<PromotionMenuEntity> promotionMenusByIdpromotion) {
        this.promotionMenusByIdpromotion = promotionMenusByIdpromotion;
    }
}
