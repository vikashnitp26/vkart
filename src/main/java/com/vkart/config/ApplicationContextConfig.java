package com.vkart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import com.vkart.dao.UserDAO;
import com.vkart.dao.impl.AddressDAOImpl;
import com.vkart.dao.impl.CardDAOImpl;
import com.vkart.dao.impl.CartDAOImpl;
import com.vkart.dao.impl.DealDAOImpl;
import com.vkart.dao.impl.OrderDAOImpl;
import com.vkart.dao.impl.ProductDAOImpl;
import com.vkart.dao.impl.UserDAOImpl;
import com.vkart.model.Address;
import com.vkart.dao.*;


@Configuration
@ComponentScan("com.vkart")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		try {
			  Class.forName("org.h2.Driver");
			  //on classpath
			} catch(ClassNotFoundException e) {
			  // not on classpath
			}
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		System.out.println("## getDataSource: " + dataSource);
		return dataSource;
	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
		Properties properties = new Properties();

		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");           
		properties.put("hibernate.hbm2ddl.auto","update");

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		// Package contain entity classes
		factoryBean.setPackagesToScan(new String[] { "com.vkart.model" });
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();
		//
		SessionFactory sf = factoryBean.getObject();
		System.out.println("## getSessionFactory: " + sf);
		return sf;    
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		System.out.println("## getTransactionManager: " + txManager);
		return txManager;
	}
	
	@Autowired
	@Bean(name = "userDao")
	public UserDAO getUserDao(SessionFactory sessionFactory) {
	    return new UserDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "productBean")
	public ProductDAO getProductDao(SessionFactory sessionFactory) {
	    return new ProductDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "cartBean")
	public CartDAO getCartDao(SessionFactory sessionFactory) {
	    return new CartDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "dealBean")
	public DealDAO getDealDao(SessionFactory sessionFactory) {
	    return new DealDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "addressBean")
	public AddressDAO getAddressDao(SessionFactory sessionFactory) {
	    return new AddressDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "orderBean")
	public OrderDAO getOrderDao(SessionFactory sessionFactory) {
	    return new OrderDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "cardBean")
	public CardDAO getCardDao(SessionFactory sessionFactory) {
	    return new CardDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "restTemplateBean")
	public RestTemplate getRestTemplate() {
	    return new RestTemplate();
	}
	@Autowired
	@Bean(name = "address")
	public Address getAddress() {
	    return new Address();
	}

}
