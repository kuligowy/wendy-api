/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.user;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.kuligowy.models.menu.MenuBlock;
import pl.kuligowy.models.users.User;

/**
 *
 * @author mkuligowski
 */
public interface UserDao extends UserDetailsService {

    List<MenuBlock> getMenu();

    List<MenuBlock> getMenu(User u);

    List<User> getMenu(Long u);

    User findByLogin(String login);

    List<GrantedAuthority> getGrantedAuthorities(User user);
}
