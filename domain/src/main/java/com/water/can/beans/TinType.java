package com.water.can.beans;

import java.io.Serializable;

public class TinType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer tinId;
	private String tinName;
	private String capaciy;
	private String meterial;
	public Integer getTinId() {
		return tinId;
	}
	public void setTinId(Integer tinId) {
		this.tinId = tinId;
	}
	public String getTinName() {
		return tinName;
	}
	public void setTinName(String tinName) {
		this.tinName = tinName;
	}
	public String getCapaciy() {
		return capaciy;
	}
	public void setCapaciy(String capaciy) {
		this.capaciy = capaciy;
	}
	public String getMeterial() {
		return meterial;
	}
	public void setMeterial(String meterial) {
		this.meterial = meterial;
	}
	

}
