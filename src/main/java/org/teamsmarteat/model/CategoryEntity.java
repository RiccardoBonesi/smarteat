package org.teamsmarteat.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idcategory")
    private int categoryId;

    @Column(name = "name")
    private String name;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
