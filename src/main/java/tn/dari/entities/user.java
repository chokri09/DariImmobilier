package tn.dari.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="T_User")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id ;
	private String picture ; 
	private String firstName;
	private String lastName;
	private String email;
	private String  username;
	private String  password;
	private boolean isActif;
	private String telephone ;
	@Enumerated(value =EnumType.STRING )
	private Gender gender;
	private String adresse;
	
	@Enumerated(value =EnumType.STRING )
	private Role role;
	
	
	//one to many unidirectionnel 
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Reclamation> rec;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Annonce> ann;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Appointment> app;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Commentaire> comntr;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<AnnonceMeuble> annMeuble;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Forum> forr;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Assurence> assur;
	
	public Set<AnnonceMeuble> getAnnMeuble() {
		return annMeuble;
	}

	public void setAnnMeuble(Set<AnnonceMeuble> annMeuble) {
		this.annMeuble = annMeuble;
	}

	public Set<Assurence> getAssur() {
		return assur;
	}

	public void setAssur(Set<Assurence> assur) {
		this.assur = assur;
	}

	public Set<Notification> getNotif() {
		return notif;
	}

	public void setNotif(Set<Notification> notif) {
		this.notif = notif;
	}

	@OneToOne
	private Subscription subs;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Notification> notif ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", picture=" + picture + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", username=" + username + ", password=" + password + ", isActif=" + isActif
				+ ", telephone=" + telephone + ", gender=" + gender + ", adresse=" + adresse + ", role=" + role
				+ ", rec=" + rec + ", ann=" + ann + ", app=" + app + ", comntr=" + comntr + ", forr=" + forr + ", subs="
				+ subs + "]";
	}

	public User(int id, String picture, String firstName, String lastName, String email, String username,
			String password, boolean isActif, String telephone, Gender gender, String adresse, Role role,
			Set<Reclamation> rec, Set<Annonce> ann, Set<Appointment> app, Set<Commentaire> comntr, Set<Forum> forr,
			Subscription subs) {
		super();
		this.id = id;
		this.picture = picture;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.isActif = isActif;
		this.telephone = telephone;
		this.gender = gender;
		this.adresse = adresse;
		this.role = role;
		this.rec = rec;
		this.ann = ann;
		this.app = app;
		this.comntr = comntr;
		this.forr = forr;
		this.subs = subs;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Reclamation> getRec() {
		return rec;
	}

	public void setRec(Set<Reclamation> rec) {
		this.rec = rec;
	}

	public Set<Annonce> getAnn() {
		return ann;
	}

	public void setAnn(Set<Annonce> ann) {
		this.ann = ann;
	}

	public Set<Appointment> getApp() {
		return app;
	}

	public void setApp(Set<Appointment> app) {
		this.app = app;
	}

	public Set<Commentaire> getComntr() {
		return comntr;
	}

	public void setComntr(Set<Commentaire> comntr) {
		this.comntr = comntr;
	}

	public Set<Forum> getForr() {
		return forr;
	}

	public void setForr(Set<Forum> forr) {
		this.forr = forr;
	}

	public Subscription getSubs() {
		return subs;
	}

	public void setSubs(Subscription subs) {
		this.subs = subs;
	}
	
	
	
	
	
	
	
	

}
