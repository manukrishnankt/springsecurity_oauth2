package com.waves.springsec.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
public class AuthResourceServer extends ResourceServerConfigurerAdapter{
	@Override
    public void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/guest/**").permitAll()
		.antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
		.antMatchers("/oauth/**").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.and().formLogin().permitAll();
    }
}
