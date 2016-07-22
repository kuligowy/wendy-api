/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.menu;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author mkuligowski
 */
@Table(name = "menu")
@Entity
public class MenuBlock {

    @Id
    private Long id;
    @Column(name = "position")
    private int position;
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "menuBlock")
    private List<MenuBlockItem> menuBlockItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MenuBlockItem> getMenuBlockItems() {
        return menuBlockItems;
    }

    public void setMenuBlockItems(List<MenuBlockItem> menuBlockItems) {
        this.menuBlockItems = menuBlockItems;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
