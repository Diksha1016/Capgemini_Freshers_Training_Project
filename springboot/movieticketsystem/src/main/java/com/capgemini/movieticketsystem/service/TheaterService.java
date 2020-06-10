package com.capgemini.movieticketsystem.service;

import java.util.List;

import com.capgemini.movieticketsystem.dto.TheaterBean;

public interface TheaterService {
	public List<TheaterBean> searchTheater(String theaterCity);
	boolean updateTheater(int theaterId, TheaterBean theater);
	TheaterBean getTheater(int theaterId);
}
