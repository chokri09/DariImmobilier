package tn.dari.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "selling")
public class SellingAnnonce extends Annonce {

	public SellingAnnonce(int id, String title, Payement payement, String adresse, String video, double price,
			float innerSurface, float planeSurface, int roomNumber, float statePrice, Date createdAt,
			String photoIdentity, String engagementLettre, Boolean favoriteAnnonce) {
		super(id, title, payement, adresse, video, price, innerSurface, planeSurface, roomNumber, statePrice, createdAt,
				photoIdentity, engagementLettre, favoriteAnnonce);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
