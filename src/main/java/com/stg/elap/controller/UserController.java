package com.stg.elap.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stg.elap.model.UserModel;
import com.stg.elap.responseentity.LoginResponse;
import com.stg.elap.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	ResponseEntity<LoginResponse>  login(@RequestBody UserModel userModel) {
		LoginResponse response = new LoginResponse();
		boolean result = false;
		if(userModel.getEmail()!=null && userModel.getPassword()!=null) {
			result = userService.auth(userModel);
			if(result) {
			
			response.setMessage("success");
			response.setToken("asfhajks");
			response.setUserId("1");
			return new ResponseEntity<LoginResponse>(
			          response, 
			          HttpStatus.OK);}
		}
		response.setMessage("Unauthorized user");
		return new ResponseEntity<LoginResponse>(
				response, 
		          HttpStatus.FORBIDDEN);
	}
	
	
	@PostMapping("/register")
	public String register(@RequestBody UserModel userModel) {
		if(userModel.getEmail()!=null) {
			System.out.println("email-"+userModel.getEmail());
			userService.saveUserDetails(userModel);
		return "success";
		}
		return  "failed";
		
	}
	
	
	@GetMapping("/getdetails/{email}")
	public BodyBuilder getUserDetails(@PathVariable String email) {
		if(email!=null) {
			System.out.println("email-"+email);
			userService.getUserDetails(email);
		return ResponseEntity.status(HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY);
		
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome..";
	}
}
