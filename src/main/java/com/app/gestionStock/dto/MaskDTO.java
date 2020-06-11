/**
 * 
 */
package com.app.gestionStock.dto;



import com.app.gestionStock.model.Category;

/**
 * @author mohamed
 *
 */
public class MaskDTO implements Comparable<MaskDTO> {

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

	private Integer id;

	private Integer total;

	private Category category;

	@Override
	public int compareTo(MaskDTO o) {
	return id.compareTo(o.id);
	}
}
