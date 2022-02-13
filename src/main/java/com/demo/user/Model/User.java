package com.demo.user.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUser ;
	private String lastName ; 
	private String firstName ; 
	private String email ; 
	private String numTel ;
	
	
	public User() {
		
	}
	
	
	public User(int idUser, String lastName, String firstName, String email, String numTel) {
		this.idUser = idUser;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.numTel = numTel;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNumTel() {
		return numTel;
	}


	public void setNumTel(String numTel) {
		this.numTel = numTel;
	} 
	
	
	
	
	
	

}