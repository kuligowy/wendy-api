/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.services.status_services;

import pl.kuligowy.models.methods.Action;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.rest.WOrderRestController;

/**
 *
 * @author mkuligowski
 */
@Component
public class ActionFactory {

    public ActionFactory() {
    }

    public Action buildHistoryAction(WOrder order) {
        Action action = new Action();
        action.setTitle("HISTORY");
        action.setName("history");
        action.setMethod("GET");
        action.setLink(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(WOrderRestController.class, order.getId()).getWOrderHistory(order.getId())).toUri().toString());
        return action;
    }

    public Action buildCloseAction(WOrder order, Integer idForClose) {
        Action action = new Action();
        action.setTitle("CLOSE");
        action.setName("close");

        action.setMethod("PATCH");
        action.setLink(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(WOrderRestController.class, order.getId()).getWOrder(order.getId(), null)).toUri().toString());
        action.addField(new pl.kuligowy.models.methods.Field("statusId", "integer", idForClose.toString()));
        return action;
    }

    public Action buildDeleteAction(WOrder order) {
        Action action = new Action();
        action.setTitle("DELETE");
        action.setName("delete");
        action.setMethod("DELETE");
        action.setLink(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(WOrderRestController.class, order.getId()).getWOrder(order.getId(), null)).toUri().toString());
        return action;
    }

}
