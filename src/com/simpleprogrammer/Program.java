package com.simpleprogrammer;

import org.hibernate.Session;

public class Program {
	public static void main(String[] args) {
		System.out.println("Hello World");
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		User user=new User();
		user.setName("Joe");
		user.setGoal(250);
		session.save(user);
		session.getTransaction().commit();
		session.beginTransaction();
		User loadUser=(User) session.get(User.class,1);
		System.out.println(loadUser.getName());
		System.out.println(loadUser.getGoal());
		session.getTransaction().commit();
		session.close();
         HibernateUtilities.getSessionFactory().close();
	}
}
