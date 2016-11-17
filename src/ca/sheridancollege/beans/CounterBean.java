package ca.sheridancollege.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class CounterBean
 */
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
