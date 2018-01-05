package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "smarteatschema", catalog = "")
public class UserEntity {
    private int iduser;
    private String password;
    private String username;
    private Collection<RestaurantEntity> restaurantsByIduser;

    @Id
    @Column(name = "iduser")
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return iduser == that.iduser &&
                Objects.equals(password, that.password) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(iduser, password, username);
    }

    @OneToMany(mappedBy = "userByUserIduser")
    public Collection<RestaurantEntity> getRestaurantsByIduser() {
        return restaurantsByIduser;
    }

    public void setRestaurantsByIduser(Collection<RestaurantEntity> restaurantsByIduser) {
        this.restaurantsByIduser = restaurantsByIduser;
    }
}
