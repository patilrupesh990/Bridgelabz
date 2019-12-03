package com.bridgelabz.logicalprograms;

import com.bridgelabz.util.Utility;

/**
* Author: RupeshPatil
* Date: 18/11/2019
*	Purpose:to measure the time that elapses between the start and end clicks
*	I/P -> Start the Stopwatch and End the Stopwatch
*	O/P -> Print the elapsed time.
***********************************************************************************/

public class StopWatch
{
	private long duration = 0;
    private long start = 0;
	public static void main(String[] args) throws InterruptedException
	{
		
		 StopWatch stopwatch=new StopWatch(); 
		System.out.println("press 1 for start");
		int i=Utility.InputInt();
		if(i==1)
		{
		 stopwatch.start();
		}
		System.out.println("press 2 for start");
		int j=Utility.InputInt();
		if(j==2)
		{
		stopwatch.stop();
		}
		System.out.println("Total Time elapse: " + stopwatch.getMilliseconds()+"in Mlilisecond" );
		System.out.println("Total Time elapse: " + stopwatch.getSeconds()+" in second" );
		System.out.println("Total Time elapse: " + (stopwatch.getSeconds())/60+" in Minute" );
		System.out.println("Total Time elapse: " + ((stopwatch.getSeconds())/60)/60+" in Hour" );
	}
	
		
	    
	    /**
	     * When this flag is true, the stopwatch is still going (stop() hasn't been called since the last start() call),
	     * and the duration doesn't update until it's stopped, so the time returned needs account for the actively counting time.
	     */
	    private boolean active = false;

	    /**
	     * Starts the stopwatch.
	     */
	    public void start() {
	        this.start = System.currentTimeMillis();
	        this.active = true;
	    }
	    
	    /**
	     * Stops the stopwatch.
	     */
	    public void stop() {
	        if (this.active) 
	        	this.duration += (System.currentTimeMillis() - this.start);
	        this.active = false;
	    }

	    
	    /**
	     * Returns the duration of the stopwatch as a long, in milliseconds.
	     * The duration starts when the stopwatch is first started using start() and is finished when the stopwatch is lastly stopped using stop(),
	     * or when this method is called if the stopwatch was not stopped since most recently started.
	     * 
	     * @return the duration of the stopwatch, in milliseconds, since it was started until it was stopped (or until this method is called if it was not stopped)
	     */
	    public long getMilliseconds() {
	        if (this.active)
	        	return this.duration + System.currentTimeMillis() - this.start;
	        else
	        	return this.duration;
	    }
	    
	    /**
	     * Returns the duration of the stopwatch as a double, in seconds.
	     * The duration starts when the stopwatch is first started using start() and is finished when the stopwatch is lastly stopped using stop(),
	     * or when this method is called if the stopwatch was not stopped since most recently started.
	     * 
	     * @return the duration of the stopwatch, in seconds, since it was started until it was stopped (or until this method is called if it was not stopped)
	     */
	    public double getSeconds() {
	        if (this.active) 
	        	return (this.duration + System.currentTimeMillis() - this.start) / 1000d;
	        else
	        	return this.duration / 1000d;
	    }
	   

}
