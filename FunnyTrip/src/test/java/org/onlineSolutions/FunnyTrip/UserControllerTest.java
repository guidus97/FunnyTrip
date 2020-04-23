package org.onlineSolutions.FunnyTrip;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.onlineSolutions.FunnyTrip.config.security.JwtTokenProvider;
import org.onlineSolutions.FunnyTrip.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private WebApplicationContext webAppCont;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	private MockMvc mock;
	
	private String jwtToken;
	
	@Before
	public void setup() {
		mock = MockMvcBuilders.webAppContextSetup(webAppCont).apply(springSecurity()).build();
	}
	
	@Before
	public void inizializeToken() {
		jwtToken = jwtTokenProvider.createToken("micky", Arrays.asList("ADMIN"));
	}
	
	@Test
	public void updateUserByIdOk() throws Exception {
		
		User user = new User(2,"micky","pass","Michele","Andrungo","admin@tiscali.it",true,"ADMIN");
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		JSONObject jsonObject = new JSONObject(objectWriter.writeValueAsString(user));
		
		mock.perform(put("/api/account/modifyUserById/2")
				.header("Authorization", "Bearer " + this.jwtToken)
				.header("Content-Type", "application/json")
				.content(jsonObject.toString()))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void updateUserByIdUnauthorized() throws Exception {
		
		User user = new User(2,"micky","pass","Michele","Andrungo","admin@tiscali.it",true,"ADMIN");
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		JSONObject jsonObject = new JSONObject(objectWriter.writeValueAsString(user));
		
		mock.perform(put("/api/account/modifyUserById/2")
				.header("Content-Type", "application/json")
				.content(jsonObject.toString()))
		.andExpect(status().isUnauthorized())
		.andDo(print());
	}
	
	@Test
	public void updateUserByEmailOk() throws Exception {
		
		User user = new User(2,"micky","pass","Michele","Andrungo","admin@tiscali.it",true,"ADMIN");
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		JSONObject jsonObject = new JSONObject(objectWriter.writeValueAsString(user));
		
		mock.perform(put("/api/account/modifyUserByEmail/admin@tiscali.it")
				.header("Authorization", "Bearer " + this.jwtToken)
				.header("Content-Type", "application/json")
				.content(jsonObject.toString()))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void updateUserByEmailUnauthorized() throws Exception {
		
		User user = new User(2,"micky","pass","Michele","Andrungo","admin@tiscali.it",true,"ADMIN");
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		JSONObject jsonObject = new JSONObject(objectWriter.writeValueAsString(user));
		
		mock.perform(put("/api/account/modifyUserByEmail/admin@tiscali.it")
				.header("Content-Type", "application/json")
				.content(jsonObject.toString()))
		.andExpect(status().isUnauthorized())
		.andDo(print());
	}
	
	@Test
	public void updateUserByUsernameOk() throws Exception {
		User user = new User(2,"micky","pass","Michele","Andrungo","admin@tiscali.it",true,"ADMIN");
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		JSONObject jsonObject = new JSONObject(objectWriter.writeValueAsString(user));
		
		mock.perform(put("/api/account/modifyUserByUsername/micky")
				.header("Authorization", "Bearer " + this.jwtToken)
				.header("Content-Type", "application/json")
				.content(jsonObject.toString()))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void updateUserByUsernameUnauthorized() throws Exception {
		
		User user = new User(2,"micky","pass","Michele","Andrungo","admin@tiscali.it",true,"ADMIN");
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		JSONObject jsonObject = new JSONObject(objectWriter.writeValueAsString(user));
		
		mock.perform(put("/api/account/modifyUserByUsername/micky")
				.header("Content-Type", "application/json")
				.content(jsonObject.toString()))
		.andExpect(status().isUnauthorized())
		.andDo(print());
	}
	
	@Test
	public void getUserByIdOk() throws Exception {
		
		User user = new User(2,"micky", "$2a$10$vaMOlPqv6dCK98HX3fmz9uD2mRwxqAV0dUcMBBjJSKW4X4TsN7na.","Michele","Andrungo","admin@tiscali.it",true,"ADMIN");
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		JSONObject jsonObject = new JSONObject(objectWriter.writeValueAsString(user));
		
		mock.perform(get("/api/account/getUserById/2")
				.header("Authorization", "Bearer " + this.jwtToken))
		.andExpect(status().isOk())
		.andExpect(content().json(jsonObject.toString()))
		.andDo(print());
	}
	
	@Test
	public void getUserByIdUnauthorized() throws Exception {
		
		mock.perform(get("/api/account/getUserById/2"))
		.andExpect(status().isUnauthorized())
		.andDo(print());
	}
	
	@Test
	public void getUserByIdNotFound() throws Exception {
		
		mock.perform(get("/api/account/getUserById/100")
				.header("Authorization", "Bearer " + this.jwtToken))
		.andExpect(status().isNotFound())
		.andDo(print());
	}

}
