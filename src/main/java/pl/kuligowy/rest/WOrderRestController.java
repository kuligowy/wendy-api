/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kuligowy.dao.order.WOrderDao;
import pl.kuligowy.dao.repositiories.WOrderItemRepository;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.WOrderStatus;
import pl.kuligowy.models.orders.resources.HistoryEntry;
import pl.kuligowy.models.orders.resources.WOrderCollectionResource;
import pl.kuligowy.models.orders.resources.WOrderItemCollectionResource;
import pl.kuligowy.models.orders.resources.WOrderItemResource;
import pl.kuligowy.models.orders.resources.WOrderResource;
import pl.kuligowy.models.orders.resources.assemblers.WOrderItemResourceAssembler;
import pl.kuligowy.models.orders.resources.assemblers.WOrderResourceAssembler;
import pl.kuligowy.models.users.User;

/**
 *
 * @author coolig
 */
@RestController
@RequestMapping(path = "/worders")
public class WOrderRestController {

    private static final Logger logger = Logger.getLogger("WOrderRestController");

    private WOrderDao worderDao;
    private WOrderItemRepository itemRepo;
    private WOrderResourceAssembler assembler;
    private WOrderItemResourceAssembler assemblerItem;

    @Autowired
    public WOrderRestController(WOrderDao worderDao, WOrderResourceAssembler assembler, WOrderItemRepository itemRepo,
            WOrderItemResourceAssembler assemblerItem) {
        this.worderDao = worderDao;
        this.assembler = assembler;
        this.itemRepo = itemRepo;
        this.assemblerItem = assemblerItem;
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority(#statusId)")
    public WOrderCollectionResource getWOrders(@RequestParam(name = "statusId") Integer statusId,
            @AuthenticationPrincipal User user) {
        WOrderStatus wos = new WOrderStatus(statusId);
        logger.log(Level.INFO, "Principal {0} ", user.getLogin());
        List<WOrderResource> list = assembler.toResources(worderDao.getWOrders(wos, null, null, null));
        WOrderCollectionResource resource = new WOrderCollectionResource(list);
        Link link = new Link(linkTo(WOrderRestController.class).toUriComponentsBuilder().queryParam("statusId", statusId).toUriString(), "self");
        resource.add(link);
        return resource;
    }

    @RequestMapping(method = RequestMethod.POST)
    public WOrderResource addWorder(@RequestBody WOrder worder) {
        System.out.println("worder " + ReflectionToStringBuilder.toString(worder));
        worder = worderDao.addWorder(worder);
        return assembler.toResource(worder);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WOrderResource getWOrder(@PathVariable Integer id, @AuthenticationPrincipal User user) {
        System.out.println("user " + user);
        return assembler.toResource(worderDao.getWOrderById(id));
    }

    @RequestMapping(path = "/{id}/history", method = RequestMethod.GET)
    public HistoryEntry getWOrderHistory(@PathVariable Integer id) {
        HistoryEntry he = new HistoryEntry();
        he.setConfirmationDate(new Date());
        he.setWho("Ziobro");
        return he;
//        return assembler.toResource(worderDao.getWOrderById(id));
    }

    @RequestMapping(path = "/{id}/worderItems", method = RequestMethod.GET)
    public WOrderItemCollectionResource getWOrderItems(@PathVariable Integer id) {
        WOrder parent = new WOrder(id);
        List<WOrderItemResource> list = assemblerItem.toResources(itemRepo.findByWorderId(parent));
        WOrderItemCollectionResource collection = new WOrderItemCollectionResource(list);
        //linkTo(methodOn(InvoiceController.class).getInvoiceByCustomerId(customer.getId())).withRel("invoice");
        collection.add(linkTo(methodOn(WOrderRestController.class, id).getWOrderItems(id)).withSelfRel());
        return collection;
    }
}
