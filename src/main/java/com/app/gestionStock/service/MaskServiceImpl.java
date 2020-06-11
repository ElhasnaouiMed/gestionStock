package com.app.gestionStock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionStock.dao.IMaskDao;
import com.app.gestionStock.model.Mask;

/**
 * @author mohamed
 *
 */
@Service("maskService")
@Transactional
public class MaskServiceImpl implements IMaskService {
	
	@Autowired
	IMaskDao maskDao;

	@Override
	public Mask saveMask(Mask entity) {
		return maskDao.save(entity);
	}

	@Override
	public Mask updateMask(Mask entity) {
		return maskDao.save(entity);
	}

	@Override
	public List<Mask> getAll() {
		return maskDao.findAll();
	}

	@Override
	public Optional<Mask> findMaskById(Integer maskId) {
		return maskDao.findById(maskId);
	}

	@Override
	public List<Mask> getAllWithCategory() {
		return maskDao.getAllWithCategory();
	}

	@Override
	public Mask findMaskByCode(String code) {
		return maskDao.findByCodeCategory(code);
	}

	
}
