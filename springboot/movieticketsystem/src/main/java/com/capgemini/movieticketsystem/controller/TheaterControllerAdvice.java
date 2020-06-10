package com.capgemini.movieticketsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.movieticketsystem.dto.TheaterResponse;
import com.capgemini.movieticketsystem.exception.UserAccountException;
@RestControllerAdvice
public class TheaterControllerAdvice {
	@ExceptionHandler(UserAccountException.class)
	public TheaterResponse handleUserException(UserAccountException e) {
		TheaterResponse theaterResponse = new TheaterResponse();
		theaterResponse.setStatusCode(501);
		theaterResponse.setMessage("Exception");
		theaterResponse.setDescription(e.getMessage());
		return theaterResponse;
	}
}
