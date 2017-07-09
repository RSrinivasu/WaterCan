
package com.water.can.dao;

import com.water.can.beans.LoginLog;

/**
 * UserAuthenticationDAO is used to perform persistence operations on UserAuthentication Table
 * @author Srinu R
 * @version 1.0
 */
public interface UserAuthenticationDAO {

	int[] saveToken(Integer userId, String token,LoginLog loginLog);
	
	public int checkAuthentication(Long userId,String token,int logOutStatus);
	
    public int	logoutUser(String userId,String token);
}
