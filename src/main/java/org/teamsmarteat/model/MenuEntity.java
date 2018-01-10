package org.teamsmarteat.model;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class MenuEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idmenu")
    private int menuId;

    @Column(name = "name")
    private String name;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
