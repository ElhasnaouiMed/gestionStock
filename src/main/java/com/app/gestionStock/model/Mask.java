/**
 * 
 */
package com.app.gestionStock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.ToString;

/**
 * @author mohamed
 *
 */
@Entity
@Table(name = "mask")
@ToString
public class Mask {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "maskId")
	private Integer id;

	@Column(name = "total")
	private Integer total;

	@ManyToOne(optional = false)
	@JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
	private Category category;



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
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

}
