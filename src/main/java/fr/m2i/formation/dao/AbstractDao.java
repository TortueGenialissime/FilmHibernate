package fr.m2i.formation.dao;

public abstract class AbstractDao {

	
	public void close() {
		DAOUtil.close();
	}
}
