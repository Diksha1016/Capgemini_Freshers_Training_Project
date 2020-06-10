package com.capgemini.movieticketsystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.movieticketsystem.dto.BookBean;
import com.capgemini.movieticketsystem.dto.BookResponse;
import com.capgemini.movieticketsystem.service.BookService;


@RestController
@CrossOrigin(origins ="*",allowedHeaders="*",allowCredentials ="true")
public class BookController {
	@Autowired
	BookService service;

	@PostMapping(path = "/book-ticket", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BookResponse addStock(@RequestBody BookBean book) {
		BookResponse response = new BookResponse();
		if (service.bookMovieTicket(book)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Movie Ticket is booked successfully");
			response.setBook(Arrays.asList(book));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Movie Ticket booking has been Failed");
		}
		return response;
	}
	

	@DeleteMapping(path = "/delete-book/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookResponse deleteStock(@PathVariable("bookId") int bookId) {
		BookResponse response = new BookResponse();
		if (service.cancelBookings(bookId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Booking is cancelled....Soon you will be refunded");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Booking Details not found");
		}
		return response;
	}
	

	
	
	@GetMapping(path = "/search-booking/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public BookResponse searchBookings(@PathVariable ("userId")int userId) {
		BookResponse response = new BookResponse();
		List<BookBean> listBook = service.searchBookings(userId);
	
	if(listBook!=null)
		{
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Details of Bookings found");
			response.setBook(listBook);

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Booking doesn't exists");
		}
		return response;
	}
}
