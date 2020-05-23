package com.waves.springsec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.waves.springsec.service.AuthUserDetailsService;

@Configuration
@EnableWebSecurity
@Order(1)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired AuthUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder getEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

//	@Bean
//    public BCryptPasswordEncoder passwordEncoder(){ 
//        return new BCryptPasswordEncoder(); 
//    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//This Method is for Autherization
		
		http
			.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/guest/**").permitAll()
			.antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
			.antMatchers("/oauth/**").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			
			.and().formLogin().permitAll();
	}
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

	
	

}
