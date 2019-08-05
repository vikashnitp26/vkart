package com.vkart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.vkart.model.Address;
import com.vkart.model.Deal;
import com.vkart.model.Product;
import com.vkart.model.User;

@Controller
public class MainController {
	@Value("${ip}")
	private String ip;
	@Autowired
    private RestTemplate restTemplate;
	@RequestMapping(value = {"/" , "/home"})  
	public String goToHome(){
		return "Landing";
	}
	@RequestMapping("/login")
	public String loginToAccount(Model model) {
		model.addAttribute("user", new User());
		return "Login";
	}
	@RequestMapping(value="/deals" ,method = RequestMethod.GET)
	public String displayDeals (HttpServletRequest request, ModelMap model) {
		Gson gson = new Gson();
		String json;
			Deal[] deal;
			try{
				final String uri = ip+"deals";
				//res= restTemplate.getForEntity(uri, Product[].class);
				deal= restTemplate.getForObject(uri, Deal[].class);			
			}
			catch(NullPointerException e){return null;}
			//List<Product> list=Arrays.asList(res.getBody());
			json = gson.toJson(deal);
		
		System.out.println(json);
//		//model.addAttribute("lists", list);
		model.addAttribute("lists", json);
		return "Deals";
		
	}
	@RequestMapping(value = "/sudologin", method = RequestMethod.GET)
	public String loginToAdmin(Model model,@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		//		model.addAttribute("user", new User());
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "AdminLogin";
	}

	@RequestMapping("/About")
	public String goToAbout() {

		return "About";
	}

	@RequestMapping(value="/admin**", method = RequestMethod.GET)
	public String goToAdmin(Model model) {
		model.addAttribute("product", new Product());
		return "AdminHome";
	}
	@RequestMapping("/Contact")
	public String goToContact() {
		return "Contact";
	}
	
	@RequestMapping("/ErrorPage")
	public String showError() {
		return "ErrorPage";
	}
	@RequestMapping("/Footer")
	public String showFooter() {
		return "Footer";
	}
	@RequestMapping("/Header")
	public String showHeader() {
		return "Header";
	}
	@RequestMapping("/Signup")
	public String goToSignup(Model model) {
		model.addAttribute("user", new User());
		return "Signup";
	}
	@RequestMapping("/Welcome")
	public String goToAccount() {
		return "Welcome";
	}
	

}
