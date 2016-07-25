/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuligowy.models.orders.Supplier;

/**
 *
 * @author mkuligowski
 */
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    
}
