/**
 * 
 */
package com.app.gestionStock.dto;

/**
 * @author mohamed
 *
 */
public class SimpleDeliveryDTO implements Comparable<SimpleDeliveryDTO>{

	private Integer collaboraterId;

	private Integer maskId;

	private Integer quantite;

	private String category;

	private boolean gel;
	
	

	@Override
	public int compareTo(SimpleDeliveryDTO o) {
		return maskId.compareTo(o.maskId) ;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the collaboraterId
	 */
	public Integer getCollaboraterId() {
		return collaboraterId;
	}

	/**
	 * @return the maskId
	 */
	public Integer getMaskId() {
		return maskId;
	}

	/**
	 * @return the quantite
	 */
	public Integer getQuantite() {
		return quantite;
	}

	/**
	 * @return the gel
	 */
	public boolean isGel() {
		return gel;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	
	/**
	 * @param collaboraterId the collaboraterId to set
	 */
	public void setCollaboraterId(Integer collaboraterId) {
		this.collaboraterId = collaboraterId;
	}
	
	/**
	 * @param gel the gel to set
	 */
	public void setGel(boolean gel) {
		this.gel = gel;
	}
	
	/**
	 * @param maskId the maskId to set
	 */
	public void setMaskId(Integer maskId) {
		this.maskId = maskId;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
}
