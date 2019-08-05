package com.vkart.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.vkart.dao.CartDAO;
import com.vkart.dao.ProductDAO;
import com.vkart.details.*;
import com.vkart.model.CartItem;
import com.vkart.model.Product;
import com.vkart.model.User;

@Controller
public class ProductController {
	
	@Value("${ip}")
	private String ip;
	@Autowired
	private ProductDAO pdao;
	
	@Autowired
	private CartDAO cdao;
	
	@Autowired
    private RestTemplate restTemplate;

	/**
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/Products" ,method = RequestMethod.GET)
	public String displayProducts (HttpServletRequest request, ModelMap model) {
		
		String cat = request.getParameter("val");
		Gson gson = new Gson();
		String json;
		
		if(cat!=null)
		{
			List<Product> list;
			System.out.println("category = "+cat);
			model.addAttribute("catname",cat);
			if((cat.toLowerCase()).equals("all"))
				list=pdao.getAllProducts();
			else
				list = pdao.getProductByCategory(cat);
			json = gson.toJson(list);
		}
		
		else
		{
			String q = request.getParameter("q");
			Product[] product;
			try{
				final String uri = ip+"searchproduct/"+q;
				//res= restTemplate.getForEntity(uri, Product[].class);
				product= restTemplate.getForObject(uri, Product[].class);
			
			}
			catch(NullPointerException e){return null;}
			//List<Product> list=Arrays.asList(res.getBody());
			json = gson.toJson(product);
		}
		System.out.println(json);
//		//model.addAttribute("lists", list);
		model.addAttribute("lists", json);
		return "Products";
		
	}
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public  @ResponseBody String noticeProductRequest(HttpSession session,Model model) {
		
		System.out.println("Product Controller hit");
		User x= (User) session.getAttribute("UserBean");
		  
		CartDetails cart;
		try{
			final String uri = ip+x.getUserId()+"/cart";
			
			 cart = restTemplate.getForObject(uri, CartDetails.class);
		}
		catch(NullPointerException e){return null;}
//		Product p1 = new Product("P-ILCA-99M2","cam", "Sony DSLR","α99 II provides a back-illuminated 42.4MP 35 mm full-frame CMOS image sensor, Hybrid Phase Detection AF system, up to 12fps high-speed continuous shooting, 5-axis optical image stabilisation and advanced 4K movie recording.", 4250,true);
//		User x= (User) session.getAttribute("UserBean");
//		CartItem citem = new CartItem(2,p1.getProductName(),p1.getPrice(),x.getUserId());
		Gson gson = new Gson();
		String json=null;
		if(cart!=null)
		{
			session.setAttribute("cartDetails",cart.cartDetails);
			json = gson.toJson(cart.cartDetails);
		}
		System.out.println(json);
	    return json;

	}
	
	@RequestMapping(value="/productDetail" ,method = RequestMethod.GET)
	public String getDetails(HttpServletRequest request, ModelMap model) {
		
		String id = request.getParameter("fetchid");
		Gson gson = new Gson();
		String json = gson.toJson(pdao.getProduct(id));
		model.addAttribute("product_item", json);
		return "Details";
	}
	
	@RequestMapping(value="/addToCart", method=RequestMethod.GET)
	public @ResponseBody String addProductHandler( HttpSession session, @RequestParam("pro") String p,Model model) {
		
		System.out.println("Cart Insertion Initiated");
		Gson gson = new Gson();
		Product x =gson.fromJson(p, Product.class);
		User y= (User) session.getAttribute("UserBean");
		CartItem citem = new CartItem(1,x.getProductID(),y.getUserId());
		System.out.println("#########"+citem);
		cdao.addProduct(citem);
//		cdao.addProduct(citem);
		System.out.println("Product Insertion Successful!!!");
		return ("You have successfully ADDED 1 new product!"); 

	}
	
	@RequestMapping(value="/removeItem", method=RequestMethod.GET)
	public @ResponseBody String removeProductHandler( @RequestParam("proID") int p_id,Model model) {
		
		System.out.println("Product Deletion Initiated");
		cdao.removeCartItem(p_id);
		System.out.println("Product Deletion Successful!!!");
		return ("You have successfully DELETED 1 old product!");
	 

	}

}
