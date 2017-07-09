
package com.water.can.dao;

import java.sql.Date;

/**
 * OtpDAO is used to perform persistence operations on otp Table
 *
 * @author Srinu R
 * @version 1.0
 */
public interface OTPDAO {
	/**
	 * this method is used to save OTP
	 * 
	 * @param otp
	 * @param userId
	 * @return count
	 * @author Srinu R
	 */
	public int saveOtp(Integer otp, Integer userId);

	/**
	 * this method is used to save OTP For Forgot password
	 * 
	 * @param otp
	 * @param date
	 * @return count
	 * @author Srinu R
	 */
	public int updateOtp(Integer otp, Date generatedTime, Integer userId);

}
