/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.order;

import java.time.LocalDate;
import java.util.List;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.WOrderStatus;
import pl.kuligowy.models.users.User;

/**
 *
 * @author mkuligowski
 */
public interface WOrderDao {

    List<WOrder> getWOrders(WOrderStatus statusId);

    public WOrder getWOrderById(Integer id);

    public WOrder addWorder(WOrder worder);

    public List<WOrder> getWOrders(WOrderStatus status, boolean userInRole);

    public List<WOrder> getWOrders(WOrderStatus status, LocalDate timeoforder, User owner, String description);

}
