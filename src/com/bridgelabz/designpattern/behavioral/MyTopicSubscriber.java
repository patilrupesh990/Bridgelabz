package com.bridgelabz.designpattern.behavioral;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:24/12/2019
 * @version 1.0
 * Purpose:  To give messages to Registered users 
 *  
 **********************************************************************************************************/

public class MyTopicSubscriber implements Observer {
	
	private String name;
	private Subject topic;
	/**
	 * Constructor of {@link MyTopic} class
	 * @param String message
	 * */
	public MyTopicSubscriber(String nm){
		this.name=nm;
	}
	
	/**
	 * override method of Subject Interface to print message
	 **/
	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if(msg == null){
			System.out.println(name+":: No new message");
		}else
		System.out.println(name+":: Consuming message::"+msg);
	}
	
	
	/**
	 * override method of Subject Interface 
	 **/
	@Override
	public void setSubject(Subject sub) {
		this.topic=sub;
	}

}