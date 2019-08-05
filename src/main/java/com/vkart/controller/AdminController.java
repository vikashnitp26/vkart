package com.vkart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.vkart.dao.DealDAO;
import com.vkart.dao.ProductDAO;
import com.vkart.model.Deal;
import com.vkart.model.Product;

@Controller
public class AdminController {
	
	@Autowired
	private ProductDAO pDao;
	@Autowired
	private DealDAO dDao;
	
	@RequestMapping(value="/area", method=RequestMethod.GET)
	public  @ResponseBody String noticeProductRequest(Model model) {
		
		System.out.println("Admin Controller hit");
		List<Product> list = pDao.getAllProducts();
		Gson gson = new Gson();
		String json;
		json = gson.toJson(list);
	    return json;

	}
	@RequestMapping(value="/allDeal", method=RequestMethod.GET)
	public  @ResponseBody String noticeDealRequest(Model model) {
		
		System.out.println("Admin Controller hit");
		List<Deal> list = dDao.getAllDeal();
		Gson gson = new Gson();
		String json;
		json = gson.toJson(list);
	    return json;

	}
	
	@RequestMapping(value="/removeProduct", method=RequestMethod.GET)
	public @ResponseBody String removeProductHandler( @RequestParam("proID") String p_id,Model model) {
		
		System.out.println("Product Deletion Initiated");
		pDao.removeProduct(p_id);
		System.out.println("Product Deletion Successful!!!");
		return ("You have successfully DELETED 1 old product!");
	 

	}
	
	@RequestMapping(value="/removeDeal", method=RequestMethod.GET)
	public @ResponseBody String removeDealHandler( @RequestParam("dealId") int dealId,Model model) {
		
		System.out.println("Deal Deletion Initiated");
		dDao.removeDeal(dealId);
		System.out.println("Deal Deletion Successful!!!");
		return ("You have successfully DELETED 1 old Deal!");
	 

	}
	
	@RequestMapping(value="/addingProduct", method=RequestMethod.GET)
	public @ResponseBody String addProductHandler( @RequestParam("pro") String p,Model model) {
		
		System.out.println("Product Insertion Initiated");
		Gson gson = new Gson();
		Product product=(Product)gson.fromJson(p, Product.class);
		if(product.getPrice()>499)
			product.setdCharge(0);
		else
			product.setdCharge(99);
		pDao.addProduct(product);
		System.out.println("Product Insertion Successful!!!");
		return ("You have successfully ADDED 1 new product!"); 

	}
	@RequestMapping(value="/addingDeal", method=RequestMethod.GET)
	public @ResponseBody String addDealHandler( @RequestParam("deal") String p,Model model) {
		
		System.out.println("Deal Insertion Initiated"+p);
		Gson gson = new Gson();
		Deal deal=(Deal)gson.fromJson(p, Deal.class);

		dDao.addDeal(deal);
		System.out.println("Deal Insertion Successful!!!");
		return ("You have successfully ADDED 1 new Deal!"); 

	}
	
	@RequestMapping(value="/updatingProduct", method=RequestMethod.GET)
	public @ResponseBody String updateProductHandler( @RequestParam("pro") String p,Model model) {
		
		System.out.println("Product Updation Initiated");
		Gson gson = new Gson();
		pDao.addProduct(gson.fromJson(p, Product.class));
		System.out.println("Product Updation Successful!!!");
		return ("You have successfully ADDED 1 new product!");
	 

	}
	@RequestMapping(value="/updatingDeal", method=RequestMethod.GET)
	public @ResponseBody String updateDealHandler( @RequestParam("deal") String p,Model model) {
		
		System.out.println("Deal Updation Initiated");
		Gson gson = new Gson();
		dDao.addDeal(gson.fromJson(p, Deal.class));
		System.out.println("Deal Updation Successful!!!");
		return ("You have successfully ADDED 1 new Deal!");
	 

	}

}
