package com.water.can.dao;

import java.util.List;

import com.water.can.beans.User;


public interface UserDAO {

     public Object saveUser(User user);
     public int updateUser(User user);
     public User getUserById(Integer userId);
     public List<User> getAllUsers();
     public int deleteUser(Integer userId);
	 public User loginUser(String email);
     
}
