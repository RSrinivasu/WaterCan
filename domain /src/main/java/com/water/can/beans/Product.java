package com.water.can.beans;

import java.io.Serializable;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer productId;
	private Integer noOfTins;
	private User user;
	private Integer availableTins;
    private Tin tin;
    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getNoOfTins() {
		return noOfTins;
	}
	public void setNoOfTins(Integer noOfTins) {
		this.noOfTins = noOfTins;
	}
	public Integer getAvailableTins() {
		return availableTins;
	}
	public void setAvailableTins(Integer availableTins) {
		this.availableTins = availableTins;
	}
	public Tin getTin() {
		return tin;
	}
	public void setTin(Tin tin) {
		this.tin = tin;
	}
    
}
