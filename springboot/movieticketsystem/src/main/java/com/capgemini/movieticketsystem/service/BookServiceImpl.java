package com.capgemini.movieticketsystem.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.movieticketsystem.dao.BookDAO;
import com.capgemini.movieticketsystem.dao.TheaterDAO;
import com.capgemini.movieticketsystem.dao.UserDAO;
import com.capgemini.movieticketsystem.dto.BookBean;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
    private BookDAO bookDao;
	@Autowired
	UserDAO userDao;
	@Autowired
	TheaterDAO theaterDao;
	
	@Override
	public boolean bookMovieTicket(BookBean book) {
		return bookDao.bookMovieTicket(book);
	}

	@Override
	public boolean cancelBookings(int bookId) {
		return bookDao.cancelBookings(bookId);
	}

	@Override
	public List<BookBean> searchBookings(int userId) {
		return bookDao.searchBookings(userId);
	}

	

}
