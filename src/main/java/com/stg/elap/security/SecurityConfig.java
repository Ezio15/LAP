package com.stg.elap.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.stg.elap.service.UserService;
import com.stg.elap.utils.Constants;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final UserService userDetailsService;

	public SecurityConfig(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userDetailsService = userDetailsService;

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable().cors().and().csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST, Constants.SecureConst.VENDOR_SIGNUP).permitAll()
				.antMatchers(HttpMethod.POST, Constants.SecureConst.VENDOR_LOGIN).permitAll()
				.antMatchers(HttpMethod.GET, "/welcome").permitAll()
				.antMatchers(HttpMethod.POST, "/admin/uploadDocument").permitAll().anyRequest().authenticated().and()
				.addFilter(new AuthenticationFilter(authenticationManager()))
				.addFilter(new AuthorizationFilter(authenticationManager())).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

}
