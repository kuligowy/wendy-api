/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.repositiories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.WOrderStatus;

/**
 *
 * @author coolig
 */
@RepositoryRestResource(exported = false)
public interface WOrderRepository extends JpaRepository<WOrder, Integer> {

    public List<WOrder> findByStatusId(WOrderStatus statusId);
}
