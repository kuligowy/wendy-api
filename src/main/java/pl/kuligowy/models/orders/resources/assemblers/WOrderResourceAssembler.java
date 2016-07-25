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
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.resources.WOrderResource;
import pl.kuligowy.rest.WOrderRestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 *
 * @author coolig
 */
@Component
public class WOrderResourceAssembler extends ResourceAssemblerSupport<WOrder, WOrderResource> {

    public WOrderResourceAssembler() {
        super(WOrderRestController.class, WOrderResource.class);
    }

    @Override
    public WOrderResource toResource(WOrder entity) {
        WOrderResource mbr = new WOrderResource(entity);
        List<Link> links = Lists.newArrayList();
        links.add(linkTo(methodOn(WOrderRestController.class, entity.getId()).getWOrderItems(entity.getId())).withRel("items"));
        links.add(linkTo(methodOn(WOrderRestController.class).getWOrder(entity.getId())).withSelfRel());
        mbr.add(links);
        return mbr;
    }
}
