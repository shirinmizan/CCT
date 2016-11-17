package ca.sheridancollege.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Calculator
 */
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
