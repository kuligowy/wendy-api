/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.impl;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kuligowy.dao.user.UserDao;
import pl.kuligowy.models.menu.MenuBlock;
import pl.kuligowy.models.users.User;

/**
 *
 * @author mkuligowski
 */
@Component
public class JPAUserDaoImpl implements UserDao {

    JPARepositoryUser userRepo;
    JPARepositoryMenuBlockItem menuItemRepo;

    @Autowired
    public JPAUserDaoImpl(JPARepositoryUser userRepo, JPARepositoryMenuBlockItem menuItemRepo) {
        this.userRepo = userRepo;
    }

    public List<MenuBlock> getMenu(User u) {
        return Lists.newArrayList();
    }

    public List<MenuBlock> getMenu() {
        return Lists.newArrayList();
    }

    public List<User> getMenu(Long u) {
        return userRepo.findMenuItems(u);
    }
}
