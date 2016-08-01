/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.services.status_services;

import pl.kuligowy.models.methods.Action;
import pl.kuligowy.models.methods.Permission;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 *
 * @author mkuligowski
 */
@Service
public class Open10Service extends StatusService {

    @Autowired
    private ActionFactory actionBuilder;

    @Permission(permissionId = 10)
    public Action close() {
        return actionBuilder.buildCloseAction(worder, 20);
    }

    @Permission(permissionId = 20)
    public Action delete() {
        return actionBuilder.buildDeleteAction(worder);
    }

    @Permission(permissionId = 30)
    public Action history() {
        return actionBuilder.buildHistoryAction(worder);
    }

 



}
