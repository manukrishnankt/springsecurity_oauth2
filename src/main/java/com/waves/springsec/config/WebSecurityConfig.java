package com.waves.springsec.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
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
		.csrf().ignoringRequestMatchers(request -> "/introspect".equals(request.getRequestURI()))
		.and()
		.authorizeRequests()
		.antMatchers("/guest/**").permitAll()
		.mvcMatchers("/.well-known/jwks.json").permitAll()
		.antMatchers("/user/**").hasAuthority("SCOPE_read")
		.antMatchers("/oauth/**").permitAll()
		.antMatchers("/admin/**").hasAuthority("SCOPE_read")
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
		.formLogin();
			
	}
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

	
	

}
