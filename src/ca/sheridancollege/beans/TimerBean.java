package ca.sheridancollege.beans;

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