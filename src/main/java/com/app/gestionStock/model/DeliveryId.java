/**
 * 
 */
package com.app.gestionStock.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * @author mohamed
 *
 */
@Embeddable
public class DeliveryId implements Serializable{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6871583438550235712L;

	@ManyToOne
	private Collaborater collaborater;

	@ManyToOne
    private Mask mask;

	@Column(name = "creationDateTime")
    private LocalDateTime creationDateTime=LocalDateTime.now();

	/**
	 * 
	 */
	public DeliveryId() {
		super();
	}



	/**
	 * @param collaborater
	 * @param mask
	 * @param creationDateTime
	 */
	public DeliveryId(Collaborater collaborater, Mask mask) {
		super();
		this.collaborater = collaborater;
		this.mask = mask;
	}

	/**
	 * @return the collaborater
	 */
	public Collaborater getCollaborater() {
		return collaborater;
	}

	/**
	 * @return the creationDateTime
	 */
	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	/**
	 * @return the mask
	 */
	public Mask getMask() {
		return mask;
	}

	/**
	 * @param collaborater the collaborater to set
	 */
	public void setCollaborater(Collaborater collaborater) {
		this.collaborater = collaborater;
	}
	
    /**
	 * @param creationDateTime the creationDateTime to set
	 */
	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

    /**
	 * @param mask the mask to set
	 */
	public void setMask(Mask mask) {
		this.mask = mask;
	}

}
