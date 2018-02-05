package fr.m2i.formation.bean;

import javax.persistence.Entity;

@Entity
public class Acteur extends Personne {
	public Acteur() {
		super();
	}
	public Acteur(String nomPrenom) {
		super(nomPrenom);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
}
