/**
 * 
 */
package com.app.gestionStock.service;

import java.util.List;

import com.app.gestionStock.model.Category;

/**
 * @author mohamed
 *
 */
public interface ICategoryService {

	public Category saveCategory(Category entity) ;
	public Category updateCategory(Category entity);
	public List<Category> getAllCategories();
	public Category findCategoryByCode(String code);

}
