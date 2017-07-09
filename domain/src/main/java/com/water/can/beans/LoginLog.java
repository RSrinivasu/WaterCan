package com.water.can.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class LoginLog implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer loginLogId;
	private Integer userId;
	private Timestamp loginTime;
	private String userIp;
	private String userAgent;
	private String sessionId;
	/**
	 * @return the loginLogId
	 */
	public Integer getLoginLogId() {
		return loginLogId;
	}
	/**
	 * @param loginLogId the loginLogId to set
	 */
	public void setLoginLogId(Integer loginLogId) {
		this.loginLogId = loginLogId;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the loginTime
	 */
	public Timestamp getLoginTime() {
		return loginTime;
	}
	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * @return the userIp
	 */
	public String getUserIp() {
		return userIp;
	}
	/**
	 * @param userIp the userIp to set
	 */
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	/**
	 * @return the userAgent
	 */
	public String getUserAgent() {
		return userAgent;
	}
	/**
	 * @param userAgent the userAgent to set
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
