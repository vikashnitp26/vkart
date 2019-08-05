package com.vkart.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkart.dao.CardDAO;
import com.vkart.model.Card;
import com.vkart.model.CartItem;

public class CardDAOImpl implements CardDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public CardDAOImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory=sessionFactory;
	}
	public Card getCard(int userId)
	{
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria criteria = s.createCriteria(Card.class);
				
		 List<Card> card = criteria.add(Restrictions.eq("userId", userId)).list();		
		tx.commit();
		s.close();
		System.out.println("Items Fetched");
		if(card.size()>0)
			card.get(0);
		return null;
	}
}
