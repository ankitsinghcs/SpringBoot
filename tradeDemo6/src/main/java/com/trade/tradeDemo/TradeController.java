package com.trade.tradeDemo;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController 
{
	@Autowired
	private TradeService service;
/*     	
	//http://localhost:8080/trades
	@GetMapping("/trades")
	public List<Trade> listAllTrade()
	{
	   List<Trade> tradeList = service.findAllTrade();
	   if(tradeList.size() > 0) {
           return tradeList;
       } else 
       {
           return new ArrayList<Trade>();
       }
	   
	}
	
    //http://localhost:8080/trades-by-composite-key?tradeId=T1&counterPartyId=1
	@GetMapping("/trades-by-composite-key")
	public Trade listTradeWithTradeIdAndVersion(@RequestParam(name="tradeId") String tradeId,
										   @RequestParam(value = "counterPartyId")String counterPartyId)
	{
	    Optional<Trade> trade=service.getTradeIdAndCounterPartyId(new TradeCKey(tradeId,counterPartyId));
	    
	    if(trade.isPresent()) 
	    {
            return trade.get();
        } 
	    else 
        {
        	throw new TradeNotFoundException("Record not found with given tradeId: "+tradeId +" & " +"version: "+ counterPartyId);
        }
	}
	
	@PostMapping("/trades")
	public Trade createOrUpdateTrade(@RequestBody Trade entity) 
    {
		Date currentDate= new java.sql.Date(System.currentTimeMillis());
        Date maturitydate=entity.getMaturityDate();
        
        String temtradeId=entity.getTradeCKey().getTradeId();
		String tempCountryPartyId=entity.getTradeCKey().getCounterPartyId();
	    
		Optional<Trade> trade=service.getTradeIdAndCounterPartyId(new TradeCKey(temtradeId,tempCountryPartyId));
		
        if(trade.isPresent()) 
        {
        	Trade newEntity = trade.get();
            //1(a)
            if(entity.getVersionId() < trade.get().getVersionId()) 
            {
             throw new RecordNotSavedOrUpdated("Record not saved with the lower version.");
            }
            //1(b)
            else 
            {
            	newEntity.setVersionId(entity.getVersionId());
            }
            //2
            if(maturitydate.compareTo(currentDate)<0)
            {
            	throw new RecordNotSavedOrUpdated("Record not saved if maturitydate is lesser then current date."); 	 	
            }
            
            newEntity.setBookId(entity.getBookId());
            newEntity.setCreatedDate(entity.getCreatedDate());
            newEntity.setMaturityDate(entity.getMaturityDate());
            newEntity.setExpired(entity.getExpired());
            
            newEntity = service.saveTrade(newEntity);
             
            return newEntity;
        } 
        else 
        {
        	if(maturitydate.compareTo(currentDate)<0)
            {
            	throw new RecordNotSavedOrUpdated("Record not saved if maturitydate is lesser then current date."); 	 	
            }
            entity = service.saveTrade(entity);
            return entity;
        }
    } 
	
	
	
	
*/	
	//http://localhost:8080/trades
	@GetMapping("/trades")	
    public ResponseEntity<List<Trade>> getAllTrade() 
	{
	    try 
	    {
	    	List<Trade> tradeList = service.findAllTrade();
	    	return new ResponseEntity<List<Trade>>(tradeList,HttpStatus.FOUND);
	    } 
	    catch (NoSuchElementException e) 
	    {
	        return new ResponseEntity<List<Trade>>(HttpStatus.NOT_FOUND);
	    }      
	}

	
	    //http://localhost:8080/trades-by-composite-key?tradeId=T1&counterPartyId=1
		@GetMapping("/trades-by-composite-key")
		public ResponseEntity<Trade> listTradeWithTradeIdAndVersion(@RequestParam(name="tradeId") String tradeId,
											   @RequestParam(value = "counterPartyId")String counterPartyId)
		{
		    Optional<Trade> trade=service.getTradeIdAndCounterPartyId(new TradeCKey(tradeId,counterPartyId));
		    
		    if(trade.isPresent()) 
		    {
		    	return new ResponseEntity<>(trade.get(),HttpStatus.FOUND);
	        } 
		    else 
	        {
		    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    	//throw new TradeNotFoundException("Record not found with given tradeId: "+tradeId +" & " +"version: "+ counterPartyId);
	        }
		}
		
		
		@PostMapping("/trades")
		public Trade createOrUpdateTrade(@RequestBody Trade entity) 
	    {
			Date currentDate= new java.sql.Date(System.currentTimeMillis());
	        Date maturitydate=entity.getMaturityDate();
	        
	        String temtradeId=entity.getTradeCKey().getTradeId();
			String tempCountryPartyId=entity.getTradeCKey().getCounterPartyId();
		    
			Optional<Trade> trade=service.getTradeIdAndCounterPartyId(new TradeCKey(temtradeId,tempCountryPartyId));
			
	        if(trade.isPresent()) 
	        {
	        	Trade newEntity = trade.get();
	            //1(a)
	            if(entity.getVersionId() < trade.get().getVersionId()) 
	            {
	             throw new RecordNotSavedOrUpdated("Record not saved with the lower version.");
	            }
	            //1(b)
	            else 
	            {
	            	newEntity.setVersionId(entity.getVersionId());
	            }
	            //2
	            if(maturitydate.compareTo(currentDate)<0)
	            {
	            	throw new RecordNotSavedOrUpdated("Record not saved if maturitydate is lesser then current date."); 	 	
	            }
	            
	            newEntity.setBookId(entity.getBookId());
	            newEntity.setCreatedDate(entity.getCreatedDate());
	            newEntity.setMaturityDate(entity.getMaturityDate());
	            newEntity.setExpired(entity.getExpired());
	            
	            newEntity = service.saveTrade(newEntity);
	             
	            return newEntity;
	        } 
	        else 
	        {
	        	if(maturitydate.compareTo(currentDate)<0)
	            {
	            	throw new RecordNotSavedOrUpdated("Record not saved if maturitydate is lesser then current date."); 	 	
	            }
	            entity = service.saveTrade(entity);
	            return entity;
	        }
	    } 
		

	
}
