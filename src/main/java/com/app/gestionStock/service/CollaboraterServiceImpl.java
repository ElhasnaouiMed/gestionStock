/**
 * 
 */
package com.app.gestionStock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionStock.dao.ICollaboraterDao;
import com.app.gestionStock.model.Collaborater;

/**
 * @author mohamed
 *
 */
@Service("collaboraterService")
@Transactional
public class CollaboraterServiceImpl implements ICollaboraterService {

	@Autowired
	ICollaboraterDao collaboraterDao;
	
	
	@Override
	public Collaborater saveCollaborater(Collaborater entity) {
		return collaboraterDao.save(entity);
	}

	@Override
	public Collaborater updateCollaborater(Collaborater entity) {
		return collaboraterDao.save(entity);
	}

	@Override
	public List<Collaborater> getAll() {
		return collaboraterDao.findAll();
	}

	@Override
	public boolean checkIfIdexists(Integer id) {
		return collaboraterDao.existsById(id);
	}

	@Override
	public Collaborater findCollaboraterByRegisteredNumber(String registredNumber) {
		return collaboraterDao.findByRegisteredNumberIgnoreCase(registredNumber);
	}

	@Override
	public List<Collaborater> findCollaboraterByLastName(String lastName) {
		return collaboraterDao.findByLastNameLikeIgnoreCase(lastName);
	}

	@Override
	public Optional<Collaborater> findCollaboraterById(Integer collaboraterId) {
		return collaboraterDao.findById(collaboraterId);
	}



}
