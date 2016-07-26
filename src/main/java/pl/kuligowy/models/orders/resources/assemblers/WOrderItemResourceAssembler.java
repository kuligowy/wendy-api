/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.orders.resources.assemblers;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import pl.kuligowy.rest.WOrderItemRestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import pl.kuligowy.models.orders.WOrderItem;
import pl.kuligowy.models.orders.resources.WOrderItemResource;

/**
 *
 * @author coolig
 */
@Component
public class WOrderItemResourceAssembler extends ResourceAssemblerSupport<WOrderItem, WOrderItemResource> {

    public WOrderItemResourceAssembler() {
        super(WOrderItemRestController.class, WOrderItemResource.class);
    }

    @Override
    public WOrderItemResource toResource(WOrderItem entity) {
        WOrderItemResource mbr = new WOrderItemResource(entity);
        List<Link> links = Lists.newArrayList();
//        links.add(linkTo(methodOn(WOrderItemRestController.class).getWOrderItems(entity.getId())).withRel("items"));
        links.add(linkTo(methodOn(WOrderItemRestController.class).getWOrderItem(entity.getId())).withSelfRel());


        mbr.add(links);
        return mbr;
    }
}
