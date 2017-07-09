package com.water.can.dao.sql.querys;

public class SqlQuerys {

	// SQLQuerys of User
	public static final String SQL_GET_USER_BY_USER_ID = "select user.user_id,user.user_name,user.email,user.created_date,user.mobile,"
			+ "address.plate_no,address.road_no,address.pincode, address.city,address.area,address.reg_name from user as user "
			+ "INNER JOIN address as address  on user.address_id=address.address_id " + "where user.user_id=?";

	public static final String SQL_GET_ALL_USERS = "select user.user_id,user.user_name,user.email,user.created_date,user.mobile,"
			+ "address.plate_no,address.road_no,address.pincode, address.city,address.area,address.reg_name from user as user "
			+ "INNER JOIN address as address  on user.address_id=address.address_id ";

	public static final String SQL_GET_USER_BY_EMAIL="SELECT user.user_id,user.user_name,user.mobile,user.role,user.email FROM user as user WHERE user.email=?";

// SQLQuerys of OTP
	public final static String SQL_SAVE_OTP = "insert into otp_authentication(otp,user_id) values(?,?)";
	public final static String SQL_FORGOT_UPDATE_OTP = "update otp_authentication set otp=?, generated_time=? where user_id=?";
//SQLQuerys of AUTHENTICATION
	public static final String SQL_CHECK_AUTHENTICATION =  "select count(*) from user_authentication where user_id=? and token=? and logout_status=?";

	public static final String SQL_UPDATE_LOGOUT_STATUS="update user_authentication set logout_status=? where user_id=? and token=?";


	

}
