package com.stg.elap.service;

import com.stg.elap.model.UserModel;

public interface UserService {

	public void saveUserDetails(UserModel model);
	
	public boolean getUserDetails(String email);

	public boolean auth(UserModel userModel);
}
