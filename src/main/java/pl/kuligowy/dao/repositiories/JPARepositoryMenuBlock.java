/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.repositiories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.kuligowy.models.menu.MenuBlock;

/**
 *
 * @author coolig
 */
@RepositoryRestResource(exported = false)
public interface JPARepositoryMenuBlock extends JpaRepository<MenuBlock, Integer> {

    @Query(
            "SELECT distinct mb FROM User u,MenuBlock mb "
            + " LEFT JOIN u.permissionList upl "
            + " LEFT JOIN u.roleId.permissionList rpl "
            + " JOIN mb.menuBlockItemList mbi "
            + "WHERE (mbi.permissionId.id = upl.id  OR  mbi.permissionId.id = rpl.id  ) "
            + "  AND u.id = ?1 "
            + "ORDER BY mb.sort asc ")
    List<MenuBlock> findByUser(Long userId);
}
