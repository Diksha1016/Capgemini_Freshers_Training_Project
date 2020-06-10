package com.capgemini.movieticketsystem.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.movieticketsystem.dto.TheaterBean;
import com.capgemini.movieticketsystem.exception.UserAccountException;
@Repository
public class TheaterDAOImpl implements TheaterDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public List<TheaterBean> searchTheater(String theaterCity) {
		List<TheaterBean> listTheater =new ArrayList<TheaterBean>();
		EntityManager entityManager = factory.createEntityManager();
		String jpql="from TheaterBean where theaterCity=:theaterCity";
		TypedQuery<TheaterBean> query = entityManager.createQuery(jpql,TheaterBean.class);
		query.setParameter("theaterCity", theaterCity);
		query.getResultList();
		listTheater = query.getResultList();
		entityManager.close();
		return listTheater;
	}
	@Override
	public boolean updateTheater(int theaterId, TheaterBean theater) {
		
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			TheaterBean bean = manager.find(TheaterBean.class, theaterId);
			if (bean != null) {
				transaction.begin();
				bean.setTheaterCity(theater.getTheaterCity());
				bean.setTheaterId(theater.getTheaterId());
				bean.setTheaterName(theater.getTheaterName());
				bean.setNoOfScreens(theater.getNoOfScreens());
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isUpdated;
	}
	@Override
	public TheaterBean getTheater(int theaterId) {
		String jpql = "from TheaterBean where theaterId=:theaterId";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<TheaterBean> query = manager.createQuery(jpql, TheaterBean.class);
		query.setParameter("theaterId", theaterId);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
				throw new UserAccountException("theater id not found");
			}
	}
 
}
