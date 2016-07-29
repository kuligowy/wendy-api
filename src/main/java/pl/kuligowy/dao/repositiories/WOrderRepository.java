/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.repositiories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.WOrderStatus;
import pl.kuligowy.models.users.User;

/**
 *
 * @author coolig
 */
@RepositoryRestResource(exported = false)
public interface WOrderRepository extends JpaRepository<WOrder, Integer> {

    public List<WOrder> findByStatusId(WOrderStatus statusId);

    @Query(value = "SELECT * FROM worder WHERE status_id = ?1 and (?2 = true OR owner_id = 1)", nativeQuery = true)
    public List<WOrder> findByStatusIdFilterByUnit(WOrderStatus statusId, boolean seesAllUnit);

    public List<WOrder> findByStatusIdOrTimeoforderOrUserIdOrDescription(WOrderStatus status, LocalDate timeoforder, User owner, String description);

}
