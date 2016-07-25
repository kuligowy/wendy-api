/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.menu.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;
import pl.kuligowy.models.menu.MenuBlock;
import pl.kuligowy.models.menu.MenuBlockItem;

/**
 *
 * @author coolig
 */
@Relation(value = "menuBlockItem", collectionRelation = "menuBlockItems")
public class MenuBlockResource extends ResourceSupport {

    private Integer id;
    private String title;
    private Integer sort;
    private List<MenuBlockItemResource> menuBlockItemList;
//    private List<MenuBlockItem> menuBlockItemList;

    public MenuBlockResource(MenuBlock mb) {
        this.id = mb.getId();
        this.title = mb.getTitle();
        this.sort = mb.getSort();
//        this.menuBlockItemList = mb.getMenuBlockItemList();
    }

    @JsonProperty(value = "id")
    public Integer getObjectId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<MenuBlockItemResource> getMenuBlockItemList() {
        return menuBlockItemList;
    }

    public void setMenuBlockItemList(List<MenuBlockItemResource> menuBlockItemList) {
        this.menuBlockItemList = menuBlockItemList;
    }
}
