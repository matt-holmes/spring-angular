package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
        .and().authorizeRequests()
        .antMatchers("/index.html", "/").permitAll()
        .anyRequest().authenticated().and().csrf().csrfTokenRepository(
            CookieCsrfTokenRepository.withHttpOnlyFalse()
        ).and().logout().logoutSuccessUrl("/");
    }
}
