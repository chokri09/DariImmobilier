package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;
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
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private int nbrSignals;
	
	public int getNbrSignals() {
		return nbrSignals;
	}
	public void setNbrSignals(int nbrSignals) {
		this.nbrSignals = nbrSignals;
	}

	@Column(name="account_non_locked")
	private boolean accountNonLocked;
	
	@Column(name="failed_attempt")
	private int failedAttempt;
	
	@Column(name="lock_time")
	private Date lockTime;
	
	public User(int id, String picture, String firstName, String lastName, String email, String username,
			String password, boolean isActif, String telephone, Gender gender, String adresse, Role role, int nbrSignals) {
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
		this.nbrSignals = nbrSignals;
	}
	
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
	
	@OneToOne
	private Subscription subs;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Notification> notif ;
	
	public User() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public int getFailedAttempt() {
		return failedAttempt;
	}
	public void setFailedAttempt(int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}
	public Date getLockTime() {
		return lockTime;
	}
	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", picture=" + picture + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", username=" + username + ", password=" + password + ", isActif=" + isActif
				+ ", telephone=" + telephone + ", gender=" + gender + ", adresse=" + adresse + ", role=" + role
				+ ", nbrSignals=" + nbrSignals + ", accountNonLocked=" + accountNonLocked + ", failedAttempt="
				+ failedAttempt + ", lockTime=" + lockTime + "]";
	}
	
	
	
	
	

}
