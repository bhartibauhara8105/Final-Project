package com.niit.jobmanagement;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.niit.jobmanagement.controllers.UserController;
import com.niit.jobmanagement.entities.User;
import com.niit.jobmanagement.repos.UserRepository;

@RunWith(SpringRunner.class)
public class UserControllerTest {
	
	MockMvc mockMvc;
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserRepository userRepository;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void showReg() throws Exception {
		User u=new User("Arpana","Tyagi","arpana@gmail.com","1234","7694859392","job provider");
		String s=u.getEmail();
		Mockito.when(userRepository.findByEmail(s)).thenReturn(u);
	mockMvc.perform(get("/showReg")).andExpect(status().isOk());
	
//				.andExpect(jsonPath("$.name").value("emp1"))
//				.andExpect(jsonPath("$.designation").value("manager"))
//				.andExpect(jsonPath("$.empId").value("1"))
//				.andExpect(jsonPath("$.salary").value(3000));

	}
	@Test
	public void showLogin() throws Exception {
		User u=new User("Arpana","Tyagi","arpana@gmail.com","1234","7694859392","job provider");
		String s=u.getEmail();
		Mockito.when(userRepository.findByEmail(s)).thenReturn(u);
	mockMvc.perform(get("/showLogin")).andExpect(status().isOk());
//	
////				.andExpect(jsonPath("$.name").value("emp1"))
////				.andExpect(jsonPath("$.designation").value("manager"))
////				.andExpect(jsonPath("$.empId").value("1"))
////				.andExpect(jsonPath("$.salary").value(3000));
//
	}
	@Test
	public void registerUser() throws Exception {
		User u=new User("Arpana","Tyagi","arpana@gmail.com","1234","7694859392","job provider");
		String s=u.getEmail();
		
		Mockito.when(userRepository.findByEmail(s)).thenReturn(u);
	//	mockMvc.perform(get("/registerUser")).andExpect(status().isOk());
//	
//				.andExpect(MockMvcResultMatchers.jsonPath(u.getFirstName()).value("Arpana"))
//				.andExpect(MockMvcResultMatchers.jsonPath(u.getLastName()).value("Tyagi"))
//				.andExpect(MockMvcResultMatchers.jsonPath(u.getEmail()).value("arpana@gmail.com"))
//				.andExpect(MockMvcResultMatchers.jsonPath(u.getPassword()).value("1234"))
//				.andExpect(MockMvcResultMatchers.jsonPath(u.getPhone()).value("7694859392"))
//				.andExpect(MockMvcResultMatchers.jsonPath(u.getRole()).value("job provider"));
//
	}
	@Test
	public void showuserModule() throws Exception {
		User u=new User("Arpana","Tyagi","arpana@gmail.com","1234","7694859392","job provider");
		String s=u.getEmail();
		
		Mockito.when(userRepository.findByEmail(s)).thenReturn(u);
		mockMvc.perform(get("/userModule")).andExpect(status().isOk());
//	
//				.andExpect(MockMvcResultMatchers.jsonPath(u.getFirstName()).value("Arpana"))
//				.andExpect(MockMvcResultMatchers.jsonPath(u.getLastName()).value("Tyagi"))
//				.andExpect(MockMvcResultMatchers.jsonPath(u.getEmail()).value("arpana@gmail.com"))
//				.andExpect(MockMvcResultMatchers.jsonPath(u.getPassword()).value("1234"))
//				.andExpect(MockMvcResultMatchers.jsonPath(u.getPhone()).value("7694859392"))
//				.andExpect(MockMvcResultMatchers.jsonPath(u.getRole()).value("job provider"));
//
	}
	@Test
	public void testLogin() throws Exception {

	    mockMvc.perform(get("/Login")).andExpect(status().isOk());
	    mockMvc.perform(get("/Login").param("logout", "log")).andExpect(status().isOk()).andExpect(model().attributeExists("msg"));
	    mockMvc.perform(get("/Login").param("error", "log")).andExpect(status().isOk()).andExpect(model().attributeExists("error"));
	    mockMvc.perform(get("/Login").param("logout", "log").param("error", "log")).andExpect(status().isOk()).andExpect(model().attributeExists("msg")).andExpect(model().attributeExists("error"));
	    mockMvc.perform(get("/Login")).andExpect(status().isOk()).andExpect(view().name("login"));
	}

}
