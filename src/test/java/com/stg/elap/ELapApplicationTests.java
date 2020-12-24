package com.stg.elap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stg.elap.controller.UserController;
import com.stg.elap.model.UserModel;

@SpringBootTest
@AutoConfigureMockMvc
class ELapApplicationTests {

	
	 @Autowired
	  private WebApplicationContext webApplicationContext;
	 
	 @Autowired
	  private MockMvc mockMvc;
	  
	

	  @Before
	  public void setUp() {
		
	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	  }
		
	
	@Test
	void contextLoads() {
		
	}

	 public static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	
	 @Test
	public void testUserController() throws Exception {
		UserModel model = new UserModel();
		model.setEmail("vignesh@gmail.com");
		model.setPassword("vicky");
//		mockMvc.perform(post("/login")
//	            .contentType(MediaType.APPLICATION_JSON)
//	            .content(asJsonString(model)))
//	            .andExpect(status().isOk());
		
//		RequestBuilder requestBuilder = MockMvcRequestBuilders
//				.post("/login")
//				.accept(MediaType.APPLICATION_JSON).content(asJsonString(model))
//				.contentType(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		MockHttpServletResponse response = result.getResponse();
//
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//		assertEquals("/login",
//				response.getHeader(HttpHeaders.LOCATION));


	}
	 
	 @Test
	 public void getDetailsByEmail() throws Exception 
	 {
		 mockMvc.perform( MockMvcRequestBuilders
	       .get("/getdetails/{email}", "vignesh@gmail.com")
	       .accept(MediaType.APPLICATION_JSON))
	       .andDo(print())
	       .andExpect(status().isOk());
	       
	 }
	 
	 @Test
	 public void getDetailsByEmailEmptyCheck() throws Exception 
	 {
		 mockMvc.perform( MockMvcRequestBuilders
	       .get("/getdetails/{email}", " ")
	       .accept(MediaType.APPLICATION_JSON))
	       .andDo(print())
	       .andExpect(status().isForbidden());
	       
	 }
	 
	 @Test
	 public void sample() throws Exception 
	 {
		 mockMvc.perform( MockMvcRequestBuilders
	       .post("/welcome")
	       .accept(MediaType.APPLICATION_JSON))
	       
	       .andExpect(status().isOk());
	       
	 }
	
}
