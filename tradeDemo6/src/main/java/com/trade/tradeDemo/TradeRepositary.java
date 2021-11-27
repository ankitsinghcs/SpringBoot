package com.trade.tradeDemo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TradeRepositary extends JpaRepository<Trade,TradeCKey> //MODEL,DATA TYPE OF PRIMARY KEY
{
	   /* @Query("SELECT t FROM Trade t WHERE t.tradeId = ?1")
	    List<Trade> findByTradeID(String tradeId);
	   */
	
		//public Optional<Trade> getTradeByIdAndCounterPartyId(TradeCKey tradeCKey);
}

