package com.vkart.dao;

import java.util.List;

import com.vkart.model.CartItem;


public interface CartDAO {
	public void removeProduct(int p_id);
	public List<CartItem> getCartItems(int id);
	public void addProduct(CartItem newItem);
	public void removeCartItem(int p_id);
}
