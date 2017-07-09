
package com.water.can.dao.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.water.can.dao.OTPDAO;
import com.water.can.dao.sql.querys.SqlQuerys;

/**
 * OtpDAO is used to perform persistence operations on otp Table
 *
 * @author Srinu R
 * @version 1.0
 */
@Repository
public class OTPDAOImpl implements OTPDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	

	/**
	 * this method is used to save OTP
	 * 
	 * @param otp
	 * @param userId
	 * @return count
	 * @author Srinu R
	 */
	public int saveOtp(Integer otp, Integer userId) {

		return jdbcTemplate.update(SqlQuerys.SQL_SAVE_OTP,otp,userId);
	}

	/**
	 * this method is used to save OTP For Forgot password
	 * 
	 * @param otp
	 * @param date
	 * @return count
	 * @author Srinu R
	 */
	public int updateOtp(Integer otp, Date generatedTime, Integer userId) {

		return jdbcTemplate.update(SqlQuerys.SQL_FORGOT_UPDATE_OTP, otp, generatedTime, userId);
	}

}
