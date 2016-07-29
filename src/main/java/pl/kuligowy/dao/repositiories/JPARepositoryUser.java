/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.repositiories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.kuligowy.models.users.User;

/**
 *
 * @author mkuligowski
 */
@RepositoryRestResource(exported = false)
public interface JPARepositoryUser extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u JOIN u.roleId r WHERE u.id = ?1")
    List<User> findMenuItems(Long u);

    User findByLogin(String login);
}
