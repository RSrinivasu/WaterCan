package com.water.can.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.water.can.beans.LoginLog;
import com.water.can.dao.UserAuthenticationDAO;
import com.water.can.dao.sql.querys.SqlQuerys;

/**
 * UserAuthenticationDAO is used to perform persistence operations on
 * UserAuthentication Table
 * 
 * @author Srinu R
 * @version 1.0
 */
@Repository
public  class UserAuthenticationDAOImpl implements UserAuthenticationDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int[] saveToken(Integer userId, String token, LoginLog loginLog) {
		final String SQL_SAVE_TOKEN = "insert into user_authentication(user_id,token,logout_status)values(" + userId
				+ ",'" + token + "'," + "0" + ")";
		final String SQL_SAVE_LOGIN_LOG = "insert into login_log(user_id,user_ip,user_agent,session_id) values("
				+ userId +",'" + loginLog.getUserIp() + "','" + loginLog.getUserAgent() + "','"
				+ loginLog.getSessionId() + "')";
		return jdbcTemplate.batchUpdate(SQL_SAVE_TOKEN, SQL_SAVE_LOGIN_LOG);
	}

	public int checkAuthentication(Long userId, String token, int logOutStatus) {
		return jdbcTemplate.queryForObject(SqlQuerys.SQL_CHECK_AUTHENTICATION, Integer.class, userId, token,
				logOutStatus);
	}

	@Override
	public int logoutUser(String userId, String token) {
		
		// '1'  one this logout status
		return	jdbcTemplate.update(SqlQuerys.SQL_UPDATE_LOGOUT_STATUS,1,userId,token);
	}
}
