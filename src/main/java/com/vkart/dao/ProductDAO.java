package com.vkart.dao;

import java.util.List;

import com.vkart.model.Product;

public interface ProductDAO {
	
	public void addProduct(Product newProduct);
	public Product getProduct(String p_id);
	public Product getProductByName(String pName);
	public void removeProduct(String p_id);
	public List<Product> getProductByCategory(String cat);
	public List<Product> getAllProducts();

}
