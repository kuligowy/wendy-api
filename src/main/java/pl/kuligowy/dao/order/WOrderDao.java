/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.order;

import java.util.List;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.WOrderStatus;

/**
 *
 * @author mkuligowski
 */
public interface WOrderDao {
    
    List<WOrder> getWOrderList(WOrderStatus statusId);

    public WOrder getWOrderById(Integer id);
    
    
}
