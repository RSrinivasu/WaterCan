package com.water.can.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Booking implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer bookingId;
	private Integer numberOfTins;
	private Integer tinId;
	private User  user;
	private Double finalFare;
	private Byte status;
	private Timestamp dateOfBooking;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getNumberOfTins() {
		return numberOfTins;
	}
	public void setNumberOfTins(Integer numberOfTins) {
		this.numberOfTins = numberOfTins;
	}
	public Integer getTinId() {
		return tinId;
	}
	public void setTinId(Integer tinId) {
		this.tinId = tinId;
	}
	public Double getFinalFare() {
		return finalFare;
	}
	public void setFinalFare(Double finalFare) {
		this.finalFare = finalFare;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Timestamp getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Timestamp dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	
	
	

}
