/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest.status_services;

import java.util.List;
import pl.kuligowy.models.orders.WOrder;

/**
 *
 * @author mkuligowski
 */
public abstract class StatusService {

    protected WOrder worder;

    public abstract List<Action> getActions();

    public StatusService getWithWOrder(WOrder worder) {
        this.worder = worder;
        return this;
    }
}
