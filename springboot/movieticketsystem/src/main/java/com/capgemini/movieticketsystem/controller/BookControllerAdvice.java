package com.capgemini.movieticketsystem.controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.movieticketsystem.dto.BookResponse;
import com.capgemini.movieticketsystem.exception.BookingException;

@RestControllerAdvice
public class BookControllerAdvice {
	@ExceptionHandler(BookingException.class)
	public BookResponse handleBookException(BookingException e) {
		BookResponse bookResponse = new BookResponse();
		bookResponse.setStatusCode(501);
		bookResponse.setMessage("Exception");
		bookResponse.setDescription(e.getMessage());
		return bookResponse;
	}
}
