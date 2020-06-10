package com.capgemini.movieticketsystem.controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.movieticketsystem.dto.UserResponse;
import com.capgemini.movieticketsystem.exception.UserAccountException;

@RestControllerAdvice
public class UserControllerAdvice {
	@ExceptionHandler(UserAccountException.class)
	public UserResponse handleUserException(UserAccountException e) {
		UserResponse adminResponse = new UserResponse();
		adminResponse.setStatusCode(501);
		adminResponse.setMessage("Exception");
		adminResponse.setDescription(e.getMessage());
		return adminResponse;
	}
}
