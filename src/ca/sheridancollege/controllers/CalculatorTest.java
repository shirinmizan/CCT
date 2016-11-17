package ca.sheridancollege.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ca.sheridancollege.beans.Calculator;

/**
 * Servlet to test Calculator EJB
 */
@WebServlet("/CalculatorTest")
public class CalculatorTest extends HttpServlet {
	@javax.ejb.EJB //calls the enterprise javabean
	private Calculator calculator; //this calls a calculator object and links calculator variable to Calculator bean
								   
	
	private static final long serialVersionUID = 1L;
       
	public CalculatorTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*making a web page that will call our bean 
		 *and attempt to execute the methods inside of
		 */
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Calculator Bean test</h1>");
		out.println("2 + 5 = " + calculator.add(2, 5) + "<br>");
		out.println("2 - 5 = " + calculator.subtract(2, 5) + "<br>");
		out.println("2 x 5 = " + calculator.multiply(2, 5) + "<br>");
		out.println("2 / 5 = " + calculator.divide(2, 5) + "<br>");
		out.println("2 % 5 = " + calculator.remainder(2,5) + "<br>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
