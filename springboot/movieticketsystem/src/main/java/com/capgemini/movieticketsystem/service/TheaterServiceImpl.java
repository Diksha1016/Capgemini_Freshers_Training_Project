package com.capgemini.movieticketsystem.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.movieticketsystem.dao.TheaterDAO;
import com.capgemini.movieticketsystem.dto.TheaterBean;
@Service
public class TheaterServiceImpl implements TheaterService{
	@Autowired
    private TheaterDAO theaterDao;
	@Override
	public List<TheaterBean> searchTheater(String theaterCity) {
		
		return theaterDao.searchTheater(theaterCity);
	}
	@Override
	public boolean updateTheater(int theaterId, TheaterBean theater) {
		
		return theaterDao.updateTheater(theaterId, theater);
	}
	@Override
	public TheaterBean getTheater(int theaterId) {
		// TODO Auto-generated method stub
		return theaterDao.getTheater(theaterId);
	}

}
