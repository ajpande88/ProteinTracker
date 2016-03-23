
/**
 *
 * @author Java2db.com
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
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
		if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			RequestDispatcher rdp = request.getRequestDispatcher("/success.jsp");
			response.addCookie(usernamecookie);
			rdp.forward(request, response);
		} else {
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
		}
	}
}