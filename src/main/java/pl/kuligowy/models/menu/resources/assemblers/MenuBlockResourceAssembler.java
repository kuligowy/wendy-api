/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.menu.resources.assemblers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import pl.kuligowy.models.menu.MenuBlock;
import pl.kuligowy.models.menu.resources.MenuBlockItemResource;
import pl.kuligowy.models.menu.resources.MenuBlockResource;
import pl.kuligowy.rest.UserRestController;

/**
 *
 * @author coolig
 */
@Component
public class MenuBlockResourceAssembler extends ResourceAssemblerSupport<MenuBlock, MenuBlockResource> {

    private Long userId;
    private final MenuBlockItemResourceAssembler itemAssembler;

    @Autowired
    public MenuBlockResourceAssembler(MenuBlockItemResourceAssembler assembler) {
        super(UserRestController.class, MenuBlockResource.class);
        this.itemAssembler = assembler;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public MenuBlockResource toResource(MenuBlock entity) {
        itemAssembler.setUserId(userId);
        List<MenuBlockItemResource> list = itemAssembler.toResources(entity.getMenuBlockItemList());
        MenuBlockResource mbr = new MenuBlockResource(entity);
        mbr.setMenuBlockItemList(list);
        Link linkself = linkTo(methodOn(UserRestController.class).getMenu(userId)).withSelfRel();
        mbr.add(linkself);
        return mbr;
    }
}
