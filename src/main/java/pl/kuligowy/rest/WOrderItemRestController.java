/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.kuligowy.dao.repositiories.WOrderItemRepository;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.resources.WOrderItemResource;
import pl.kuligowy.models.orders.resources.assemblers.WOrderItemResourceAssembler;

/**
 *
 * @author mkuligowski
 */
@RestController
@RequestMapping(path = "/worderItem")
public class WOrderItemRestController {

    private WOrderItemRepository repo;
    private WOrderItemResourceAssembler assembler;

    @Autowired
    public WOrderItemRestController(WOrderItemRepository repo, WOrderItemResourceAssembler assembler) {
        this.repo = repo;
        this.assembler = assembler;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WOrderItemResource getWOrderItem(@PathVariable Integer id) {
        return assembler.toResource(repo.findOne(id));
    }
}
