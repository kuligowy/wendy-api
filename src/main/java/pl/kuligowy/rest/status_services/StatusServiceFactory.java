/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest.status_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kuligowy.models.orders.WOrder;

/**
 *
 * @author mkuligowski
 */
@Component
public class StatusServiceFactory {

    @Autowired
    private Open10Service open10Service;
    @Autowired
    private Close20Service close20Service;
    @Autowired
    private DefaultService defaultService;

    public StatusService getStatusService(WOrder worder) {
        switch (worder.getStatusId().getId()) {
            case 10:
                return open10Service.getWithWOrder(worder);
            case 20:
                return close20Service.getWithWOrder(worder);
            default:
                return defaultService.getWithWOrder(worder);
        }
    }
}
