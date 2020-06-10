package com.capgemini.movieticketsystem.dao;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.movieticketsystem.dto.BookBean;


@Repository
public class BookDAOImpl implements BookDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public boolean bookMovieTicket(BookBean book) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(book);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean cancelBookings(int bookId) {
		
		boolean isDeleted = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		BookBean book = manager.find(BookBean.class, bookId);
		if (book != null) {
			try {
				transaction.begin();
				manager.remove(book);
				transaction.commit();
				isDeleted = true;
			} catch (Exception e) {
				transaction.rollback();
			} finally {
				manager.close();
			}
		}
		return isDeleted;
	}

	public List<BookBean> searchBookings(int userId) {
		List<BookBean> listBooking =new ArrayList<BookBean>();
		EntityManager entityManager = factory.createEntityManager();
		String jpql="from BookBean where userId=:userId";
		TypedQuery<BookBean> query = entityManager.createQuery(jpql,BookBean.class);
		query.setParameter("userId", userId);
		query.getResultList();
		listBooking = query.getResultList();
		entityManager.close();
		return listBooking;
	}

}
