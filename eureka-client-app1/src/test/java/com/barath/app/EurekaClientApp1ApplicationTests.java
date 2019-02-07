package com.barath.app;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class EurekaClientApp1ApplicationTests {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@org.junit.Before
	public void setUp(){
		System.out.println("Before is called");
		this.mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}	
	

	@Test
	public void testFeignClients() throws Exception {
		String response=mockMvc.perform(get("/app2")).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertEquals(response, "Response from Client 2");
	}
	
	
	

}
