/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.config.security;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.kuligowy.dao.user.UserDao;
import pl.kuligowy.models.users.Permission;
import pl.kuligowy.models.users.User;

/**
 *
 * @author mkuligowski
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = Logger.getLogger("CustomAuthenticationProvider");
    @Autowired
    private UserDao dao;

    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        logger.log(Level.INFO, "username: {0}", name);
        logger.log(Level.INFO, "password: {0}", password);

        User user = dao.findByLogin(name);
        if (user == null) {
            return null;
        }
        List<Permission> permissions = Lists.newArrayList();
        permissions.addAll(user.getPermissionList());
        permissions.addAll(user.getRoleId().getPermissionList());
        List<GrantedAuthority> authorities = permissions.stream().map(p -> new SimpleGrantedAuthority(p.getName())).collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
