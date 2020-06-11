/**
 * 
 */
package com.app.gestionStock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionStock.dao.IDeliveryDao;
import com.app.gestionStock.model.Delivery;

/**
 * @author mohamed
 *
 */
@Service("deliveryService")
@Transactional
public class DeliveryServiceImpl implements IDeliveryService {

	@Autowired
	IDeliveryDao deliveryDao;
	
	@Override
	public Delivery saveDelivery(Delivery entity) {
		return deliveryDao.save(entity);
	}

	@Override
	public Delivery updateDelivery(Delivery entity) {
		return deliveryDao.save(entity);
	}

	@Override
	public List<Delivery> getAll() {
		return deliveryDao.findAll();
	}

	
	@Override
	public  List<Object[]> getAllDelivery() {
		return deliveryDao.getAllDelivery();
	}

}
