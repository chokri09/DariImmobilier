package tn.dari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_Notification")
public class Notification implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private Date dateNotif;
	
	private String descrp;
	
	private String title;
	
	@ManyToMany(mappedBy="notif",cascade=CascadeType.ALL)
	private Set<User> usr;
	
	@Override
	public String toString() {
		return "notification [id=" + id + ", dateNotif=" + dateNotif + ", descrp=" + descrp + ", title=" + title + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateNotif() {
		return dateNotif;
	}
	public void setDateNotif(Date dateNotif) {
		this.dateNotif = dateNotif;
	}
	public String getDesc() {
		return descrp;
	}
	public void setDesc(String desc) {
		this.descrp = desc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Notification(int id, Date dateNotif, String desc, String title) {
		super();
		this.id = id;
		this.dateNotif = dateNotif;
		this.descrp = descrp;
		this.title = title;
	}
	public Notification( Date dateNotif, String desc, String title) {
		super();
		
		this.dateNotif = dateNotif;
		this.descrp = descrp;
		this.title = title;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}