package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="T_Reclamation")
public class Reclamation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String sujet;
	private String descr;
	@Enumerated(value =EnumType.STRING) 
	private Typerec type;
	private int idUserConn;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private String reponse;
	private Boolean isTreated ;
	
	public Reclamation() {
		
	}
	public Reclamation(String sujet, String descr, Typerec type, int idUserConn, Date dateCreation, String reponse) {
		super();
		this.sujet = sujet;
		this.descr = descr;
		this.type = type;
		this.idUserConn = idUserConn;
		this.dateCreation = dateCreation;
		this.reponse = reponse;
	}
	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", sujet=" + sujet + ", descr=" + descr + ", type=" + type + ", idUserConn="
				+ idUserConn + ", dateCreation=" + dateCreation + ", reponse=" + reponse + ", isTreated=" + isTreated
				+ "]";
	}
	
	public Reclamation(int id, String sujet, String descr, Typerec type, int idUserConn, Date dateCreation,
			String reponse, Boolean isTreated) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.descr = descr;
		this.type = type;
		this.idUserConn = idUserConn;
		this.dateCreation = dateCreation;
		this.reponse = reponse;
		this.isTreated = isTreated;
	}
	public Boolean getIsTreated() {
		return isTreated;
	}
	public void setIsTreated(Boolean isTreated) {
		this.isTreated = isTreated;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Typerec getType() {
		return type;
	}
	public void setType(Typerec type) {
		this.type = type;
	}
	public int getIdUserConn() {
		return idUserConn;
	}
	public void setIdUserConn(int idUserConn) {
		this.idUserConn = idUserConn;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	

	
	

}
