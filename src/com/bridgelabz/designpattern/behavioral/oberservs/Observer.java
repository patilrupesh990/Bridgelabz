package com.bridgelabz.designpattern.behavioral.oberservs;

/***********************************************************************************************************
 * @author Rupeshp007
 * date:24/12/2019
 * @version 1.0
 * Purpose: Observer interface contains with update(),setSubject() methods.
 * 
 **********************************************************************************************************/

public interface Observer {

		public void update();
		
		public void setSubject(Subject sub);
}
