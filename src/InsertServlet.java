

import java.io.IOException;
import java.util.Date;
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

import com.simpleprogrammer.Product;

/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (!cookie.getName().equals("user_id")) {
					
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					
					
				}
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String product_id=request.getParameter("product_id");
		   String product_name=request.getParameter("product_name").trim();
			String product_desc = request.getParameter("product_desc").trim();
			String product_quantity = request.getParameter("product_quantity").trim();
			String product_price = request.getParameter("product_price").trim();
			Session session = null;
			try {
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				ServiceRegistryBuilder ssrb = new ServiceRegistryBuilder()
						.applySettings(configuration.getProperties());
				SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.buildServiceRegistry());
				session = sessionFactory.openSession();
				if (session.isConnected()) {
					RequestDispatcher rdp = request.getRequestDispatcher("/data.jsp");
					//user =session.load(User.class,Integer.parseInt(user_id) );
					session.beginTransaction();
					Product product=new Product();
					product.setProductId(Integer.parseInt(product_id));
					product.setName(product_name);
					product.setDescription(product_desc);
					product.setQuantity(Integer.parseInt(product_quantity));
					product.setPrice(Integer.parseInt(product_price));
					
					product.setDate(new Date());
					product.setUserid(22);
					session.save(product);
					session.getTransaction().commit();
					
					//List list = query.list();
					String hql = "FROM Product WHERE userid=22";
					Query query = session.createQuery(hql);
					List list = query.list();
					request.setAttribute("list",list);
					
					session.close();
					rdp.forward(request, response);
				} else {
					System.out.println("Connection failed");
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			
			
	}

}
