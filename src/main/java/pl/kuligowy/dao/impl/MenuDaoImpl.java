/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kuligowy.dao.repositiories.JPARepositoryMenuBlock;
import pl.kuligowy.dao.user.MenuDao;
import pl.kuligowy.models.menu.MenuBlock;
import pl.kuligowy.models.menu.MenuBlockItem;
import pl.kuligowy.models.users.User;

/**
 *
 * @author coolig
 */
@Component
public class MenuDaoImpl implements MenuDao{

    private final JPARepositoryMenuBlock  repoMenuBlock;

    @Autowired
    public MenuDaoImpl(
            JPARepositoryMenuBlock repoMenuBlock) {
        this.repoMenuBlock = repoMenuBlock;
     }
    
    @Override
    public List<MenuBlockItem> getMenuByUser(User u) {
//        
//        return repo.findAll().stream()//
//                .map((MenuBlockItemPermission t) -> t.getMenuBlockItemId())//
//                .collect(Collectors.toList());
return null;
    }

    @Override
    public List<MenuBlock> getMenu(User u) {
        
        return repoMenuBlock.findByUser(u.getId());
    }
    
}
