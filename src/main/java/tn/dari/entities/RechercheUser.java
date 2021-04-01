package tn.dari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_RechercheUser")
public class RechercheUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private int idUser;
	private String recherche;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getRecherche() {
		return recherche;
	}
	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}
	public RechercheUser(int id, int idUser, String recherche) {
	
		this.id = id;
		this.idUser = idUser;
		this.recherche = recherche;
	}
	
	public RechercheUser(int idUser, String recherche) {
		
		this.idUser = idUser;
		this.recherche = recherche;
	}
	public RechercheUser() {
		
	}
	@Override
	public String toString() {
		return "RechercheUser [id=" + id + ", idUser=" + idUser + ", recherche=" + recherche + "]";
	}
	
	
	
}
