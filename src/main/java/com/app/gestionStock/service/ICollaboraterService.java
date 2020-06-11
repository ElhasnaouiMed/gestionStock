/**
 * 
 */
package com.app.gestionStock.service;

import java.util.List;
import java.util.Optional;

import com.app.gestionStock.model.Collaborater;

/**
 * @author mohamed
 *
 */
public interface ICollaboraterService {
	
	public Collaborater saveCollaborater(Collaborater entity);
	
	public Collaborater updateCollaborater(Collaborater entity);
	
	public List<Collaborater> getAll();
	
	public boolean checkIfIdexists(Integer id);

	public Collaborater findCollaboraterByRegisteredNumber(String registredNumber);
	
	public List<Collaborater> findCollaboraterByLastName(String lastName);
	
	public Optional<Collaborater> findCollaboraterById(Integer collaboraterId);

}
