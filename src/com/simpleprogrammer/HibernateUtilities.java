package com.simpleprogrammer;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class HibernateUtilities {
     public static SessionFactory sessionFactory;
     public static ServiceRegistry serviceRegistry;
     
     
     static 
     {
    	 try{
    	/*		Configuration configuration = new Configuration().configure(); 
    			 System.err.println("Configuration object is " + configuration);
    			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
    			System.err.println("service registry is " + serviceRegistry);
    			sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
    		System.err.println("session factory is " + sessionFactory);
*/
	
    	 }catch(HibernateException exception){
    		 System.out.println("Problem Creating session factory");
    	 }
     }

   /* public static SessionFactory getSessionFactory(){
    	return sessionFactory;
    }*/

}
