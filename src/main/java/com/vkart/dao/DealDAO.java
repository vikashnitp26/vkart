package com.vkart.dao;

import java.util.List;

import com.vkart.model.Deal;

public interface DealDAO {

	public Deal getDealByCategory(String cat);
	public List<Deal> getAllDeal();
	public void addDeal(Deal newDeal);
	public void removeDeal(int p_id);
}
