/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.user;

import pl.kuligowy.models.users.User;

/**
 *
 * @author mkuligowski
 */
public interface UserDao {

    User findByLogin(String login);

}
