/**
 * 
 */
package com.app.gestionStock.service;

import java.util.List;

import com.app.gestionStock.model.Delivery;

/**
 * @author mohamed
 *
 */
public interface IDeliveryService {
	public Delivery saveDelivery(Delivery entity);
	public Delivery updateDelivery(Delivery entity);
	public List<Delivery> getAll();
	public  List<Object[]> getAllDelivery();

}
