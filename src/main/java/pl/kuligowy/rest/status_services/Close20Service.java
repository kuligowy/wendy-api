/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest.status_services;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mkuligowski
 */
@Service
public class Close20Service extends StatusService {

    @Override
    public List<Action> getActions() {
        return Lists.newArrayList();
    }

    @RequestMapping(path = "/history")
    public void history() {

    }

}
