package com.trade.tradeDemo;

import java.util.Calendar;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronService 
{
	private TradeRepositary repo;
	
	    
		
		/*@Query("SELECT t FROM Trade t WHERE t.tradeId = ?1")
	    List<Trade> findByTradeID(String tradeId);
	   */
		
		//@Scheduled(cron="0 0 0 * * ?")
		//@Modifying
		//@Query(value = "update Trade u set u.expired = ? where u.maturityDate = ?", nativeQuery = true)
		//int updateUserSetStatusForNameNative(@Param String expired, Date name);
		
		@Scheduled(initialDelay = 1000, fixedRate = 10000)
		public void updateExpireFlag() 
		{
		    System.out.println("Current time is :: " + Calendar.getInstance().getTime());
		}
}
