package com.bridgelabz.designpattern.behavioral.oberservs;

import java.util.ArrayList;
import java.util.List;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:24/12/2019
 * @version 1.0
 * Purpose: To check whether the user is register or not if register will add to ArrayList.
 * 
 **********************************************************************************************************/
public class MyTopic implements Subject {

	private List<Observer> observers;
	private String message;
	private boolean changed;
	private final Object MUTEX= new Object();
	
	/**
	 * MyTopic Constructor
	 **/

	public MyTopic(){
		this.observers=new ArrayList<>();
	}
	
	/**
	 * override method of Subject Interface to add new object
	 * @param Observer obj
	 * */

	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
		if(!observers.contains(obj)) 
			observers.add(obj);
		}
	}
	/**
	 * override method of Subject Interface to remove unregister object
	 * @param Observer obj
	 * */
	@Override
	public void unregister(Observer obj) {
		synchronized (MUTEX) {
		observers.remove(obj);
		}
	}
	/**
	 * override method of Subject Interface Notify messages to register objects
	 * @param Observer obj
	 **/
	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed=false;
		}
		for (Observer obj : observersLocal) {
			obj.update();
		}

	}
	/**
	 * override method of Subject Interface to to get object
	 * @param Observer obj
	 * */
	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	/**
	 * To Post message
	 * @param Observer obj
	 * */
	public void postMessage(String msg){
		System.out.println("Message Posted to Topic:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}

}