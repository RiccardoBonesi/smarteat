package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "restaurant", schema = "smarteatschema", catalog = "")
public class RestaurantEntity {
    private int idrestaurant;
    private String name;
    private String address;
    private int menuIdmenu;
    private int userIduser;

    @Id
    @Column(name = "idrestaurant")
    public int getIdrestaurant() {
        return idrestaurant;
    }

    public void setIdrestaurant(int idrestaurant) {
        this.idrestaurant = idrestaurant;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantEntity that = (RestaurantEntity) o;
        return idrestaurant == that.idrestaurant &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idrestaurant, name, address);
    }

    @Basic
    @Column(name = "menu_idmenu")
    public int getMenuIdmenu() {
        return menuIdmenu;
    }

    public void setMenuIdmenu(int menuIdmenu) {
        this.menuIdmenu = menuIdmenu;
    }

    @Basic
    @Column(name = "user_iduser")
    public int getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(int userIduser) {
        this.userIduser = userIduser;
    }
}
