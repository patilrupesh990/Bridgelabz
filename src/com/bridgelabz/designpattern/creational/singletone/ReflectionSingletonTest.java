package com.bridgelabz.designpattern.creational.singletone;

import java.lang.reflect.Constructor;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:23/12/2019
 * @version 1.0
 * Purpose:To ReflactionSingleTone design pattern it contains reflection  Api to generate singleton object
 *
 **********************************************************************************************************/

public class ReflectionSingletonTest {

    public static void main(String[] args) {
    	Charger instanceOne = Charger.getInstance();
    	Charger instanceTwo = null;
        try {
            Constructor[] constructors = Charger.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (Charger) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

}
