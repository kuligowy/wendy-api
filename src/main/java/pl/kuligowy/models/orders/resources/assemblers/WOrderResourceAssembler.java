/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.models.orders.resources.assemblers;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.orders.resources.WOrderResource;

/**
 *
 * @author coolig
 */
public class WOrderResourceAssembler extends ResourceAssemblerSupport<WOrder, WOrderResource> {

    public WOrderResourceAssembler(Class<?> controllerClass, Class<WOrderResource> resourceType) {
        super(controllerClass, resourceType);
    }

    @Override
    public WOrderResource toResource(WOrder entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
