/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest.status_services;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mkuligowski
 */
@Service
public class Open10Service extends StatusService {

    @Autowired
    private ActionBuilder actionBuilder;

    public Action close() {
        return actionBuilder.getCloseAction(worder, 20);
    }

    @Override
    public List<Action> getActions() {
        List lista = Lists.newArrayList();
        lista.add(close());
        return lista;
    }

}
