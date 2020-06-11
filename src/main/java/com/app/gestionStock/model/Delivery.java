/**
 * 
 */
package com.app.gestionStock.model;


import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.ToString;


/**
 * @author mohamed
 *
 */
@Entity
@Table(name = "delivery")
@AssociationOverrides({
		@AssociationOverride(name = "pk.collaborater", joinColumns = @JoinColumn(name = "collaboraterId")),
		@AssociationOverride(name = "pk.mask", joinColumns = @JoinColumn(name = "maskId")) })
@ToString
public class Delivery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2321956222467048824L;
	
	@EmbeddedId
	private DeliveryId pk = new DeliveryId();

	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "gel")
	private boolean gel;


	/**
	 * @param date the date to set
	 */
	//public void setDate(LocalDate date) {
		//this.date = date;
	//}

	/*-@Column(name = "date")
	private LocalDate date;*/
	
	/**
	 * @return the pk
	 */
	public DeliveryId getPk() {
		return pk;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @return the gel
	 */
	public boolean isGel() {
		return gel;
	}
	
	/**
	 * @return the date
	 */
	//public LocalDate getDate() {
		//return date;
//	}

	/**
	 * @param gel the gel to set
	 */
	public void setGel(boolean gel) {
		this.gel = gel;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(DeliveryId pk) {
		this.pk = pk;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
