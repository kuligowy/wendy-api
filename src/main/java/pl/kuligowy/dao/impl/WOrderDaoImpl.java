/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.impl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kuligowy.dao.order.WOrderDao;
import pl.kuligowy.dao.repositiories.WOrderRepository;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.WOrderStatus;
import pl.kuligowy.models.users.User;

/**
 *
 * @author mkuligowski
 */
@Component
public class WOrderDaoImpl implements WOrderDao {

    private final WOrderRepository repo;

    @Autowired
    public WOrderDaoImpl(WOrderRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<WOrder> getWOrders(WOrderStatus statusId) {
        return repo.findByStatusId(statusId);
    }

    @Override
    public WOrder getWOrderById(Integer id) {
        return repo.findOne(id);
    }

    @Override
    public WOrder addWorder(WOrder worder) {
        return repo.saveAndFlush(worder);
    }

    @Override
    public List<WOrder> getWOrders(WOrderStatus status, boolean seesAllUnits) {
        return repo.findByStatusIdFilterByUnit(status, seesAllUnits);
    }

    @Override
    public List<WOrder> getWOrders(WOrderStatus status, LocalDate timeoforder, User owner, String description) {
        return repo.findByStatusIdOrTimeoforderOrUserIdOrDescription(status, timeoforder, owner, description);
    }

}
