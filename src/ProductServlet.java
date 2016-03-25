import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simpleprogrammer.User;

public class ProductServlet  extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (!cookie.getName().equals("user_id")) {
					
						RequestDispatcher rdp = request.getRequestDispatcher("/login.jsp");
						rdp.forward(request, response);
					
					
				}
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/data.jsp");
		ArrayList<User> list=new ArrayList<>();
		User user1= new User();
		user1.setUserid(2);
		user1.setUsername("username");
		user1.setPassword("password");
		User user2= new User();
		user1.setUserid(3);
		user1.setUsername("username2");
		user1.setPassword("password2");

		
		list.add(user1);
		list.add(user2);
		request.setAttribute("list",list);
	    requestDispatcher.forward(request, response);*/
	}
}
