package com.trade.tradeDemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TradeNotFoundException extends RuntimeException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TradeNotFoundException(String message) 
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

}
