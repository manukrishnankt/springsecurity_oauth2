package com.waves.springsec.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


//@Configuration
//@EnableResourceServer
public class AuthResourceServer extends ResourceServerConfigurerAdapter{
	@Override
    public void configure(HttpSecurity http) throws Exception {
		
    }
}
