package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	// Employee with id = 6 doesn't exist. 
	@Test
	public void testGetEmployeeException() throws Exception {
		ResultActions actions = mvc.perform(put("/employees").contentType(MediaType.APPLICATION_JSON).content(getContentOfEmployee6()));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Employee Not Found"));
	}
	private String getContentOfEmployee6() {
		return "{\"id\":6,\"name\":\"employee6\",\"salary\":30000,\"permanent\":true,\"dateOfBirth\":null,\"department\":{\"id\":1,\"name\":\"department1\"},\"skill\":{\"id\":1,\"name\":\"skill1\"}}";
	}
	/*private String getContentOfEmployee1() {
		return "{\"id\":1,\"name\":\"employee1\",\"salary\":30000,\"permanent\":true,\"dateOfBirth\":null,\"department\":{\"id\":1,\"name\":\"department1\"},\"skill\":{\"id\":1,\"name\":\"skill1\"}}";
	}*/
	
	@Test
	public void testDeleteEmployeeException() throws Exception {
		ResultActions actions = mvc.perform(delete("/employees").contentType(MediaType.APPLICATION_JSON).content(getContentOfEmployee1()));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Employee Not Found"));
	}
	private String getContentOfEmployee1() {
		return "{\"id\":6,\"name\":\"xyz\",\"salary\":30000,\"permanent\":true,\"dateOfBirth\":\"03/06/1998\",\"department\":{\"id\":1,\"name\":\"computer\"},\"skill\":{\"id\":1,\"name\":\"java\"}}";
	}
}
