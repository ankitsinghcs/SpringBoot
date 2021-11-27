package com.trade.tradeDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes= {TradeService.class})
@ExtendWith(SpringExtension.class)
public class TradeServiceTest {
	@MockBean
	private TradeRepositary repo; 
	
	@Autowired
	private TradeService service;
	
	@Test
	public void findAllTradeTest() 
	{
		List<Trade> tradeList= new ArrayList<>();
		when(repo.findAll()).thenReturn(tradeList);
		assertNotNull(service.findAllTrade());
		assertEquals(new ArrayList<>(), service.findAllTrade());
	}
    
	@Test
	public void getTradeIdAndCounterPartyId() 
	{
		List<Trade> tradeList= new ArrayList<>();
		//when(repo.findAll()).thenReturn(tradeList);
		assertNotNull(service.getTradeIdAndCounterPartyId(new TradeCKey("T1","CP-1")));
		//assertEquals(new ArrayList<>(), service.getTradeIdAndCounterPartyId());
	}
	
	

}
