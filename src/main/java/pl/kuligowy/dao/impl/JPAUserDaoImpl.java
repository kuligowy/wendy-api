/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kuligowy.dao.repositiories.JPARepositoryMenuBlockItem;
import pl.kuligowy.dao.repositiories.JPARepositoryUser;
import pl.kuligowy.dao.user.UserDao;
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

    @Override
    public User findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

//    @Override
//    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
//        User user = userRepo.findByLogin(string);
//        if (user == null) {
//            return new org.springframework.security.core.userdetails.User(
//                    " ", " ", true, true, true, true, Collections.EMPTY_LIST);
//        }
//
//        Logger.getAnonymousLogger().log(Level.WARNING, "{0} found User ", string);
//        List<Permission> permissions = Lists.newArrayList();
//        permissions.addAll(user.getPermissionList());
//        permissions.addAll(user.getRoleId().getPermissionList());
//        List<GrantedAuthority> authorities = permissions.stream().map(p -> new SimpleGrantedAuthority(p.getName())).collect(Collectors.toList());
//        Logger.getAnonymousLogger().log(Level.WARNING, "User auth {0}", authorities.size());
//        return new org.springframework.security.core.userdetails.User(
//                user.getLogin(), user.getLogin(), true, true, true,
//                true, authorities);
//    }
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
//    public List<GrantedAuthority> getGrantedAuthorities(User user) {
//        List<Permission> permissions = Lists.newArrayList();
//        permissions.addAll(user.getPermissionList());
//        permissions.addAll(user.getRoleId().getPermissionList());
//        List<GrantedAuthority> authorities = permissions.stream().map(p -> new SimpleGrantedAuthority(p.getName())).collect(Collectors.toList());
//        return authorities;
//    }
}
