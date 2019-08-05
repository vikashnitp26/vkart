package com.vkart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vkart.dao.UserDAO;
import com.vkart.model.User;

@Controller
public class RegisterController {

	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute @Valid User user, BindingResult result, Model model) {
		System.out.println("########  "+ user);
		if (result.hasErrors()) {
            return "Signup";
        }
		userDao.saveOrUpdate(user);
		model.addAttribute("Msg", "You have successfully registered! Now let's try logging in :)");
		return "Login";
	} 
}
