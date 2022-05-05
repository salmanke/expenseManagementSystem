package com.deloitte.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {

	// For reusability, hibernate Configuration and Session Factory object is
	// created here
	// Declaring Session factory object

	private static SessionFactory sf;

	public static SessionFactory getInstance() {

		if (sf == null) {

			// Initialising Session factory object
			sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return sf;

	}

}
