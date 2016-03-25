import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.simpleprogrammer.User;

/*@WebServlet(name="DataServlet", urlPatterns = {"/data"})*/
public class DataServlet extends HttpServlet implements Servlet {
	User user = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * RequestDispatcher
		 * requestDispatcher=getServletContext().getRequestDispatcher(
		 * "/data.jsp"); ArrayList<User> list=new ArrayList<>(); User user1= new
		 * User(); user1.setUserid(2); user1.setUsername("username");
		 * user1.setPassword("password"); User user2= new User();
		 * user2.setUserid(3); user2.setUsername("username2");
		 * user2.setPassword("password2"); list.add(user1); list.add(user2);
		 * request.setAttribute("list",list); requestDispatcher.forward(request,
		 * response);
		 */
		int user_id=-1;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user_id")&&cookie.getValue()!=null) {
					
						//RequestDispatcher rdp = request.getRequestDispatcher("/login.jsp");
						//rdp.forward(request, response);
						user_id=Integer.parseInt(cookie.getValue());
					
				}
			}

		}
		Session session=null;
		
		if(user_id==1){
			try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			ServiceRegistryBuilder ssrb = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.buildServiceRegistry());
			session = sessionFactory.openSession();
			if (session.isConnected()) {
				user = (User) session.load(User.class,user_id );
			} else {
				System.out.println("Connection failed");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		RequestDispatcher rdp = request.getRequestDispatcher("/data.jsp");
		String hql = "FROM Product";
		Query query = session.createQuery(hql);
		List list = query.list();
        request.setAttribute("list",list);
		rdp.forward(request, response);
		}else if(user_id!=-1){
		
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			ServiceRegistryBuilder ssrb = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.buildServiceRegistry());
			session = sessionFactory.openSession();
			if (session.isConnected()) {
				user = (User) session.load(User.class,user_id );
			} else {
				System.out.println("Connection failed");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		RequestDispatcher rdp = request.getRequestDispatcher("/data.jsp");
		
		String hql = "FROM Product WHERE userid=:user_id";
		Query query = session.createQuery(hql);
		query.setParameter("user_id",user_id);
		List list = query.list();
        request.setAttribute("list",list);
		rdp.forward(request, response);
		}else{
			RequestDispatcher rdp = request.getRequestDispatcher("/login.jsp");
			rdp.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}
}
