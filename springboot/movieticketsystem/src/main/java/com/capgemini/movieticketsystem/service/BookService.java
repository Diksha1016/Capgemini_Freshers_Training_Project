package com.capgemini.movieticketsystem.service;

import java.util.List;

import com.capgemini.movieticketsystem.dto.BookBean;

public interface BookService {
	boolean bookMovieTicket(BookBean book);
	boolean cancelBookings(int bookId);
	public List<BookBean> searchBookings(int userId);
}
