/**
 * 
 */
package com.app.gestionStock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.gestionStock.model.Category;

/**
 * @author mohamed
 *
 */
@Repository
public interface ICategoryDao extends JpaRepository<Category, Integer> {
    public Category findByCodeIgnoreCase(String code);

}
