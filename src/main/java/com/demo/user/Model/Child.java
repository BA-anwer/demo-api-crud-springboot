package com.demo.user.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Child")
public class Child {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idChild ;
	private String firstName ;
	private String lastName;
	private int age;
	private Date dateNais ; 
	 @ManyToOne
	 @JoinColumn(name = "idUser", referencedColumnName = "idUser ")
	@JsonIgnore
     private User parent;
	/**
	 * @param idChild
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param dateNais
	 * @param parent
	 */
	 public Child() {}
	public Child( String firstName, String lastName, int age, Date dateNais, User parent) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dateNais = dateNais;
		this.parent = parent;
	}
	/**
	 * @return the idChild
	 */
	public int getIdChild() {
		return idChild;
	}
	/**
	 * @param idChild the idChild to set
	 */
	public void setIdChild(int idChild) {
		this.idChild = idChild;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the dateNais
	 */
	public Date getDateNais() {
		return dateNais;
	}
	/**
	 * @param dateNais the dateNais to set
	 */
	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}
	/**
	 * @return the parent
	 */
	public User getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(User parent) {
		this.parent = parent;
	}
	
	
	
	
}
