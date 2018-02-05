package fr.m2i.formation.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.commons.lang.StringEscapeUtils;
@Entity
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String annee;
	@ManyToOne
	private Style style;
	private String duree;
	private boolean vu;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Acteur> acteurs;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval=true)
	private Realisateur realisateur;
	@Column(columnDefinition="text")
	private String synopsis;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public boolean isVu() {
		return vu;
	}
	public void setVu(String resp) {
		switch (resp) {
		case "oui":
			this.vu = true;
			break;
		case "non":
			this.vu = false;
			break;
		default:
			this.vu = false;
			break;
		}
	}
	
	public boolean getVu() {
		return this.vu;
	}
	public void setVu(boolean vu) {
		this.vu = vu;
	}
	public List<Acteur> getActeurs() {
		return acteurs;
	}
	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}
	public Realisateur getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}
	public String getSynopsis() {
		return StringEscapeUtils.unescapeHtml(synopsis);
	}
	public String getEscapedSynopsis() {
		return StringEscapeUtils.unescapeHtml(synopsis).replaceAll("<br>", "\n");
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = StringEscapeUtils.escapeHtml(synopsis.replaceAll("\n", "<br>"));
	}
	public Film() {
		
	}
	public Film(String titre, String annee, Style style, String duree, boolean vu, List<Acteur> acteurs,
			Realisateur realisateur, String synopsis) {
		this.titre = titre;
		this.annee = annee;
		this.style = style;
		this.duree = duree;
		this.vu = vu;
		this.acteurs = acteurs;
		this.realisateur = realisateur;
		this.synopsis = synopsis;
	}
	
}
