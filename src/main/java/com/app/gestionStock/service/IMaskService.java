/**
 * 
 */
package com.app.gestionStock.service;

import java.util.List;
import java.util.Optional;

import com.app.gestionStock.model.Mask;

/**
 * @author mohamed
 *
 */
public interface IMaskService {
	public Mask saveMask(Mask entity);
	public Mask updateMask(Mask entity);
	public List<Mask> getAll();
	public Optional<Mask> findMaskById(Integer id);
	public List<Mask> getAllWithCategory();
	public Mask  findMaskByCode(String code);
}
