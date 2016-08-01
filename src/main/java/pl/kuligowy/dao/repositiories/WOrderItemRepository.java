/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.repositiories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.WOrderItem;

/**
 *
 * @author mkuligowski
 */
//@RepositoryRestResource()
@RepositoryRestResource(exported = false)
public interface WOrderItemRepository extends JpaRepository<WOrderItem, Integer> {

    List<WOrderItem> findByWorderId(WOrder worderId);
}
