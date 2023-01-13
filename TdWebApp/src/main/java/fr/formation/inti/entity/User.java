package fr.formation.inti.entity;
// Generated 9 janv. 2023 � 16:25:15 by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Id;

import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;



@Entity
public class User implements java.io.Serializable {

	/**
	 * User generated by hbm2java
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String email;
	private String password;
	private String firstname ;
	private String lastname;
	private LocalDateTime datecrea;
	

	public User() {
	}
	
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	
	public User(String email, String password, String firstname, String lastname) {
		this.email = email;
		this.password = password;
		this.firstname=firstname;
		this.lastname=lastname;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		//System.out.println(formatter.format(date));
		this.datecrea= now;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idUser", unique = true, nullable = false)
	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "emailadress", length = 45)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "firstname")
	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
	
	
	@Column(name = "datecrea", nullable = false)
	public LocalDateTime getDatecrea() {
		return datecrea;
	}


	public void setDatecrea(LocalDateTime datecrea) {
		this.datecrea = datecrea;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", datecrea=" + datecrea + "]";
	}
	
	

	

}