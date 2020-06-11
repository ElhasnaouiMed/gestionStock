/**
 * 
 */
package com.app.gestionStock.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



/**
 * @author mohamed
 *
 */
public class DeliveryCollaboraterDTO implements Comparable<DeliveryCollaboraterDTO>{


	private Integer id;


	@NotNull
	@NotBlank
	private String registeredNumber;

	
	private String lastName;

	private String firstName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	@Email
	@NotNull
	@NotBlank
	private String email;

	
	@NotNull
	private Integer quantite;

	private String category;

	private boolean gel;

	private LocalDateTime creationDateTime=LocalDateTime.now();

	@Override
	public int compareTo(DeliveryCollaboraterDTO o) {
		return registeredNumber.compareToIgnoreCase(o.registeredNumber);
	}

	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the creationDateTime
	 */
	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

    /**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the quantite
	 */
	public Integer getQuantite() {
		return quantite;
	}

	/**
	 * @return the registeredNumber
	 */
	public String getRegisteredNumber() {
		return registeredNumber;
	}

	/**
	 * @return the gel
	 */
	public boolean isGel() {
		return gel;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @param creationDateTime the creationDateTime to set
	 */
	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @param gel the gel to set
	 */
	public void setGel(boolean gel) {
		this.gel = gel;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
    /**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	/**
	 * @param registeredNumber the registeredNumber to set
	 */
	public void setRegisteredNumber(String registeredNumber) {
		this.registeredNumber = registeredNumber;
	}

	@Override
	public String toString() {
		return "DeliveryCollaboraterDTO [id=" + id + ", registeredNumber=" + registeredNumber + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", birthDate=" + birthDate + ", email=" + email + ", quantite="
				+ quantite + ", category=" + category + ", gel=" + gel + ", creationDateTime=" + creationDateTime + "]";
	}
}
