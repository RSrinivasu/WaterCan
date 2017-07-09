package com.water.can.beans;

import java.io.Serializable;

public class Response implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/*
	 * 200 :
	 * 300 :
	 * 
	 */
	private Integer statusCode;
	/**
	 * error codes: FAILURE,SUCCESS,FAILURE
	 */
	private String errorCode;
	private String message;
    private Object data;
    private Object[] listData;
    
   	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * @return the listData
	 */
	public Object[] getListData() {
		return listData;
	}
	/**
	 * @param listData the listData to set
	 */
	public void setListData(Object[] listData) {
		this.listData = listData;
	}   
}
