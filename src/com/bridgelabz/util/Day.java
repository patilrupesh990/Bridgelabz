package com.bridgelabz.util;


	public class Day {
	    //Instance Variables
	    DayOfWeek day;

	    //Constructors
	    public Day(DayOfWeek day) {
	        this.day = day;
	    }//End of one-arg constructor.

	    public Day(int dayNumber) {
	        //Instantiate the variable, then change the value to specified value.
	        this.day = DayOfWeek.SUNDAY;
	        this.day.setDayNumber(dayNumber);
	    }//End of one-arg constructor.

	    //Getters and Setters
	    public DayOfWeek getDay() {
	        return this.day;
	    }

	    //Utility Methods
	    public int compareTo(Day day) {
	        //Returns 1 if it comes later in the week.
	        if(this.day.getDayNumber() > day.getDay().getDayNumber()) {
	            return 1;
	        //Returns -1 if it comes earlier in the week.
	        } else if(this.day.getDayNumber() < day.getDay().getDayNumber()) {
	            return -1;
	        //Returns 0 if they are the same day.
	        } else {
	            return 0;
	        }
	    }//End of compareTo method.

	    public String nextDay() {
	        return this.day.next().toString();
	    }//End of nextDay method.

	    public String toString() {
	        return this.day.toString();
	    }

	}
