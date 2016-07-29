/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kuligowy.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 *
 * @author mkuligowski
 */
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private RESTAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(datasource)
//                .authoritiesByUsernameQuery("select p.name from user u "
//                        + "join role r on (r.id = u.role_id) "
//                        + "left join role_permission rp on (rp.role_id = r.id) "
//                        + "left join user_permission up on (up.user_id = u.id) "
//                        + "left join permission p on (p.id = rp.permission_id or p.id = up.permission_id)"
//                        + "where u.login = ?")
//                .groupAuthoritiesByUsername("select r.* from user u "
//                        + "join role r on (r.id = u.role_id) where u.username = ?")
//                .usersByUsernameQuery("select username,password,enable from user where login = ? ")
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
//
//        builder.inMemoryAuthentication()
//                .withUser("USER").password("USER").roles("USER")
//                .and()
//                .withUser("ADMIN").password("ADMIN").authorities("40");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").authenticated();
        http.csrf().disable();
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        http.httpBasic();///authenticationEntryPoint(authenticationFailureHandler);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
