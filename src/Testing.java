

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Testing
 */

public class Testing extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
    //	request.getRequestDispatcher("jsp1.jsp").forward(request, response);
    //	MessageBo message=new MessageBo("Today is Monday");
    //	RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/jsp1.jsp");
    //	request.setAttribute("message",message);
    //	requestDispatcher.forward(request, response);
    
   
    RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/jsp1.jsp");
  /*  request.setAttribute("list",list);*/
    requestDispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("username");  
	    String p=request.getParameter("userpass");  
	          
	    if(validate(n, p)){  
		//	response.getWriter().append("Welcome ").append(a);
            out.println("Welcom "+n);
	    }  
	    else{  
	        out.print("Bad Login");  
	        
	    }  
	          
	    out.close();  
	    }

	private boolean validate(String n, String p) {
		// TODO Auto-generated method stub
		return n.equals("ajay")&&p.equals("ajay");
	}  
}
