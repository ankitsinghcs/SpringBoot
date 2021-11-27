package com.trade.tradeDemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes= {TradeController.class})
@ExtendWith(SpringExtension.class)
public class TradeServiceControllerTest {

	
	@MockBean
	private TradeService service;
	
	@Autowired
	TradeController controller;
	
	@Test
	public void testEmployee() throws Exception {
		MockHttpServletRequestBuilder builder =  MockMvcRequestBuilders.get("/trades");
		MockMvcBuilders.standaloneSetup(this.controller)
				.build()
				.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk());
				//.andExpect(MockMvcResultMatchers.content().string(""));

	}
	
	@Test
	public void testEmployee1() throws Exception {
		MockHttpServletRequestBuilder builder =  MockMvcRequestBuilders.post("/trades").param("x", "xvalue");
		MockMvcBuilders.standaloneSetup(this.controller)
				.build()
				.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk());
				//.andExpect(MockMvcResultMatchers.content().string(""));

	}
	
}
