package com.capgemini.movieticketsystem.dao;

import com.capgemini.movieticketsystem.dto.UserBean ;

public interface UserDAO {
	public boolean userRegister(UserBean userBean);
	public UserBean userLogin(int userId, String userPassword);
	public boolean changePassword(int userId,String userPassword);
	public boolean updateContact(int userId,String contact);
	UserBean getUser(int userId);
}
