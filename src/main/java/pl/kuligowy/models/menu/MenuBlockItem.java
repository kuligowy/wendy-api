/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.menu;

import javax.persistence.*;

/**
 *
 * @author mkuligowski
 */
@Entity
@Table(name = "menu_item")
public class MenuBlockItem {

    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "status_id")
    private Integer statusId;
    @ManyToOne
    private MenuBlock menuBlock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public MenuBlock getMenuBlock() {
        return menuBlock;
    }

    public void setMenuBlock(MenuBlock menuBlock) {
        this.menuBlock = menuBlock;
    }
}
