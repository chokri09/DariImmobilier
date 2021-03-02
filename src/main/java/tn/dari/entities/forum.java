package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class forum implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")	
private int id ;
private String sujet ;
private String description;
@Temporal(TemporalType.DATE)
private Date date;
private String photo;
public forum(int id, String sujet, String description, Date date, String photo) {
	super();
	this.id = id;
	this.sujet = sujet;
	this.description = description;
	this.date = date;
	this.photo = photo;
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
@Override
public String toString() {
	return "forum [id=" + id + ", sujet=" + sujet + ", description=" + description + ", date=" + date + ", photo="
			+ photo + "]";
}


}
