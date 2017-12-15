package org.teamsmarteat.model;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @Column(name = "idmenu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
