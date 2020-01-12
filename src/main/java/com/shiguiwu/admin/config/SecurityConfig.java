package com.shiguiwu.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @description: securiy
 * @author: stone
 * @date: Created by 2020/1/11 20:53
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.config
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login.html",
                        "/my/**",
                        "/treetable-lay/**",
                        "/xadmin/**",
                        "/ztree/**",
                        "/statics/**")
                .permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login.html").loginProcessingUrl("/login").successForwardUrl("/index")
        .and().cors().disable();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
