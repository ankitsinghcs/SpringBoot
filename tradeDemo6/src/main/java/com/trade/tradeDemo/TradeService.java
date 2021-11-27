package com.trade.tradeDemo;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService  
{
	@Autowired
	private TradeRepositary repo; 
	
   public List<Trade> findAllTrade()
	{
	   return repo.findAll();
	} 
	

	public Optional<Trade> getTradeIdAndCounterPartyId(TradeCKey tradeCKey)
    {
		return repo.findById(tradeCKey);
    }
	
	public Trade saveTrade(Trade trade)
	{
		return repo.save(trade);
	}
	
    
    

}
