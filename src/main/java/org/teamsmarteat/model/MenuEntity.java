package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "menu", schema = "smarteatschema", catalog = "")
public class MenuEntity {
    private int idmenu;
    private String name;
    private Collection<DishEntity> dishesByIdmenu;
    private Collection<RestaurantEntity> restaurantsByIdmenu;

    @Id
    @Column(name = "idmenu")
    public int getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuEntity that = (MenuEntity) o;
        return idmenu == that.idmenu &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idmenu, name);
    }

    @OneToMany(mappedBy = "menuByMenuIdmenu")
    public Collection<DishEntity> getDishesByIdmenu() {
        return dishesByIdmenu;
    }

    public void setDishesByIdmenu(Collection<DishEntity> dishesByIdmenu) {
        this.dishesByIdmenu = dishesByIdmenu;
    }

    @OneToMany(mappedBy = "menuByMenuIdmenu")
    public Collection<RestaurantEntity> getRestaurantsByIdmenu() {
        return restaurantsByIdmenu;
    }

    public void setRestaurantsByIdmenu(Collection<RestaurantEntity> restaurantsByIdmenu) {
        this.restaurantsByIdmenu = restaurantsByIdmenu;
    }
}
