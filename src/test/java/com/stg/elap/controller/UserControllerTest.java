package com.stg.elap.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import com.stg.elap.model.UserModel;
import com.stg.elap.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
	
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	UserModel user;

	@BeforeEach
	void setUp() throws Exception {
		 user = new UserModel();
			user.setId(1L);
			user.setName("Vignesh");
			user.setEmail("vicky@gmail.com");
			user.setPassword("asas2");
	}

	

	@Test
	void testRegister() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUserDetails() {
		when(userService.getUserDetails(anyString())).thenReturn(user);
		
		UserModel userDetails = userService.getUserDetails(anyString());
		assertNotNull(userDetails);
		assertEquals(userDetails.getName(), user.getName());
	}

	@Test
	void testWelcome() {
		fail("Not yet implemented");
	}

}
