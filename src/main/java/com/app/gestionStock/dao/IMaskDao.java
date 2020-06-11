/**
 * 
 */
package com.app.gestionStock.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.gestionStock.model.Mask;

/**
 * @author mohamed
 *
 */
@Repository
public interface IMaskDao extends JpaRepository<Mask, Integer> {

	public Optional<Mask> findById(Integer id);

	@Query("SELECT b FROM Mask b INNER JOIN b.category cat WHERE cat.code=:code")
	public Mask findByCodeCategory(@Param("code") String codeCategory);

	@Query("SELECT b FROM Mask b INNER JOIN b.category cat")
	public List<Mask> getAllWithCategory();
}
