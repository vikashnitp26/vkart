package com.vkart.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkart.dao.OrderDAO;
import com.vkart.model.Order;

public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public List<Order> list = new ArrayList<Order>();

	
	public OrderDAOImpl() {
		
	}

	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria criteria = s.createCriteria(Order.class);
		List<Order> list;
		list = criteria.list();
		tx.commit();
		s.close();
		System.out.println("Products Fetched");
		return list;
	}
	public void addOrder(Order newOrder) {
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		System.out.println("Inside OrderDAO"+newOrder);
//		s.save(newProduct);
		s.saveOrUpdate(newOrder);
		tx.commit();
		s.close();
		System.out.println("Order inserted");	

	}
	public void removeOrder(int d_id) {
		Session s=  sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Order Order ;
		Order = (Order)s.load(Order.class,d_id);
		s.delete(Order);
		tx.commit();
		s.close();
		System.out.println("Order Deleted");
		
	}

}
