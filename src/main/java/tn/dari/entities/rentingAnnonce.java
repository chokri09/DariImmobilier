package tn.dari.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "renting")
public class rentingAnnonce extends annonce {
	

	private Date dateDebut ;
	private Date dateFin;
	private int nbrPersonne ;
	private boolean  rented ;

	
	public rentingAnnonce(int id, String title, Payement payement, String adresse, String video, double price,
			float innerSurface, float planeSurface, int roomNumber, float statePrice, Date createdAt,
			String photoIdentity, String engagementLettre, Boolean favoriteAnnonce) {
		super(id, title, payement, adresse, video, price, innerSurface, planeSurface, roomNumber, statePrice, createdAt,
				photoIdentity, engagementLettre, favoriteAnnonce);
		// TODO Auto-generated constructor stub
	}



	

	@Override
	public String toString() {
		return "rentingAnnonce [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", nbrPersonne=" + nbrPersonne
				+ ", rented=" + rented + "]";
	}





	public Date getDateDebut() {
		return dateDebut;
	}





	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}





	public Date getDateFin() {
		return dateFin;
	}





	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}





	public int getNbrPersonne() {
		return nbrPersonne;
	}





	public void setNbrPersonne(int nbrPersonne) {
		this.nbrPersonne = nbrPersonne;
	}





	public boolean isRented() {
		return rented;
	}





	public void setRented(boolean rented) {
		this.rented = rented;
	}





	public rentingAnnonce(int id, String title, Payement payement, String adresse, String video, double price,
			float innerSurface, float planeSurface, int roomNumber, float statePrice, Date createdAt,
			String photoIdentity, String engagementLettre, Boolean favoriteAnnonce, Date dateDebut, Date dateFin,
			int nbrPersonne, boolean rented) {
		super(id, title, payement, adresse, video, price, innerSurface, planeSurface, roomNumber, statePrice, createdAt,
				photoIdentity, engagementLettre, favoriteAnnonce);
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbrPersonne = nbrPersonne;
		this.rented = rented;
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
