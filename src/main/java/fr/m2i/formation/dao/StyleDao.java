package fr.m2i.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.m2i.formation.bean.Style;
import fr.m2i.formation.exception.DAOException;


public class StyleDao extends AbstractDao {
	public List<Style> getAllStyle(){
		String qr = "SELECT Object(s) from Style s";
		return DAOUtil.getEntityManager().createQuery(qr).getResultList();
	}
	public Style getStyle(int index) {
		return DAOUtil
				.getEntityManager()
				.find(Style.class, index);
	}
	public boolean styleExists(String libelle) {
		String req = "SELECT Object(s) from Style s where libelle = :libelle";
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		boolean exist = em.createQuery(req).setParameter("libelle", libelle).getResultList().size() > 0 ? true : false;
		em.close();
		return exist;
		
	}
	public boolean styleExists(Style s) {
		return styleExists(s.getLibelle());
	}
	
	public int addStyle(String libelle) throws Exception {
		if(!styleExists(libelle)) {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		Style s = new Style(libelle);
		et.begin();
		
		
		try {
			em.persist(s);
			et.commit();
			return s.getId();
		} catch (Exception e) {
			et.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			em.close();
		}
		}
		else {
			throw new Exception("Ce style existe déja");
		}
		
	}
	public int addStyle(Style s) throws Exception {
		return addStyle(s.getLibelle());
	}
	
	public void updateStyle(Style s) throws Exception {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		try {
			em.merge(s);
			et.commit();
		} catch (Exception e) {
			et.rollback();;
		}
		finally {
			em.close();
		}
	}
	public void deleteStyle(int index) {
		
		EntityManager em = DAOUtil.getEntityManager();
		
		Style p1 = em.find(Style.class, index);
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		try {
			em.remove(p1);
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}
		finally {
			em.close();
		}
	}
}
