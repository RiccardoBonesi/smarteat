package org.teamsmarteat.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "smarteatschema", catalog = "")
public class CategoryEntity {
    private int idcategory;
    private String name;
    private Collection<DishEntity> dishesByIdcategory;
    private Collection<PromotionMenuEntity> promotionMenusByIdcategory;

    @Id
    @Column(name = "idcategory")
    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
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
        CategoryEntity that = (CategoryEntity) o;
        return idcategory == that.idcategory &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idcategory, name);
    }

    @OneToMany(mappedBy = "categoryByCategoryIdcategory")
    public Collection<DishEntity> getDishesByIdcategory() {
        return dishesByIdcategory;
    }

    public void setDishesByIdcategory(Collection<DishEntity> dishesByIdcategory) {
        this.dishesByIdcategory = dishesByIdcategory;
    }

    @OneToMany(mappedBy = "categoryByCategoryIdcategory")
    public Collection<PromotionMenuEntity> getPromotionMenusByIdcategory() {
        return promotionMenusByIdcategory;
    }

    public void setPromotionMenusByIdcategory(Collection<PromotionMenuEntity> promotionMenusByIdcategory) {
        this.promotionMenusByIdcategory = promotionMenusByIdcategory;
    }
}
