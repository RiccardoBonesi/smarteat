package org.teamsmarteat.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class RestaurantEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idrestaurant")
    private int restaurantId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "number_tables")
    private int maxTables;

    @Column(name = "userid")
    private String username;

    @Column(name = "password")
    private String keyid;

    @ManyToOne
    private MenuEntity menu;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MenuEntity getMenu() {
        return menu;
    }

    public void setMenu(MenuEntity menu) {
        this.menu = menu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public int getMaxTables() {
        return maxTables;
    }

    public void setMaxTables(int maxTables) {
        this.maxTables = maxTables;
    }
}
