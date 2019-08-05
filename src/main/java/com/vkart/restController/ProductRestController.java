package com.vkart.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vkart.dao.ProductDAO;
import com.vkart.model.Product;

@RestController
public class ProductRestController {

	@Autowired
    private ProductDAO productDao;
	 @GetMapping(path="/searchproduct", produces = "application/json")
	public List<Product> getAllProduct() 
    {
        return productDao.getAllProducts();
    }
    @GetMapping(path="/searchproduct/{pid}", produces = "application/json")
    public Product getProduct(@PathVariable("pid") String pid) 
    {
        return productDao.getProduct(pid);
    }
    @GetMapping(path="/{pname}/details", produces = "application/json")
    public String getProductDetails(@PathVariable("pname") String pname) 
    {
        return productDao.getProductByName(pname).getProductDesc();
    }
    
}
