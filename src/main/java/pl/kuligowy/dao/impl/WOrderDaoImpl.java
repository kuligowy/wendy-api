/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kuligowy.dao.order.WOrderDao;
import pl.kuligowy.dao.repositiories.WOrderRepository;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.WOrderStatus;

/**
 *
 * @author mkuligowski
 */
@Component
public class WOrderDaoImpl implements WOrderDao {

    private WOrderRepository repo;

    @Autowired
    public WOrderDaoImpl(WOrderRepository repo) {
        this.repo = repo;
    }

    public List<WOrder> getWOrderList(WOrderStatus statusId) {
        return repo.findByStatusId(statusId);
    }

    public WOrder getWOrderById(Integer id) {
        return repo.findOne(id);
    }
    
    
}
