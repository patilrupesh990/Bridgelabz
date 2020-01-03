package com.bridgelabz.designpattern.creational.singletone;

import java.io.Serializable;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:23/12/2019
 * @version 1.0
 * Purpose:To create SerializedSingleton design pattern it implements Serializable interface and serialVersionId.
 **********************************************************************************************************/

public class SerializedSingleton implements Serializable{

    private static final long serialVersionUID = -7604766932017737115L;
	/**Private Constructor of SerializedSingleton  Class to restrict object creation */
    private SerializedSingleton(){}
    /** private static SingletoneHelper inner classit returns object of SerializedSingleton*/
    private static class SingletonHelper{
        private static final SerializedSingleton instance = new SerializedSingleton();
    }
	/**Public static method to access object of SerializedSingleton **/

    public static SerializedSingleton getInstance(){
        return SingletonHelper.instance;
    }
    
   
}
