package com.vkart.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vkart.dao.CardDAO;

import com.vkart.model.Card;
import com.vkart.model.User;
@Controller
public class CardController {
	@Autowired
	private CardDAO cDao;
	@RequestMapping(value="/Card")
    public String gotopayment( HttpSession session,Model model )
    {
		System.out.println("Card Controller hit");
		User x= (User) session.getAttribute("UserBean");
		if(x==null)
        	return "Login";
		int userId=x.getUserId();
		Card card=new Card();
		if(cDao.getCard(userId)!=null)
			card=cDao.getCard(userId);
		model.addAttribute("card", card);
		return "Card";
    }
    
}
