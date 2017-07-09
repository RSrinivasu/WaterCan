package com.water.can.service;


import com.water.can.beans.Response;
import com.water.can.beans.User;

public interface UserService {

	  public Response saveUser(User user);
	  public Response getUserById(Integer userId);
	  public Response getAllUsers();
	  public Response loginUser(User user);
}
