package com.bridgelabz.designpattern.behavioral.oberservs;

/***********************************************************************************************************
 * @author Rupeshp007
 * date:24/12/2019
 * @version 1.0
 * Purpose: Interface Subject to Contains Abstract methods
 **********************************************************************************************************/

public interface Subject {

	 void register(Observer obj);
	 void unregister(Observer obj);
	
	 void notifyObservers();
	
	 Object getUpdate(Observer obj);
	
}
