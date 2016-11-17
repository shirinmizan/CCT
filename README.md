# CCT
CCT is an Enterprise Java Bean(EJB) project. CCT stands for Calculator, Counter, Timer. 

<h3>Calculator EJB</h3>
-- A stateless bean. A simple calculator adds, subtracts, multiplies, divides, and find the remainders of two numbers. <br>
-- CalcTest servlet will display the result in a webpage.

```Java
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Calculator {
  
  public Calculator() {}
  
  public int add (int x, int y){
    	return (x+y);
    }
  public int subtract(int x, int y){
    	return (x-y);
    }
  public int multiply(int x, int y){
    	return (x*y);
    }
  public int divide(int x, int y){
    	return (x/y);
    }
  public int remainder(int x, int y){
    	return (x%y);
    }
}
```
<h3>Calculator Test Servlet</h3>
```Java
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
```
<h3>Counter EJB</h3>
-- A stateful bean. A simple counter to track website visitor
-- CounterTest servlet will display the result in a webpage.
```Java
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class CounterBean {

	private int counter = 0;
	
    public CounterBean() {}
    
    //current counter value
    public int getCount(){
    	return  counter;
    }
    //increment by 1
    public int increment(){
    	return counter++;
    }
    //reset to zero
    public int reset(){
    	return counter = 0;
    }
}
```
<h3>Counter Test Servlet</h3>
```Java
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ca.sheridancollege.beans.Calculator;
import ca.sheridancollege.beans.CounterBean;

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
```
<h3>Timer EJB</h3>
--Stateless bean. <br>
--Timer EJB prints a message in every 10 seconds.
```Java
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;

@Stateless
public class TimerBean {

    public TimerBean() {}
	
	@SuppressWarnings("unused")
	//this will print a statement in every 10 seconds
	@Schedule(second="*/10", minute="*", hour="*", dayOfWeek="*",   
      dayOfMonth="*", month="*", year="*", info="MyTimer")
    private void scheduledTimeout(final Timer t) {
        System.out.println("@Schedule called at: " + new java.util.Date());
    }
}
```

