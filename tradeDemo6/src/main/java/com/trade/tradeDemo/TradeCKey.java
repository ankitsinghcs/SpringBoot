package com.trade.tradeDemo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable

public class TradeCKey implements Serializable
{
	private String tradeId;
	private String counterPartyId;
	
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public String getCounterPartyId() {
		return counterPartyId;
	}
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(counterPartyId, tradeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeCKey other = (TradeCKey) obj;
		return Objects.equals(counterPartyId, other.counterPartyId) && Objects.equals(tradeId, other.tradeId);
	}
	
	@Override
	public String toString() {
		return "TradeCKey [tradeId=" + tradeId + ", counterPartyId=" + counterPartyId + "]";
	}
	public TradeCKey() {}

	public TradeCKey(String tradeId, String counterPartyId) {
		super();
		this.tradeId = tradeId;
		this.counterPartyId = counterPartyId;
	}
  	
	 
}
