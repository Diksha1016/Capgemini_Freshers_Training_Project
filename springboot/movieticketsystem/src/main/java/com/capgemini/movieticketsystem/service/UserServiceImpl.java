package com.capgemini.movieticketsystem.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capgemini.movieticketsystem.dao.UserDAO;
import com.capgemini.movieticketsystem.dto.UserBean;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserDAO userDao;

	@Override
	public boolean userRegister(UserBean userBean) {
		
		return userDao.userRegister(userBean);
	}

	@Override
	public UserBean userLogin(int userId, String userPassword) {
		
		return userDao.userLogin(userId, userPassword);
	}

	@Override
	public boolean changePassword(int userId, String userPassword) {
		
		return userDao.changePassword(userId, userPassword);
	}

	@Override
	public boolean updateContact(int userId, String contact) {
	
		return userDao.updateContact(userId, contact);
	}

	@Override
	public UserBean getUser(int userId) {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
	}
	

}
