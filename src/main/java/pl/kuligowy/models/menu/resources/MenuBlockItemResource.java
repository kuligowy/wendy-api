/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.menu.resources;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.hateoas.ResourceSupport;
import pl.kuligowy.models.menu.MenuBlockItem;

/**
 *
 * @author coolig
 */
@JsonRootName(value = "menuBlockItem")
public class MenuBlockItemResource extends ResourceSupport {

//    private Integer id;
    private String title;
    private Integer statusId;
    private Integer sort;

    public MenuBlockItemResource(MenuBlockItem mbi) {
//        this.id = mbi.getId();
        this.title = mbi.getTitle();
        this.statusId = mbi.getStatusId();
        this.sort = mbi.getSort();
    }

//    @JsonProperty(value = "id")
//    public Integer getObjectId() {
//        return id;
//    }
//    public void setId(Integer id) {
//        this.id = id;
//    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
