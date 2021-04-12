package com.zensar.demo.controllerTest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.demo.controller.UserController;
import com.zensar.demo.model.UserRequest;
import com.zensar.demo.model.UserResponse;
import com.zensar.demo.service.UserInterface;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

	
	@InjectMocks
	private UserController userController;
	@Mock
	private UserInterface service;
	
	private UserRequest userRequest;
	
	private UserResponse userResponse;

	
	@Before
	public void init() {
		
		try {//src\test\java\com\example\demo
//			userRequest = new ObjectMapper().readValue(new File("src/test/java/com/example/demo/Request.json"),
//					UserRequest.class);
//			
//			userResponse = new ObjectMapper().readValue(new File("src/test/java/com/example/demo/Response.json"),
//					UserResponse.class);
			
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<UserRequest> typeReference = new TypeReference<UserRequest>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/jsons/Request.json");
			userRequest = mapper.readValue(inputStream,typeReference);

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void controllerTest() {
		
		Mockito.when(service.filterUserList(userRequest))
		.thenReturn(userResponse);
		UserResponse response = userController.fetchmodifiedUseres(userRequest);
		assertEquals(userResponse, response);		
		
	}

	
}
