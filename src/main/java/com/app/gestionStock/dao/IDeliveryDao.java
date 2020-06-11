/**
 * 
 */
package com.app.gestionStock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.gestionStock.model.Delivery;

/**
 * @author mohamed
 *
 */
@Repository
public interface IDeliveryDao extends JpaRepository<Delivery, Integer> {

	// public List<Delivery> findByDateBefore(LocalDate date);

	@Query("SELECT lo " + "FROM Delivery lo " + "INNER JOIN lo.pk.collaborater c "
			+ "WHERE UPPER(c.registeredNumber) = UPPER(?1) ")
	public List<Delivery> getAllDeliveryOfThisCollaborater(String registeredNumber);

	@Query("SELECT lo " + "FROM Delivery lo " + "INNER JOIN lo.pk.mask b " + "INNER JOIN lo.pk.collaborater c "
			+ "WHERE b.id =  ?1 " + "   AND c.id = ?2 ")
	public Delivery getDeliveryByCriteria(Integer maskId, Integer collaboraterId);

	@Query("SELECT c.registeredNumber, c.lastName, c.firstName, c.birthDate, c.creationDate, c.email"
			+ ",cat.code, "
			+ "lo.quantity, lo.gel FROM Delivery lo "
			+ "INNER JOIN lo.pk.collaborater c "
			+ "INNER JOIN lo.pk.mask b "
			+ "INNER JOIN b.category cat  ")
	public List<Object[]> getAllDelivery();

}
