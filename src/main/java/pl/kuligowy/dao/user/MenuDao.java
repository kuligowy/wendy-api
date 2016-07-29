/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.user;

import java.util.List;
import pl.kuligowy.models.menu.MenuBlock;
import pl.kuligowy.models.users.User;

/**
 *
 * @author coolig
 */
public interface MenuDao {

    List<MenuBlock> getMenu(User u);
}
