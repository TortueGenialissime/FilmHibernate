package fr.m2i.formation.bean;

import javax.persistence.Entity;

@Entity
public class Realisateur extends Personne {
	public Realisateur() {
		super();
	}
	public Realisateur(String nomPrenom) {
		super(nomPrenom);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
}
