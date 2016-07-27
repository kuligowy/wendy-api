/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.impl;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.kuligowy.dao.repositiories.JPARepositoryMenuBlockItem;
import pl.kuligowy.dao.repositiories.JPARepositoryUser;
import pl.kuligowy.dao.user.UserDao;
import pl.kuligowy.models.menu.MenuBlock;
import pl.kuligowy.models.users.Permission;
import pl.kuligowy.models.users.User;

/**
 *
 * @author mkuligowski
 */
@Component(value = "userDao")
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

    @Override
    public User findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        User user = userRepo.findByLogin(string);
        if (user == null) {
            return new org.springframework.security.core.userdetails.User(
                    " ", " ", true, true, true, true, Collections.EMPTY_LIST);
        }
        List<Permission> permissions = Lists.newArrayList();
        permissions.addAll(user.getPermissionList());
        permissions.addAll(user.getRoleId().getPermissionList());
        List<GrantedAuthority> authorities = permissions.stream().map(p -> new SimpleGrantedAuthority(p.getName())).collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getLogin(), true, true, true,
                true, authorities);
    }

//    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
//        return getGrantedAuthorities(getPrivileges(roles));
//    }
//
//    private List<String> getPrivileges(Collection<Role> roles) {
//        List<String> privileges = new ArrayList<String>();
//        List<Privilege> collection = new ArrayList<Privilege>();
//        for (Role role : roles) {
//            collection.addAll(role.getPrivileges());
//        }
//        for (Privilege item : collection) {
//            privileges.add(item.getName());
//        }
//        return privileges;
//    }
//
    public List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<Permission> permissions = Lists.newArrayList();
        permissions.addAll(user.getPermissionList());
        permissions.addAll(user.getRoleId().getPermissionList());
        List<GrantedAuthority> authorities = permissions.stream().map(p -> new SimpleGrantedAuthority(p.getName())).collect(Collectors.toList());
        return authorities;
    }
}
