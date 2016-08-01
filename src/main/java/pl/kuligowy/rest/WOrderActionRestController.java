/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.kuligowy.dao.order.WOrderDao;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.users.User;
import pl.kuligowy.models.methods.Action;
import pl.kuligowy.services.status_services.StatusServiceFactory;

/**
 *
 * @author mkuligowski
 */
@RestController
@RequestMapping(path = "/worders/{worderId}/actions")
public class WOrderActionRestController {

    private final WOrderDao dao;
    private final StatusServiceFactory serviceFactory;

    @Autowired
    public WOrderActionRestController(StatusServiceFactory serviceFactory, WOrderDao dao) {
        this.serviceFactory = serviceFactory;
        this.dao = dao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Action> getActions(@PathVariable Integer worderId,
            @AuthenticationPrincipal User user) {
        WOrder order = dao.getWOrderById(worderId);
        return serviceFactory.getStatusService(order).getActions(user);
    }
}
