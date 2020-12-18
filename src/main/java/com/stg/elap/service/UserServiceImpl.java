package com.stg.elap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stg.elap.model.UserModel;
import com.stg.elap.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository user;
	

	
	@Autowired
	private PasswordEncoder passwordEncode;
	
	@Override
	public void saveUserDetails(UserModel model) {
		
		model.setPassword(passwordEncode.encode(model.getPassword()));
		user.save(model);
		
	}
	
	@Override
	public boolean getUserDetails(String email) {
		
		System.out.println("inside");
		List<UserModel> mod = user.findByemail(email);
		if(mod!=null)
			return true;
		return false;
	}

	@Override
	public boolean auth(UserModel userModel) {
		
		
		List<UserModel> mod = user.findByemail(userModel.getEmail());
		System.out.println("list"+mod);
		System.out.println("list"+mod.isEmpty());
		if(mod!=null && !mod.isEmpty()) {
			System.out.println(passwordEncode.matches(userModel.getPassword(), mod.get(0).getPassword()));
			if(passwordEncode.matches(userModel.getPassword(), mod.get(0).getPassword()))
				return true;
		}
		return false;
	}

}
