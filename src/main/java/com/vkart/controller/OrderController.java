package com.vkart.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vkart.dao.AddressDAO;
import com.vkart.dao.CardDAO;
import com.vkart.dao.CartDAO;
import com.vkart.dao.OrderDAO;
import com.vkart.details.ProductDetails;
import com.vkart.model.*;

@Controller
public class OrderController {
	@Autowired
	private OrderDAO oDao;
	@Autowired
	private AddressDAO aDao;
	@Autowired
	private CardDAO cDao;
	@Autowired
	private CartDAO cartDao;
	@RequestMapping(value="/checkOut")
	public String checkOut(HttpSession session,Model model) {
		System.out.println("Order Controller hit");
		User x= (User) session.getAttribute("UserBean");
		if(x==null)
        	return "Login";
		int userId=x.getUserId();
		int addressId=aDao.getAddressByUserId(userId).getAddressId();
		List<ProductDetails> productDetails=(List<ProductDetails>) session.getAttribute("cartDetails");	
		
		if(productDetails==null)
			return "Welcome";
		System.out.println(productDetails);
		for(int i=0;i<productDetails.size();i++)
		{
			ProductDetails pd=productDetails.get(i);
			Order order=new Order();
			order.setSellerName(pd.sellerName);
			order.setOrderStatus("Ordered");
			order.setQuantity(pd.quantity);
			order.setTotalPrice(pd.total);
			order.setProductId(pd.productId);
			order.setAddressId(addressId);
			order.setUserId(userId);
			Date date=new Date(System.currentTimeMillis());
			order.setOrderedDate(date);
			System.out.println(order);			
			oDao.addOrder(order);
			cartDao.removeCartItem(pd.kartItemId);
		}
		session.setAttribute("msg","You successfully Ordered");
		return "redirect:Welcome";
	}
	@RequestMapping(value="/payment")
	public String payOut(HttpSession session,Model model) {
		System.out.println("Order Controller hit");
		User x= (User) session.getAttribute("UserBean");
		if(x==null)
        	return "Login";
		int userId=x.getUserId();
		if(aDao.getAddressByUserId(userId)==null)
			return "redirect:Address";
		List<ProductDetails> productDetails=(List<ProductDetails>) session.getAttribute("cartDetails");		
		if(productDetails==null)
			return "Welcome";
		System.out.println(productDetails);
		double total=0.0;
		for(int i=0;i<productDetails.size();i++)
		{
			ProductDetails pd=productDetails.get(i);		
			total+=pd.total;
		}
		Card card=new Card();
		if(cDao.getCard(userId)!=null)
			card=cDao.getCard(userId);
		model.addAttribute("card", card);
		session.setAttribute("fromOrder","true");
		model.addAttribute("totalAmount", total);		
		return "Card";
	}



}
