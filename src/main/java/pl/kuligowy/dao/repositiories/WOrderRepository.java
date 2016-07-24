/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuligowy.models.orders.WOrder;

/**
 *
 * @author coolig
 */
public interface WOrderRepository extends JpaRepository<WOrder, Integer> {
    
}
