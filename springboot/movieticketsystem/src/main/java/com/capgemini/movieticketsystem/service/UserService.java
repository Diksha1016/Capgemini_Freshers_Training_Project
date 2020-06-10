package com.capgemini.movieticketsystem.service;

import com.capgemini.movieticketsystem.dto.UserBean;

public interface UserService {
	public boolean userRegister(UserBean userBean);
	public UserBean userLogin(int userId, String userPassword);
	public boolean changePassword(int userId,String userPassword);
	public boolean updateContact(int userId,String contact);
	UserBean getUser(int userId);
}
