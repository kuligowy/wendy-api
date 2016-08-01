/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.services.status_services;

import pl.kuligowy.models.methods.Action;
import pl.kuligowy.models.methods.Permission;
import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mkuligowski
 */
@Service
public class Close20Service extends StatusService {

    @Autowired
    private ActionFactory actionBuilder;

    @Permission(permissionId = 40)
    public Action history() {
        return actionBuilder.buildHistoryAction(worder);
        
    }

}
