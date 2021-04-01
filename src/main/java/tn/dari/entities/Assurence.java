package tn.dari.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Assurence implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private int id;
private String title;
private String description;
private String contact;
private String email;
@OneToOne(mappedBy="assur")
private Annonce an;

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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Assurence(int id, String title, String description, String contact, String email) {
	super();
	this.id = id;
	this.title = title;
	this.description = description;
	this.contact = contact;
	this.email = email;
}
@Override
public String toString() {
	return "assurence [id=" + id + ", title=" + title + ", description=" + description + ", contact=" + contact
			+ ", email=" + email + "]";
}



	
	
}
