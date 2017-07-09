package com.water.can.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.water.can.beans.Response;
import com.water.can.beans.User;
import com.water.can.dao.OTPDAO;
import com.water.can.dao.UserAuthenticationDAO;
import com.water.can.dao.UserDAO;
import com.water.can.dao.sql.constents.DBConstants;
import com.water.can.otp.OTPGenerator;
import com.water.can.security.BCrypt;
import com.water.can.service.UserService;
import com.water.can.token.TokenGenerator;
import com.water.can.util.Rols;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
	private UserDAO userDAO;
    @Autowired
    private OTPDAO otpDAO;
    @Autowired
	private UserAuthenticationDAO userAuthenticationDAO;
    
	@Override
	public Response saveUser(User user) {
		Response response=null;
		   response=new Response();
		   response.setStatusCode("FAILURE");
		   response.setMessage("User Registration is Failure!Please Try agin....");
		   
	   if(user!=null && user.getAddress()!=null)
	   {
		   user.setStatus((byte)1);
		   if(user.getRole()==null)
		   {
		      user.setRole(Rols.USER);
		   }
		     try{
		    	   user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
		    	   Object obj=userDAO.saveUser(user);
		    	   if(obj!=null)
		    	   {
		    		   response.setStatusCode("SUCCESS");
		    		   response.setMessage("User Registration success.Your Registration ID:"+obj);
		           }
		    	   else{
		        	   throw new RuntimeException();
		           }
		     }
		     catch(Exception ex)
		     {
	    		   response.setStatusCode("EXCEPTION");
	    		   response.setMessage("User Registration is Failure!Please Try agin....");
	    		   ex.printStackTrace();
		     }
	   }
		
		return response;
	}

	@Override
	public Response getUserById(Integer userId) {
		User user=null;
		Response response;
		   response=new Response();
		   response.setStatusCode("FAILURE");
		   response.setMessage("get User Details  Failure!Please Try agin....");
	    try{
		  if(userId!=null && userId >0)
	      {
		     user=userDAO.getUserById(userId);
		     response.setStatusCode("SUCCESS");
		     if (user!=null) {
				response.setMessage("get User Details  Success");
				response.setData(user);
			}else
			{
				  response.setMessage("No user Found!");	
			}
	      }
	    }
	    catch(EmptyResultDataAccessException ex)
	    {
	    	  response.setStatusCode("FAILURE");
	  		  response.setMessage("User id not available!Please Try agin....");
	    }
	    catch(Exception ex)
	    {
	      response.setStatusCode("EXCEPTION");
  		  response.setMessage("Unable to Process!Please Try agin....");
  		 
	    }
		   return response;
	}

	@Override
	public Response getAllUsers() {
		List<User> userList=null;
		Response response;
		   response=new Response();
		   response.setStatusCode("FAILURE");
		   response.setMessage("get User Details  Failure!Please Try agin....");
	    try{
		     userList=userDAO.getAllUsers();
		     response.setStatusCode("SUCCESS");
		     if (userList!=null && !userList.isEmpty()) {
				response.setMessage("get UserList Details  Success");
				response.setData(userList);
			}else
			{
				  response.setMessage("No userlist Found!");	
			}
	    }
	    catch(Exception ex)
	    {
	      response.setStatusCode("EXCEPTION");
  		  response.setMessage("Unable to Process!Please Try agin....");
	    }
		   return response;
	}
	
	@Override
	public Response loginUser(User user) 
	{
		Response response = new Response();
		response.setStatusCode("FAILURE");
		response.setMessage("log-in is failed!Try again");
		if (user != null) {
			try {
				// handle exceptions
				// get UserPassword based on username
				// call check checkpw()
				// user get user_id,status,user_role,mobile,email in DB user
				User userDB = userDAO.loginUser(user.getEmail());
				
				if (BCrypt.checkpw(user.getPassword(),userDB.getPassword())) {         
					userDB.setPassword("");
					// user data is available or not
					if (userDB.getUserId() != null && userDB.getUserId() > 0 && userDB!= null) {
						// checking the code blocked user or not
						if (userDB.getStatus().equals(DBConstants.USER_STATUS_BLOCKED)) {
							response.setStatusCode("FAILURE");
							response.setMessage("Your account is Blocked! please contect custmoresuport@gmail.com");
						} else if (userDB.getStatus().equals(DBConstants.USER_STATUS_MOBILE_NOT_VERIFIED)
								&& userDB.getRole().equals(Rols.USER)) {
							// mobile verification code
							Integer otp = OTPGenerator.generateOTP();
							// otp is save in db
							if (otpDAO.saveOtp(otp, userDB.getUserId()) > 0) {
								// send sms verify the mobile
								String msg = "Dear user OTP(One Time Password) for registration is " + otp
										+ ". Please use this OTP to complete the registration. - MythriBus";
							//	String otpStatus = userSmsDAO.sendSms(user.getMobile(), msg);
	
								response.setData(userDB);;
								response.setStatusCode("SUCCESS");
								response.setMessage("OTP Sent to Registered Mobile *****"
										+ user.getMobile().substring(user.getMobile().length() - 3));
							}

						} else if (userDB.getStatus().equals(DBConstants.USER_STATUS_ACTIVE)) {
							// token generated
							String token = BCrypt.hashpw(TokenGenerator.getToken(userDB.getUserId()), BCrypt.gensalt());
							// first save the token in db and send token as a
							// response data to client
							int[] count = userAuthenticationDAO.saveToken(userDB.getUserId(),token, user.getLoginLog());
							
							if (count != null && count.length > 0 && count[0] > 0) {
								user.setToken(token);
								response.setStatusCode("SUCCESS");
								response.setMessage("Login Success");
								response.setData(user);
							}
						}
					}
				} else {
					response.setMessage("Invalid Password");
					response.setStatusCode("FAILURE");
				}

			} catch (IncorrectResultSizeDataAccessException exception) {
				response.setStatusCode("EXCEPTION");
				response.setMessage("Invalid UserId/Password");
			} catch (DataAccessException exception) {
				
				response.setStatusCode("EXCEPTION");
				response.setMessage("Unable to Processes!Please Try again...");

			} catch (Exception exception) {
				response.setStatusCode("EXCEPTION");
				response.setMessage("Unable to Processes!Please Try again..."+exception);
				exception.printStackTrace();
			}

		}

		return response;
	}
}
