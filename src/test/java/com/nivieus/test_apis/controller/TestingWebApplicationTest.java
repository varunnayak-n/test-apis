package com.nivieus.test_apis.controller;

import com.nivieus.test_apis.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class TestingWebApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	ObjectMapper objectMapper;


	@Test
	void testGetEmployees() throws Exception {
		this.mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Kumar")));
	}

	@Test
	void testGetEmployee() throws Exception {
		this.mockMvc.perform(get("/employees/X00001")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Kumar")));
	}

	@Test
	void testPostEmployee() throws Exception {

		Employee employee = new Employee();
		employee.setFirstname("John");
		employee.setLastName("Doe");
		employee.setActive(true);
		employee.setEmpId("X00003");


		objectMapper = new ObjectMapper();
		String jsonMessage = objectMapper.writeValueAsString(employee);
		this.mockMvc.perform(post("/employees/{employeeId}","X00003")
						.contentType(MediaType.APPLICATION_JSON).content(jsonMessage))
				.andDo(print()).andExpect(status().isOk());

		this.mockMvc.perform(get("/employees/X00003")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Doe")));
	}

	@Test
	void testDeleteEmployee() throws Exception {
		this.mockMvc.perform(delete("/employees/{employeeId}","X00000"))
				.andDo(print()).andExpect(status().isOk());
	}
}