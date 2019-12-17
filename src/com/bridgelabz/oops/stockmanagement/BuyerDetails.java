package com.bridgelabz.oops.stockmanagement;

public class BuyerDetails {
	private String buyerName;
	private String companyName;
	private int stockValue;
	private int unit;
	private int totalValue;
	private String Status;
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	private String time;
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getStockValue() {
		return stockValue;
	}
	public void setStockValue(int stockValue) {
		this.stockValue = stockValue;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	@Override
	public String toString() {
		return "BuyerDetails buyerName=" + buyerName +"\n"+ " companyName=" + companyName +"\n"+ " stockValue=" + stockValue
				+"\n"+ " unit=" + unit +"\n"+" totalValue=" + totalValue + "\n"+" Status=" + Status + "]";
	}
	
	
	

}
