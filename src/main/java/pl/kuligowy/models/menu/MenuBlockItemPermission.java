/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.menu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pl.kuligowy.models.users.Permission;

/**
 *
 * @author mkuligowski
 */
@Table(name = "menu_item_permission")
@Entity
public class MenuBlockItemPermission {

    @Id
    private Long id;
    @OneToOne
    private Permission permission;
    @OneToOne
    private MenuBlockItem menuBlockItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuBlockItem getMenuBlockItem() {
        return menuBlockItem;
    }

    public void setMenuBlockItem(MenuBlockItem menuBlockItem) {
        this.menuBlockItem = menuBlockItem;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
