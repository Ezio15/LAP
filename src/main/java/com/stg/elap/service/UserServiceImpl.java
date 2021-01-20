package com.stg.elap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stg.elap.model.UserModel;
import com.stg.elap.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository user;
	
	@Autowired
	BCryptPasswordEncoder bcryptpass;
	
	
	
	@Override
	public UserModel saveUserDetails(UserModel model) {
		
		if(user.findByemail(model.getEmail())==null)
			throw new RuntimeException("Record already exist!");
		
		model.setPassword(bcryptpass.encode(model.getPassword()));
		return user.save(model);
		
	}
	
	@Override
	public UserModel getUserDetails(String email) {
		
		System.out.println("inside");
		UserModel mod = user.findByemail(email);
		if(mod == null)
			 throw new UsernameNotFoundException(email);
		return mod;
	}

	@Override
	public boolean auth(UserModel userModel) {
		
		
		UserModel mod = user.findByemail(userModel.getEmail());
		System.out.println("list"+mod);
//		System.out.println("list"+mod.isEmpty());
//		if(mod!=null && !mod.isEmpty()) {
//			System.out.println(passwordEncode.matches(userModel.getPassword(), mod.get(0).getPassword()));
//			if(passwordEncode.matches(userModel.getPassword(), mod.get(0).getPassword()))
//				return true;
//		}
		return false;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		System.out.println("inside");
		UserModel  userEntity = user.findByemail(email);

		System.out.println("mail"+userEntity.getEmail());
			if (userEntity == null)
				throw new UsernameNotFoundException(email);
			
			
			return new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());

	}

}
