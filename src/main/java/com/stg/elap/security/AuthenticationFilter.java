package com.stg.elap.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stg.elap.SpringApplicationContext;
import com.stg.elap.model.UserModel;
import com.stg.elap.service.UserService;
import com.stg.elap.utils.Constants;
import com.stg.elap.utils.PropertiesReader;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authManager;
	private String contentType;
	private final static PropertiesReader props = PropertiesReader.getInstance();
	
	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authManager = authenticationManager;
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Authenticating user credential
	 */
	
	
	 @Override
	    public Authentication attemptAuthentication(HttpServletRequest req,
	                                                HttpServletResponse res) throws AuthenticationException {
	        try {
	        	
	        	contentType = req.getHeader("Accept");
	            UserModel creds = new ObjectMapper()
	                    .readValue(req.getInputStream(), UserModel.class);
	            
	            System.out.println("mail-"+creds.getEmail());
	            
	            return authManager.authenticate(	
	                    new UsernamePasswordAuthenticationToken(
	                            creds.getEmail(),
	                            creds.getPassword(),
	                            new ArrayList<>())
	            );
	            
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	 
	 
	 /**
	  * After successful generating token and set as request header
	  */
	    @Override
	    protected void successfulAuthentication(HttpServletRequest req,
	                                            HttpServletResponse res,
	                                            FilterChain chain,
	                                            Authentication auth) throws IOException, ServletException {
	        
	        String userName = ((User) auth.getPrincipal()).getUsername();  
	        System.out.println("after succ"+userName);
	        
	        String token = Jwts.builder()
	                .setSubject(userName)
	                .setExpiration(new Date(System.currentTimeMillis() + Constants.SecureConst.EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS512, props.getSecret("token_secret") )
	                .compact();
	        System.out.println("token-"+token);
	        
	        UserService userService = (UserService)SpringApplicationContext.getBean("userServiceImpl");
	        UserModel user = userService.getUserDetails(userName);
	        System.out.println("username-"+user.getEmail());
	        Long id =user.getId();
	        res.addHeader(props.getSecret(Constants.SecureConst.HEADER_STRING), props.getSecret(Constants.SecureConst.TOKEN_PREFIX) + token);
	        res.addHeader("UserID", id.toString());

	    }  
	 
}
