package com.bridgelabz.oops.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import com.jn.langx.classpath.scanner.core.Scanner;



public class JsonUtility 
{
	private static ObjectMapper mapper;
	static
	{
		mapper=new ObjectMapper();	
		
	}
	
	public static String ConverJavaToJson(Object object)
	{
		String jsonResult="";
		try
		{
			jsonResult=mapper.writeValueAsString(object);
		}
		catch (JsonGenerationException e) {
			
			System.out.println("Exceptionoccured while converting java object to JSON object");
		}
		catch (JsonMappingException e) {
			System.out.println("Exceptionoccured while converting java object to JSON object");
		}
		catch (IOException e) {
			System.out.println("Exceptionoccured while converting java object to JSON object");
		}
		return jsonResult;
	}
	
	

	
	
	public static <T>T converJsonToJava(String jsonstring,Class<T> cls)
	{
		String result=null;
		try {
			result=(String) mapper.readValue(jsonstring, cls);
		} 
		
		catch (JsonMappingException e) {
			System.out.println("Exceptionoccured while converting JSON object to java object");
		}
		catch (IOException e) {
			System.out.println("Exceptionoccured while converting JSON object to java object");
		}
		return (T) result;
		
	}
	
	
	
	
	public static String readFile(String fileName) throws FileNotFoundException {
		File file;
		file=new File(fileName);
		FileReader filereader=null;
		BufferedReader b_reader;
		String line="";
		
		
			try 
			{
				filereader = new FileReader(file);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			b_reader=new BufferedReader(filereader);
			String temp="";
		
			
		try
		{
			while((temp=b_reader.readLine())!=null)
			{
				line+=temp;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			b_reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
	
	public static <T>void WriteinFile(T string,String filename)
	{
		try { 
			  
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter(filename, true)); 
           
            out.append(String.valueOf(string));
           out.write(String.valueOf(string)); 
            out.newLine();
            out.close(); 
        }catch (FileNotFoundException e) {
        	System.out.println("File Does Not Exist");
		}
		catch (IOException e) {
			
		} 
		
	}

	
	public static void clearFile(String fileName){
	    //go through and do this every time in order to delete previous crap
		
		FileWriter fwOb=null;
		try {
			fwOb = new FileWriter(fileName, false);
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        try {
			fwOb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	public static JSONObject readFile2(String filePath)
	{
		JSONObject mainArrayObject = new JSONObject();
		try(FileReader fileReader = new FileReader(filePath))
		{
			JSONParser parser = new JSONParser();
			mainArrayObject = (JSONObject) parser.parse(fileReader);
			fileReader.close();
			return mainArrayObject;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}	
	
	
	public static void writeToFile(String filePath, JSONObject mainObject)
	{
		try(FileWriter fileWriter = new FileWriter(filePath))
		{
			fileWriter.write(mainObject.toJSONString());
			fileWriter.flush();
			fileWriter.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
