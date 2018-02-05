package fr.m2i.formation.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOUtil {

	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("mysql_film_pu");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	
	public static void close() {
		emf.close();
	}
	
	
}
