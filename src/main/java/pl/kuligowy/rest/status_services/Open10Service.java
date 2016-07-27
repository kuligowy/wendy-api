/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest.status_services;

import com.google.common.collect.Lists;
import java.util.List;
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

    @PreAuthorize("hasRole('ADMIN')")
    public Action close() {
        return actionBuilder.buildCloseAction(worder, 20);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Action delete() {
        return actionBuilder.buildDeleteAction(worder);
    }

    public Action history() {
        return actionBuilder.buildHistoryAction(worder);
    }

    @Override
    public List<Action> getActions() {
        List lista = Lists.newArrayList();
        lista.add(close());
        lista.add(delete());
        lista.add(history());
        return lista;
    }

}
