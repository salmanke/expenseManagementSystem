package com.deloitte.dao;

import org.hibernate.Session;

import com.deloitte.entities.User;
import com.deloitte.util.HibernateHelper;

public class UserDAO {

	// Default Constructor
	public UserDAO() {

	}

	/**
	 * This method fetches the user based on the entered username and password
	 * 
	 * @param
	 * @return User
	 * @author Group 2
	 */
	public static User getUserByUsernamePassword(String userName, String password) {

		User u = null;

		try (Session s = HibernateHelper.getInstance().openSession();) {
			// HQL query to retrieve unique record from Database with the given username and
			// password

			String query = "from User where userName =: e and password =: p";

			u = (User) s.createQuery(query).setParameter("e", userName).setParameter("p", password).uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;

	}

	/**
	 * This method checks if the entered username is already existing in the
	 * database
	 * 
	 * @param
	 * @return User
	 * @author Group 2
	 */
	public static User getUserByUserName(String userName) {
		User u = null;

		try (Session s = HibernateHelper.getInstance().openSession();) {

			// HQL query to retrieve unique record from Database with the given username
			String query = "from User where userName =: u";

			u = (User) s.createQuery(query).setParameter("u", userName).uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

}
