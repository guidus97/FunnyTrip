package org.onlineSolutions.FunnyTrip;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
		mock = MockMvcBuilders.webAppContextSetup(webAppCont).build();
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

}
