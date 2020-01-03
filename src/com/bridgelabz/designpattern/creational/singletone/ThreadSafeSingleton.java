package com.bridgelabz.designpattern.creational.singletone;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:21/12/2019
 * @version 1.0
 * Purpose:To create ThreadSafe design pattern it contains private object and constructor objcet will be accessed 
 * 			by public method getInstance.
 *
 **********************************************************************************************************/

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton(){}
    /** Method to get instance of ThreadSafeSingleton which is synchronized*/
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
    /** Method to get instance of ThreadSafeSingleton class which is synchronized*/

    public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
    
    public static void main(String[] args) 
    {
		
	}
    
}
