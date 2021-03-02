package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name = "TypeAnnoce",
		discriminatorType = DiscriminatorType.STRING
		)
public abstract class annonce implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title ;
	
	@Column(name="payement")
	private Payement payement;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="video")
	private String video;
	
	@Column(name="price")
	private double price ;
	
	@Column(name="innerSurface")
	private float innerSurface;
	
	@Column(name="planeSurface")
	private float planeSurface;
	
	@Column(name="roomNumber")
	private int roomNumber;
	
	@Column(name="statePrice")
	private float statePrice ;
	private Date CreatedAt;
	
	@Column(name="photoIdentity")
	private String photoIdentity ;
	
	@Column(name="engagementLettre")
    private String engagementLettre ;
	
	
	@Column(name="favoriteAnnonce")
    private Boolean favoriteAnnonce ;

	
	@OneToOne
	private assurence assur;

	public annonce(int id, String title, Payement payement, String adresse, String video, double price,
			float innerSurface, float planeSurface, int roomNumber, float statePrice, Date createdAt,
			String photoIdentity, String engagementLettre, Boolean favoriteAnnonce) {
		super();
		this.id = id;
		this.title = title;
		this.payement = payement;
		this.adresse = adresse;
		this.video = video;
		this.price = price;
		this.innerSurface = innerSurface;
		this.planeSurface = planeSurface;
		this.roomNumber = roomNumber;
		this.statePrice = statePrice;
		CreatedAt = createdAt;
		this.photoIdentity = photoIdentity;
		this.engagementLettre = engagementLettre;
		this.favoriteAnnonce = favoriteAnnonce;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Payement getPayement() {
		return payement;
	}


	public void setPayement(Payement payement) {
		this.payement = payement;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getVideo() {
		return video;
	}


	public void setVideo(String video) {
		this.video = video;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public float getInnerSurface() {
		return innerSurface;
	}


	public void setInnerSurface(float innerSurface) {
		this.innerSurface = innerSurface;
	}


	public float getPlaneSurface() {
		return planeSurface;
	}


	public void setPlaneSurface(float planeSurface) {
		this.planeSurface = planeSurface;
	}


	public int getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}


	public float getStatePrice() {
		return statePrice;
	}


	public void setStatePrice(float statePrice) {
		this.statePrice = statePrice;
	}


	public Date getCreatedAt() {
		return CreatedAt;
	}


	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}


	public String getPhotoIdentity() {
		return photoIdentity;
	}


	public void setPhotoIdentity(String photoIdentity) {
		this.photoIdentity = photoIdentity;
	}


	public String getEngagementLettre() {
		return engagementLettre;
	}


	public void setEngagementLettre(String engagementLettre) {
		this.engagementLettre = engagementLettre;
	}


	public Boolean getFavoriteAnnonce() {
		return favoriteAnnonce;
	}


	public void setFavoriteAnnonce(Boolean favoriteAnnonce) {
		this.favoriteAnnonce = favoriteAnnonce;
	}


	@Override
	public String toString() {
		return "annonce [id=" + id + ", title=" + title + ", payement=" + payement + ", adresse=" + adresse + ", video="
				+ video + ", price=" + price + ", innerSurface=" + innerSurface + ", planeSurface=" + planeSurface
				+ ", roomNumber=" + roomNumber + ", statePrice=" + statePrice + ", CreatedAt=" + CreatedAt
				+ ", photoIdentity=" + photoIdentity + ", engagementLettre=" + engagementLettre + ", favoriteAnnonce="
				+ favoriteAnnonce + "]";
	}
	

}
