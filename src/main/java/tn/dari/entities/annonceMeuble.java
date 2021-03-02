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
@Table(name="T_AnnoceMeuble")
public class AnnonceMeuble implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id ;
   private float price;
   private String photo;
   private String description;
   private String State ;
   private String categorie;
   
   @Temporal(TemporalType.DATE)
   private Date date ;
   public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getState() {
	return State;
}
public void setState(String state) {
	State = state;
}
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public AnnonceMeuble(int id, float price, String photo, String description, String state, String categorie, Date date) {
	super();
	this.id = id;
	this.price = price;
	this.photo = photo;
	this.description = description;
	State = state;
	this.categorie = categorie;
	this.date = date;
}
@Override
public String toString() {
	return "annonceMeuble [id=" + id + ", price=" + price + ", photo=" + photo + ", description=" + description
			+ ", State=" + State + ", categorie=" + categorie + ", date=" + date + "]";
}
   
   
   

}
