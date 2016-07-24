/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.repositiories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuligowy.models.menu.MenuBlock;

/**
 *
 * @author coolig
 */
public interface JPARepositoryMenuBlock extends JpaRepository<MenuBlock, Integer>{
    
    List<MenuBlock> findByUser(Long userId);
}
