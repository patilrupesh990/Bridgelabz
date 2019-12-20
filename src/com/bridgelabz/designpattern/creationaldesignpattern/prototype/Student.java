package com.bridgelabz.designpattern.creationaldesignpattern.prototype;

import java.util.ArrayList;
import java.util.List;

/***********************************************************************************************************
 * @author Rupesh Patil
 * date:20/12/2019
 * @version 1.0
 * Purpose:Factory design pattern programs implementation
 **********************************************************************************************************/

public class Student implements Cloneable
{
	List<String> studentList;
	
	/****************************
	 * Constructor of Student Class 
	 ********************************/
	
	public Student() {
		studentList=new ArrayList<String>();
	}
	/**
	 * Constructor of Student Class 
	 * @param list<String>
	 **********************************/
	
	public Student(List<String> list)
	{
		this.studentList=list;
	}
	
	/*******************************
	 * returns List of students Name
	 * @param list<String>
	 **********************************/
	
	public List<String> getStudentList()
	{
		return studentList;
	}
	
	/**
	 * Overridden method from clonable interface to return copy of list object
	 * @exception CloneNotSupportedException
	 *************************************************************************/
	@Override
	public Object clone() throws CloneNotSupportedException{
		List<String> temp = new ArrayList<String>();
		for(String s : this.getStudentList()){
			temp.add(s);
		}
		return new Student(temp);
	}
	
	/***********************************
	 * To add data into student list
	 **********************************/

	public void addDataToList()
	{
		studentList.add("Arvind");
		studentList.add("Rahul");
		studentList.add("lalu");
		studentList.add("jagan");
		studentList.add("navin");
		studentList.add("Udhhav");
		studentList.add("sharad");
		studentList.add("rupani");
		studentList.add("Shivraj");
	}
	

}
