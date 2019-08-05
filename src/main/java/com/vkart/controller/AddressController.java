package com.vkart.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vkart.dao.AddressDAO;
import com.vkart.details.CartDetails;
import com.vkart.model.Address;
import com.vkart.model.User;
@Controller
public class AddressController {

	@Autowired
	private AddressDAO aDao;
	@Autowired
	private Address address;
	@RequestMapping("/Address")
	public String goToAddress(HttpSession session,Model model) {
		System.out.println("Address Controller hit");
		User x= (User) session.getAttribute("UserBean");
		if(x==null)
        	return "Login";

		if(aDao.getAddressByUserId(x.getUserId())!=null)	
			address = aDao.getAddressByUserId(x.getUserId());
		//model.addAttribute("address1",address1);
		model.addAttribute("address",address);		
		return "Address";
	}
	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String addAddress( @ModelAttribute("address") @Valid Address address,
      BindingResult result, ModelMap model,HttpSession session) {      
        User x= (User) session.getAttribute("UserBean");
        if(x==null)
        	return "Login";
        if (result.hasErrors()) {
            return "Address1";
        }
        address.setUserId(x.getUserId());       
        aDao.addAddress(address);
        return "Address";
    }
}
