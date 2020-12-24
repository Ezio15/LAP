package com.stg.elap.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.stg.elap.model.UserModel;

public interface UserService  extends UserDetailsService {

	public void saveUserDetails(UserModel model);
	
	public UserModel getUserDetails(String email);

	public boolean auth(UserModel userModel);

	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
