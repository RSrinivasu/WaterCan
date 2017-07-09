package com.water.can.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.water.can.beans.Response;
import com.water.can.beans.User;
import com.water.can.service.UserService;

@RestController
@RequestMapping(value="user")
public class UserResource {

	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/register" ,method=RequestMethod.POST)
	@ResponseBody
	public Response registerUser(@RequestBody User user)
	{
        return userservice.saveUser(user);
	}
	@RequestMapping(value="/{userid}" ,method=RequestMethod.GET)
	@ResponseBody
	public Response getUserById(@PathVariable Integer userid)
	{
        return userservice.getUserById(userid);
	}
	@RequestMapping(value="/list" ,method=RequestMethod.GET)
	@ResponseBody
	public Response getUserList()
	{
        return userservice.getAllUsers();
	}
	@RequestMapping(value="/login" ,method=RequestMethod.POST)
	@ResponseBody
	public Response login(@RequestBody User user)
	{
        return userservice.loginUser(user);
	}

}
