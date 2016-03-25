
/**
 *
 * @author Java2db.com
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.simpleprogrammer.User;

/**
 * Author Java2db.com
 */
public class loginServlet extends HttpServlet {

	String id = "";
	String Userpassword = "";
	Connection connection = null;
	Statement querySmt = null;
	ResultSet result = null;
	User user = null;
	Object obj[] = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String user_id=request.getParameter("user_id").trim();
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
      Cookie usernamecookie =new Cookie("username",request.getParameter("username"));
      Cookie login=null;

		Session session = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			ServiceRegistryBuilder ssrb = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.buildServiceRegistry());
			session = sessionFactory.openSession();
			if (session.isConnected()) {
				user = (User) session.load(User.class,Integer.parseInt(user_id) );
			} else {
				System.out.println("Connection failed");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if (username.equals("admin") && password.equals("admin")) {
			RequestDispatcher rdp = request.getRequestDispatcher("/home.jsp");
			String hql = "FROM Product";
			
			login=new Cookie("user_id",new String(user_id));
			Query query = session.createQuery(hql);
			List list = query.list();
			
			response.addCookie(usernamecookie);
            request.setAttribute("list",list);
			response.addCookie(login);

			rdp.forward(request, response);
		
		}	else if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			RequestDispatcher rdp = request.getRequestDispatcher("/home.jsp");
			//user =session.load(User.class,Integer.parseInt(user_id) );
		
			String hql = "FROM Product WHERE userid=:user_id";
			Query query = session.createQuery(hql);
			query.setParameter("user_id",Integer.parseInt(user_id));
			List list = query.list();
			response.addCookie(usernamecookie);
			user.setIsLoggedIn(true);
			login=new Cookie("user_id",new String(user_id));

			/*ArrayList<User> list=new ArrayList<>();
			User user1= new User();
			user1.setUserid(2);
			user1.setUsername("username");
			user1.setPassword("password");
			User user2= new User();
			user2.setUserid(3);
			user2.setUsername("username2");
			user2.setPassword("password2");
			list.add(user1);
			list.add(user2);*/
			request.setAttribute("list",list);
			response.addCookie(login);

			
			
			
			rdp.forward(request, response);
		} else {
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
		}
	}
}