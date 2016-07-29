/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kuligowy.dao.order.WOrderDao;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.WOrderStatus;

/**
 *
 * @author mkuligowski
 */
@Service
public class WOrderService {

    private final WOrderDao dao;

    @Autowired
    public WOrderService(WOrderDao dao) {
        this.dao = dao;
//        this.securityContext = securityContext;
    }

    public List<WOrder> getOrders(WOrderStatus status, boolean test) {
        return dao.getWOrders(status, test);
    }

}
