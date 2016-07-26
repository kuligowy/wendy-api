/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest.status_services;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.rest.WOrderRestController;

/**
 *
 * @author mkuligowski
 */
@Component
public class ActionBuilder {

    public Action getCloseAction(WOrder order, Integer idForClose) {
        Action action = new Action();
        action.setTitle("CLOSE");
        action.setName("close");
        action.setMethod("PATCH");
        action.setLink(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(WOrderRestController.class, order.getId())).toUri().toString());
        action.addField(new pl.kuligowy.rest.status_services.Field("statusId", "integer", idForClose.toString()));
        return action;
    }

}
