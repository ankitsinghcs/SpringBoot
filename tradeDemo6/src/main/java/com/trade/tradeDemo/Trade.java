package com.trade.tradeDemo;



import java.io.Serializable;
import java.sql.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TRADE",schema="world")


public class Trade implements Serializable 

{
	 /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 
	 @EmbeddedId
	 private TradeCKey tradeCKey;
	 
	 
	 private String bookId;
	 private Date maturityDate;
	 private Date createdDate;
	 private String expired;
	 private int versionId;
	 
	 public TradeCKey getTradeCKey() 
	 {
		return tradeCKey;
	 }
	
	 public void setTradeCKey(TradeCKey tradeCKey) 
	 {
		this.tradeCKey = tradeCKey;
	 }
	
	
	 public int getVersionId() 
	 {
		return versionId;
	 }

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	public Trade() 
	{
		
	}
	
	public Trade(TradeCKey tradeCKey, int versionId, String bookId, Date maturityDate, Date createdDate,
			String expired) {
		super();
		this.tradeCKey = tradeCKey;
		this.versionId = versionId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}
	 
	 
	 
	 
	 
}
