/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.menu.resources.assemblers;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import pl.kuligowy.models.menu.MenuBlockItem;
import pl.kuligowy.models.menu.resources.MenuBlockItemResource;
import pl.kuligowy.rest.UserRestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import pl.kuligowy.rest.WOrderRestController;

/**
 *
 * @author coolig
 */
@Component
public class MenuBlockItemResourceAssembler extends ResourceAssemblerSupport<MenuBlockItem, MenuBlockItemResource> {

    private Long userId;
    
    public MenuBlockItemResourceAssembler() {
        super(UserRestController.class, MenuBlockItemResource.class);
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    @Override
    public MenuBlockItemResource toResource(MenuBlockItem entity) {
//        createResourceWithId(entity.getId(), entity)
        MenuBlockItemResource mbir = new MenuBlockItemResource(entity);
//        Link linkself = linkTo(methodOn(UserRestController.class).getMenu(userId)).withSelfRel();
        Link link = linkTo(methodOn(WOrderRestController.class)//
                    .getWOrders(entity.getStatusId())).withRel("orders");
        mbir.add(link);
//        mbir.add(linkself);
        return mbir;
    }

}
