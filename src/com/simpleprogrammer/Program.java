package com.simpleprogrammer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

public class Program {
	public static void main(String[] args) {
	/*	System.out.println("Hello World");
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		Set<Product> productlist = new HashSet<Product>();
		User user = new User();
		user.setUsername("user@gmail.com");
		user.setPassword("pass");
		user.setUserid(22);
		Product product1 = new Product("product1", new Date(), "Description", 1, 12);
		Product product2 = new Product("product2", new Date(), "Description", 1, 12);
		// product1.setProductId(21);
		// product2.setProductId(21);
		productlist.add(product1);
		productlist.add(product2);

		// user.setUserid(21);
		user.getStockDailyRecords().add(product1);
		user.getStockDailyRecords().add(product2);
		session.flush();
		session.save(product1);
		session.save(product2);
		session.save(user);
      
		session.getTransaction().commit();
		session.beginTransaction();
		User loadUser = (User) session.get(User.class, 21);
		System.out.println(loadUser.getStockDailyRecords());
		System.out.println(loadUser.getUsername());
		System.out.println(loadUser.getPassword());
		session.getTransaction().commit();
		session.close();
		HibernateUtilities.getSessionFactory().close();*/
	}
}
