/**
 * 
 */
package com.app.gestionStock.dto;

import java.time.LocalDate;




/**
 * @author mohamed
 *
 */
public class CollaboraterDTO implements Comparable<CollaboraterDTO>{


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the registeredNumber
	 */
	public String getRegisteredNumber() {
		return registeredNumber;
	}

	/**
	 * @param registeredNumber the registeredNumber to set
	 */
	public void setRegisteredNumber(String registeredNumber) {
		this.registeredNumber = registeredNumber;
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
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	private Integer id;

	private String registeredNumber;

	private String lastName;

	private String firstName;

	private LocalDate birthDate;

	private String email;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(CollaboraterDTO o) {
		return registeredNumber.compareToIgnoreCase(o.registeredNumber);
	}
}
