package com.stg.elap.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.stg.elap.model.UserModel;
import com.stg.elap.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	UserRepository userRepo;
	
	@Mock
	BCryptPasswordEncoder bcryptpass;
	
	
	UserModel user;
	String password="asas3231asa";
	
	@InjectMocks
	UserServiceImpl userService;
	
	@BeforeEach
	void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
		 user = new UserModel();
		user.setId(1L);
		user.setName("Vignesh");
		user.setEmail("vicky@gmail.com");
		user.setPassword("asas2");
	}

	@Test
	void testSaveUserDetails() { 
		when(userRepo.findByemail(anyString())).thenReturn(user);
		when(bcryptpass.encode(anyString())).thenReturn(password);
		when(userRepo.save(any(UserModel.class))).thenReturn(user);
//		Mockito.doNothing().when(obj).verifyEmail(anyString());    donothing
		
		UserModel userDetails = new UserModel();
		userDetails.setEmail("vick@gmail.com");
		userDetails.setName("Vignesh");
		userDetails.setPassword("vicky");
		
		
		
		
		UserModel userResult = userService.saveUserDetails(userDetails);
		
		assertNotNull(userResult);
		verify(bcryptpass,times(1)).encode("vicky");
		verify(userRepo,times(1)).save(any(UserModel.class));
	}

	@Test
	void testGetUserDetails() {
	
		
		when(userRepo.findByemail(anyString())).thenReturn(user);	
		
		UserModel check = userService.getUserDetails("test@gmail.com");
		assertNotNull(check);
		assertEquals("Vignesh", check.getName());
	}
	
	
	@Test
	void testGetUserDetails_UsernameNotFoundException() {
		
		when(userRepo.findByemail(anyString())).thenReturn(null);	
		
		
		assertThrows(UsernameNotFoundException.class, 
				()->{
					userService.getUserDetails("test@gmail.com");
				});
	
	}
	

	@Test
	void testAuth() {
		fail("Not yet implemented");
	}

}
