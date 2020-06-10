package com.capgemini.movieticketsystem.dao;

import java.util.List;
import com.capgemini.movieticketsystem.dto.TheaterBean;


public interface TheaterDAO {
	public List<TheaterBean> searchTheater(String theaterCity);
	boolean updateTheater(int theaterId, TheaterBean theater);
	TheaterBean getTheater(int theaterId);
}
