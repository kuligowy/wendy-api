/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.services.status_services;

import pl.kuligowy.models.methods.Action;
import pl.kuligowy.models.methods.Permission;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import pl.kuligowy.models.orders.WOrder;
import pl.kuligowy.models.users.User;

/**
 *
 * @author mkuligowski
 */
public abstract class StatusService {

    protected WOrder worder;

    public StatusService getWithWOrder(WOrder worder) {
        this.worder = worder;
        return this;
    }

    public List<Action> getActions(User user) {
        Set<Long> permissionIdSet = user.getPermissionList()
                .stream()
                .map(p -> p.getId()).collect(Collectors.toSet());

        return Arrays.asList(this.getClass().getMethods())
                .stream()
                .filter(m -> m.getAnnotation(Permission.class) != null
                        && permissionIdSet.contains(m.getAnnotation(Permission.class).permissionId()))
                .map((Method m) -> {
                    try {
                        return (Action) m.invoke(StatusService.this, new Object[]{});
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        Logger.getLogger(StatusService.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    }
        }).filter(t -> t!=null).collect(Collectors.toList());
    }
}
