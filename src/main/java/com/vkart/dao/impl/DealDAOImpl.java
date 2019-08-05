package com.vkart.dao.impl;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkart.dao.DealDAO;
import com.vkart.model.CartItem;
import com.vkart.model.Deal;
import com.vkart.model.Product;
public class DealDAOImpl implements DealDAO{

	@Autowired
	private SessionFactory sessionFactory;
	public List<Deal> list = new ArrayList<Deal>();

	
	public DealDAOImpl() {
		
	}

	public DealDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Deal getDealByCategory(String cat) {
		// TODO Auto-generated method stub
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		
		Criteria criteria = s.createCriteria(Product.class);
		Deal deal= (Deal) criteria.add(Restrictions.eq("category", cat)).uniqueResult();
		tx.commit();
		s.close();
		System.out.println("Product fetched by id");	
		if(deal!=null) {return deal;}
		return null;
	}

	public List<Deal> getAllDeal() {
		// TODO Auto-generated method stub
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria criteria = s.createCriteria(Deal.class);
		List<Deal> list;
		list = criteria.list();
		tx.commit();
		s.close();
		System.out.println("Products Fetched");
		return list;
	}
	public void addDeal(Deal newDeal) {
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
//		s.save(newProduct);
		s.saveOrUpdate(newDeal);
		tx.commit();
		s.close();
		System.out.println("Deal inserted");	

	}
	public void removeDeal(int d_id) {
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Deal deal ;
		deal = (Deal)s.load(Deal.class,d_id);
		s.delete(deal);
		tx.commit();
		s.close();
		System.out.println("Deal Deleted");
		
	}



}
