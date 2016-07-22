/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kuligowy.dao.user.UserDao;
import pl.kuligowy.models.users.User;

/**
 *
 * @author mkuligowski
 */
@RestController
@RequestMapping("/{user}")
public class UserRestController {

    private UserDao userDao;

    @Autowired
    public UserRestController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<User> getMenu(@PathVariable Long user) {
        return userDao.getMenu(user);
    }
}
