package ca.sheridancollege.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.beans.Calculator;
import ca.sheridancollege.beans.CounterBean;

/**
 * Servlet implementation class CounterBean EJB
 */
@WebServlet("/CounterTest")
public class CounterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@javax.ejb.EJB //calls the enterprise javabean
	private CounterBean counterbean;
   
    public CounterTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Counter Bean test</h1>");
		counterbean.increment(); //increment each the time page is visited
		out.println("You have visited the page " + counterbean.getCount() +"<br>" ); //get count hw many time
		out.println("</body>");
		out.println("</html>");
		//counterbean.reset();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
