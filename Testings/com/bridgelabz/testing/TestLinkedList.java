package com.bridgelabz.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bridgelabz.util.LinkedListiml;

public class TestLinkedList {

	//LinkedListiml<Integer> linklist1=new LinkedListiml<Integer>();
	@Test
	public void insert()
	{
		LinkedListiml<Integer> linklist1=new LinkedListiml<Integer>();
		linklist1.add(10);
		linklist1.add(-10);;
	}
	
	

}
