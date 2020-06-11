/**
 * 
 */
package com.app.gestionStock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionStock.dao.ICategoryDao;
import com.app.gestionStock.model.Category;

/**
 * @author mohamed
 *
 */
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryDao categoryDao;

	@Override
	public Category saveCategory(Category entity) {
		return categoryDao.save(entity);
	}

	@Override
	public Category updateCategory(Category entity) {
		return categoryDao.save(entity);

	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.findAll();
	}

	@Override
	public Category findCategoryByCode(String code) {
		return categoryDao.findByCodeIgnoreCase(code);
	}

	
}
