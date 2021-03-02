package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_Appointement")
public class Appointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private int idRec;
	private int idSend;
	@Temporal(TemporalType.DATE)
	private Date dateRendezVous ;
	private boolean valid ;
	public Appointment(int id, int idRec, int idSend, Date dateRendezVous, boolean valid) {
		super();
		this.id = id;
		this.idRec = idRec;
		this.idSend = idSend;
		this.dateRendezVous = dateRendezVous;
		this.valid = valid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdRec() {
		return idRec;
	}
	public void setIdRec(int idRec) {
		this.idRec = idRec;
	}
	public int getIdSend() {
		return idSend;
	}
	public void setIdSend(int idSend) {
		this.idSend = idSend;
	}
	public Date getDateRendezVous() {
		return dateRendezVous;
	}
	public void setDateRendezVous(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "appointment [id=" + id + ", idRec=" + idRec + ", idSend=" + idSend + ", dateRendezVous="
				+ dateRendezVous + ", valid=" + valid + "]";
	}
	
	
	
	
	

}
