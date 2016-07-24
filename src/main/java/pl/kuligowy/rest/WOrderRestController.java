/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kuligowy.models.orders.WOrder;

/**
 *
 * @author coolig
 */
@RestController
@RequestMapping(path = "/worder")
public class WOrderRestController {
        
    @RequestMapping(method = RequestMethod.GET)
    public List<WOrder> getWOrders(@RequestParam(name = "statusId") Integer statusId){
        return Lists.newArrayList();
    }
    
}
