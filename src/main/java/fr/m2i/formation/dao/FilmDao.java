package fr.m2i.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.m2i.formation.bean.Film;


public class FilmDao extends AbstractDao {
	public List<Film> getAllFilms(){
		String qr = "SELECT Object(f) from Film f";
		return DAOUtil.getEntityManager().createQuery(qr).getResultList();
	}
	public Film getFilm(int index) {
		return DAOUtil
				.getEntityManager()
				.find(Film.class, index);
	}
	public boolean filmExists(String titre) {
		String req = "SELECT Object(f) from Film f where titre = :titre";
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		boolean exist = em.createQuery(req).setParameter("titre", titre).getResultList().size() > 0 ? true : false;
		em.close();
		return exist;
		
	}
	public boolean filmExists(Film f) {
		return filmExists(f.getTitre());
	}
	public void updateFilm(Film f) throws Exception {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		try {
			em.merge(f);
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}
		finally {
			em.close();
		}
	}
	public void addFilm(Film f) throws Exception {
		if(!filmExists(f)) {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		
		try {
			em.persist(f);
			et.commit();
		} catch (Exception e) {
			throw new Exception("Un problème à eu lieu lors de l'ajout du film");
		}
		finally {
			em.close();
		}
		}
		else {
			throw new Exception("Ce film existe déja");
		}
	}
	public void deleteFilm(int index) {
		
		EntityManager em = DAOUtil.getEntityManager();
		
		Film f1 = em.find(Film.class, index);
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		try {
			em.remove(f1);
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}
		finally {
			em.close();
		}
	}
}
