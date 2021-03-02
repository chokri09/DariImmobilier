package tn.dari.entities;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="T_Reclamation")
public class reclamation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private String sujet;
	private String descr;
	@Enumerated(value =EnumType.STRING) 
	private Typerec type;
	public reclamation(int id, String sujet, String descr, Typerec type) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.descr = descr;
		this.type = type;
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
	public String getDesc() {
		return descr;
	}
	public void setDesc(String desc) {
		this.descr = descr;
	}
	public Typerec getType() {
		return type;
	}
	public void setType(Typerec type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "reclamation [id=" + id + ", sujet=" + sujet + ", descr=" + descr + ", type=" + type + "]";
	}
	
	

}
