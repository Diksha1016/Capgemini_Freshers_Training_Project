package com.capgemini.movieticketsystem.dao;
import java.util.List;

import com.capgemini.movieticketsystem.dto.BookBean;

public interface BookDAO {
	boolean bookMovieTicket(BookBean book);
	boolean cancelBookings(int bookId);
	public List<BookBean> searchBookings(int userId);
}
