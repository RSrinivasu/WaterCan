package com.water.can.beans;

import java.io.Serializable;

public class Tin implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer tinId;
	private TinType tinType;
	private Byte status;
	private Double fare;
	/**
	 * @return the fare
	 */
	public Double getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public Integer getTinId() {
		return tinId;
	}
	public void setTinId(Integer tinId) {
		this.tinId = tinId;
	}
	public TinType getTinType() {
		return tinType;
	}
	public void setTinType(TinType tinType) {
		this.tinType = tinType;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	
}
