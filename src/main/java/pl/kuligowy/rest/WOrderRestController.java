/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kuligowy.dao.order.WOrderDao;
import pl.kuligowy.dao.repositiories.WOrderItemRepository;
import pl.kuligowy.models.orders.WOrderStatus;
import pl.kuligowy.models.orders.resources.WOrderResource;
import pl.kuligowy.models.orders.resources.assemblers.WOrderItemResourceAssembler;
import pl.kuligowy.models.orders.resources.assemblers.WOrderResourceAssembler;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.resources.WOrderItemCollectionResource;
import pl.kuligowy.models.orders.resources.WOrderItemResource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import pl.kuligowy.models.orders.resources.WOrderCollectionResource;

/**
 *
 * @author coolig
 */
@RestController
@RequestMapping(path = "/worder")
public class WOrderRestController {

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

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WOrderResource getWOrder(@PathVariable Integer id) {
        return assembler.toResource(worderDao.getWOrderById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public WOrderCollectionResource getWOrders(@RequestParam(name = "statusId") Integer statusId) {
        WOrderStatus wos = new WOrderStatus(statusId);
        List<WOrderResource> list = assembler.toResources(worderDao.getWOrderList(wos));
        WOrderCollectionResource resource = new WOrderCollectionResource(list);
        resource.add(linkTo(methodOn(WOrderRestController.class).getWOrders(statusId)).withSelfRel());
        return resource;
    }

    @RequestMapping(path = "/{id}/worderItem", method = RequestMethod.GET)
    public WOrderItemCollectionResource getWOrderItems(@PathVariable Integer id) {
        WOrder parent = new WOrder(id);
        List<WOrderItemResource> list = assemblerItem.toResources(itemRepo.findByWorderId(parent));
        WOrderItemCollectionResource collection = new WOrderItemCollectionResource(list);
        //linkTo(methodOn(InvoiceController.class).getInvoiceByCustomerId(customer.getId())).withRel("invoice");
        collection.add(linkTo(methodOn(WOrderRestController.class, id).getWOrderItems(id)).withSelfRel());
        return collection;
    }
}
