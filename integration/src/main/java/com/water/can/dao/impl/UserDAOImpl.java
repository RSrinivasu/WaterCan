package com.water.can.dao.impl;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.water.can.beans.Address;
import com.water.can.beans.User;
import com.water.can.dao.UserDAO;
import com.water.can.dao.sql.querys.SqlQuerys;



@Repository
public class UserDAOImpl implements UserDAO {
	  @Autowired
      private JdbcTemplate jdbcTemplate;	
	
	@Override
	public  Object saveUser(User user) {
		
		 UserStoredProcedure userStoredProcedure = new UserStoredProcedure();
			userStoredProcedure.setDataSource(jdbcTemplate.getDataSource());
			userStoredProcedure.setSql("register_user");
			userStoredProcedure.declareParameter(new SqlParameter("plate_no_in", Types.VARCHAR));
			userStoredProcedure.declareParameter(new SqlParameter("road_no_in", Types.INTEGER));
			userStoredProcedure.declareParameter(new SqlParameter("pincode_in", Types.INTEGER));
			userStoredProcedure.declareParameter(new SqlParameter("city_in", Types.VARCHAR));
			userStoredProcedure.declareParameter(new SqlParameter("area_in", Types.VARCHAR));
			userStoredProcedure.declareParameter(new SqlParameter("reg_name_in", Types.VARCHAR));
			
			
			userStoredProcedure.declareParameter(new SqlParameter("user_name_in", Types.VARCHAR));
			userStoredProcedure.declareParameter(new SqlParameter("mobile_in", Types.VARCHAR));
			userStoredProcedure.declareParameter(new SqlParameter("email_in", Types.VARCHAR));
			userStoredProcedure.declareParameter(new SqlParameter("password_in", Types.VARCHAR));
			userStoredProcedure.declareParameter(new SqlParameter("role_in", Types.VARCHAR));
			userStoredProcedure.declareParameter(new SqlParameter("status_in", Types.TINYINT));
			userStoredProcedure.declareParameter(new SqlOutParameter("user_id_out", Types.INTEGER));
		
				 Map<String, Object> inParamMap = new HashMap<String, Object>();
				 inParamMap.put("plate_no_in",user.getAddress().getPlateNo());
				 inParamMap.put("road_no_in",user.getAddress().getRoadNo()); 
				 inParamMap.put("pincode_in",user.getAddress().getPincode()); 
				 inParamMap.put("city_in",user.getAddress().getCity()); 
				 inParamMap.put("area_in",user.getAddress().getArea());
				 inParamMap.put("reg_name_in",user.getAddress().getRegName()); 
				 
				 inParamMap.put("user_name_in", user.getUserName()); 
				 inParamMap.put("mobile_in", user.getMobile()); 
				 inParamMap.put("email_in", user.getEmail());
				 inParamMap.put("password_in",user.getPassword()); 
				 inParamMap.put("role_in",user.getRole()); 
				 inParamMap.put("status_in",user.getStatus());
				 
				 Map<String, Object> outParamsMap = userStoredProcedure.execute(inParamMap);
					Object userId = outParamsMap.get("user_id_out");
					return userId;
	}
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserById(Integer userId) {
		  User user=null;
		 
		  user=jdbcTemplate.queryForObject(SqlQuerys.SQL_GET_USER_BY_USER_ID,(rs,rowNo) ->
		  {
			  User user1=new User();
			  Address address=new Address();
			  address.setArea(rs.getString("area"));
			  address.setCity(rs.getString("city"));
			  address.setPincode(rs.getInt("pincode"));
			  address.setPlateNo(rs.getString("plate_no"));
			  address.setRegName(rs.getString("reg_name"));
			  address.setRoadNo(rs.getInt("road_no"));
			  
			  user1.setUserId(rs.getInt("user_id"));
			  user1.setMobile(rs.getString("mobile"));
			  user1.setUserName(rs.getString("user_name"));
              user1.setEmail(rs.getString("email"));
              user1.setCreatedDate(rs.getTimestamp("created_date"));
			  user1.setAddress(address);
			  
			  return user1;
		  },
		  userId);	
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		 List<User> userList=null;
		 
		  userList=jdbcTemplate.query(SqlQuerys.SQL_GET_ALL_USERS,(rs,rowNo) ->
		  {
			  User user1=new User();
			  Address address=new Address();
			  address.setArea(rs.getString("area"));
			  address.setCity(rs.getString("city"));
			  address.setPincode(rs.getInt("pincode"));
			  address.setPlateNo(rs.getString("plate_no"));
			  address.setRegName(rs.getString("reg_name"));
			  address.setRoadNo(rs.getInt("road_no"));
			  
			 user1.setUserId(rs.getInt("user_id"));;
			 user1.setUserName(rs.getString("user_name"));
			 user1.setMobile(rs.getString("mobile"));
             user1.setEmail(rs.getString("email"));
             user1.setCreatedDate(rs.getTimestamp("created_date"));
			 user1.setAddress(address);
			  return user1;
		  });
		  return userList;
	}

	@Override
	public int deleteUser(Integer userId) {	
		return 0;
	}
	
	@Override
	public User loginUser(String  email) {
		 User user=null;
		 
		  user=jdbcTemplate.queryForObject(SqlQuerys.SQL_GET_USER_BY_EMAIL,(rs,rowNo) ->
		  {
			  User user1=new User(); 
			  user1.setUserId(rs.getInt("user_id"));
			  user1.setMobile(rs.getString("mobile"));
			  user1.setUserName(rs.getString("user_name"));
             user1.setEmail(rs.getString("email"));
            user1.setPassword("password");;
			  return user1;
		  },
		  email);	
		return user;
	}
}
