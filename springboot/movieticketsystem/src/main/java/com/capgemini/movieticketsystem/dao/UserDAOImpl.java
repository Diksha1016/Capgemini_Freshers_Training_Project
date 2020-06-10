package com.capgemini.movieticketsystem.dao;
import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.capgemini.movieticketsystem.dto.UserBean;
import com.capgemini.movieticketsystem.exception.UserAccountException;

@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean userRegister(UserBean userBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(userBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new UserAccountException("This particular id already exists");
		}
	}

	@Override
	public UserBean userLogin(int userId, String userPassword) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from UserBean where userId =: userId and userPassword=: userPassword";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);
		query.setParameter("userPassword", userPassword);
		try {
			UserBean admin = (UserBean) query.getSingleResult();
			if (admin.getUserPassword().equals(userPassword)) {
				return admin;
			}
			return null;
		} catch (Exception e) {

		}
		throw new UserAccountException("Sorry....account doesn't exists");
	}

	@Override
	public boolean updateContact(int userId, String contact) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		transaction.begin();
		UserBean bean = manager.find(UserBean.class,userId);
		bean.setContact(contact);
		transaction.commit();
		return true;
	}

	@Override
	public boolean changePassword(int userId, String userPassword) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		transaction.begin();
		UserBean bean = manager.find(UserBean.class,userId);
		bean.setUserPassword(userPassword);
		transaction.commit();
		return true;
	}

	@Override
	public UserBean getUser(int userId) {
		String jpql = "from UserBean where userId=:userId";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<UserBean> query = manager.createQuery(jpql, UserBean.class);
		query.setParameter("userId", userId);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
				throw new UserAccountException("user not found");
			}
	}


}
