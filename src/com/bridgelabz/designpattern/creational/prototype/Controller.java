package com.bridgelabz.designpattern.creationaldesignpattern.prototype;

import java.util.List;

/***********************************************************************************************************
 * @author Rupeshp007
 * date:20/12/2019
 * @version 1.0
 * Purpose:Controller for Prototype Design pattern
 **********************************************************************************************************/

public class Controller 
{
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		Student student=new Student();

		student.addDataToList();
		
		Student student1=(Student) student.clone();
		List<String> studentlist1= student1.getStudentList();
		studentlist1.add("Mayavati");
		Student student2=(Student) student.clone();
		List<String> studentlist2=student2.getStudentList();
		studentlist2.remove("Shivraj");
		
		System.out.println(student.getStudentList());
		System.out.println(studentlist1);
		System.out.println(studentlist2);
		
	}
}
