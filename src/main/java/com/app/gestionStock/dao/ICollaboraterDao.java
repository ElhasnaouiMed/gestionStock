/**
 * 
 */
package com.app.gestionStock.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.gestionStock.model.Collaborater;

/**
 * @author mohamed
 *
 */
@Repository
public interface ICollaboraterDao extends JpaRepository<Collaborater, Integer> {
	

    public Collaborater findByRegisteredNumberIgnoreCase(String registeredNumber);
    
    public Collaborater findByBirthDate(LocalDate birthDate);

    public List<Collaborater> findByLastNameLikeIgnoreCase(String lastName);
    
      
}