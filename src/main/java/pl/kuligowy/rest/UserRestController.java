/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.kuligowy.dao.user.MenuDao;
import pl.kuligowy.models.menu.resources.MenuBlockResource;
import pl.kuligowy.models.menu.resources.assemblers.MenuBlockResourceAssembler;
import pl.kuligowy.models.users.User;

/**
 *
 * @author mkuligowski
 */
@RestController
@RequestMapping("/{user}")
public class UserRestController {

    private final MenuDao menuDao;
    private final MenuBlockResourceAssembler menuBlockAssembler;

    @Autowired
    public UserRestController(MenuDao menuDao, MenuBlockResourceAssembler menuBlockAssembler) {
        this.menuDao = menuDao;
        this.menuBlockAssembler = menuBlockAssembler;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<MenuBlockResource> getMenu(@PathVariable Long user) {
        User u = new User();
        u.setId(user);
        menuBlockAssembler.setUserId(user);
        //return menuDao.getMenuByUser(u);

//        return menuDao.getMenu(u).stream()//
//                .map((MenuBlock t) -> new ResponseEntity<>(t, HttpStatus.OK))//
//                .collect(Collectors.toList());
        return menuBlockAssembler.toResources(menuDao.getMenu(u));
    }

}
