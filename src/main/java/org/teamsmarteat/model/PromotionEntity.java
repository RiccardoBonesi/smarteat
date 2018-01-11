package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "promotion")
public class PromotionEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idpromotion")
    private int promotionId;

    @Column(name = "name")
    private String name;

    @Column(name = "pricepromo")
    private double price;

    @Column(name = "description")
    private String description;
    @ManyToMany
    @JoinTable(name = "promotion_menu",
            joinColumns = @JoinColumn(name = "promotion_idpromotion"),
            inverseJoinColumns = @JoinColumn(name = "dish_iddish"))
    private List<DishEntity> dishes;

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public List<DishEntity> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishEntity> dishes) {
        this.dishes = dishes;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
