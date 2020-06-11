package com.app.gestionStock.dto;

import java.time.LocalDateTime;


public class DeliveryDTO {
	
	/**
	 * @return the collaborater
	 */
	public CollaboraterDTO getCollaborater() {
		return collaborater;
	}

	/**
	 * @param collaborater the collaborater to set
	 */
	public void setCollaborater(CollaboraterDTO collaborater) {
		this.collaborater = collaborater;
	}

	/**
	 * @return the mask
	 */
	public MaskDTO getMask() {
		return mask;
	}

	/**
	 * @param mask the mask to set
	 */
	public void setMask(MaskDTO mask) {
		this.mask = mask;
	}

	/**
	 * @return the creationDateTime
	 */
	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	/**
	 * @param creationDateTime the creationDateTime to set
	 */
	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	private CollaboraterDTO collaborater=new CollaboraterDTO();
	
    private MaskDTO mask=new MaskDTO();

    private LocalDateTime creationDateTime;
}
