package com.bridgelabz.util;

public enum DayOfWeek {
    //Days of week and values associated with them.
    SUNDAY(1) {
        public DayOfWeek next() { return MONDAY; }
    },MONDAY(2) {
        public DayOfWeek next() { return TUESDAY; }
    }, TUESDAY(3) {
        public DayOfWeek next() { return WEDNESDAY; }
    }, WEDNESDAY(4) {
        public DayOfWeek next() { return THURSDAY; }
    }, THURSDAY(5) {
        public DayOfWeek next() { return FRIDAY; }
    }, FRIDAY(6) {
        public DayOfWeek next() { return SATURDAY; }
    }, SATURDAY(7) {
        public DayOfWeek next() { return SUNDAY; }
    };
	
	//Instance Variables
    //Associate a number with the day of the week.
    private int dayNumber;

    //Constructors
    DayOfWeek(int dayNumber) {
        this.dayNumber = dayNumber;
    }//End of one-arg constructor.

    //Getters and Setters
    public int getDayNumber() {
        return this.dayNumber;
    }
    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    //Abstract method to implement in the enum values.
    public abstract DayOfWeek next();

    //Utility Methods
    public String toString() {
        switch(this.dayNumber) {
        case 1:
            return "Sunday";
        case 2:
            return "Monday";
        case 3:
            return "Tuesday";
        case 4:
            return "Wednesday";
        case 5:
            return "Thursday";
        case 6:
            return "Friday";
        default:
            return "Saturday";
        }
    }//End of toString method.
}//End of enum type.

