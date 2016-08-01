/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.orders.resources.assemblers;

import com.google.common.collect.Lists;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.resources.WOrderResource;
import pl.kuligowy.rest.WOrderActionRestController;
import pl.kuligowy.rest.WOrderRestController;
import pl.kuligowy.models.methods.Action;
import pl.kuligowy.services.status_services.StatusService;
import pl.kuligowy.services.status_services.StatusServiceFactory;

/**
 *
 * @author coolig
 */
@Component
public class WOrderResourceAssembler extends ResourceAssemblerSupport<WOrder, WOrderResource> {

    @Autowired
    private StatusServiceFactory serviceFactory;

    public WOrderResourceAssembler() {
        super(WOrderRestController.class, WOrderResource.class);
    }

    @Override
    public WOrderResource toResource(WOrder entity) {
        WOrderResource mbr = new WOrderResource(entity);
        List<Link> links = Lists.newArrayList();
        links.add(linkTo(methodOn(WOrderRestController.class, entity.getId()).getWOrderItems(entity.getId())).withRel("items"));
        links.add(new Link(linkTo(WOrderActionRestController.class, entity.getId()).toUriComponentsBuilder().toUriString(),"actions"));
//        Link link = new Link(linkTo(WOrderRestController.class).toUriComponentsBuilder().queryParam("statusId", statusId).toUriString(), "self");        
//links.add(linkTo(methodOn(WOrderActionRestController.class, entity.getId()).getActions(entity.getId())).withRel("actions"));
        links.add(linkTo(methodOn(WOrderRestController.class).getWOrder(entity.getId(), null)).withSelfRel());
        mbr.add(links);
        //        mbr.add(createActionLinks(entity));
//        mbr.setActionList(createActions(entity));
        return mbr;
    }
 

    private List<Link> createActionLinks(WOrder wos) {
        List<Link> list = Lists.newArrayList();

        StatusService ss = serviceFactory.getStatusService(wos);
        System.out.println("ss " + ss.getClass());
        list.addAll(Arrays.asList(ss.getClass().getDeclaredMethods())
                .stream()
                .filter((Method t) -> Modifier.isPublic(t.getModifiers()))
                .map((m) -> linkTo(m, wos.getId()).withRel(m.getName())).collect(Collectors.toList()));
        System.out.println(list.size());
        return list;
    }
}
