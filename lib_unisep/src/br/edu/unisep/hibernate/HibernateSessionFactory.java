package br.edu.unisep.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static SessionFactory factory;
	
	private static SessionFactory getFactory() {
		if (factory == null) {
			Configuration config = new Configuration().configure();
			factory = config.buildSessionFactory();
		}
		
		return factory;
	}
	
	public static Session getSession() {
		SessionFactory f = getFactory();
		Session session = f.openSession();
		
		return session;
	}
	
}
