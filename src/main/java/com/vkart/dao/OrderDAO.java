package com.vkart.dao;

import java.util.List;

import com.vkart.model.Order;

public interface OrderDAO {
	
	public List<Order> getAllOrder();
	public void addOrder(Order newOrder);
	public void removeOrder(int p_id);
	
}
