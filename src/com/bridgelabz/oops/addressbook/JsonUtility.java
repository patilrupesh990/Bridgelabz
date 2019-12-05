package com.bridgelabz.oops.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


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
			
			// TODO: handle exception
			System.out.println("Exceptionoccured while converting java object to JSON object");
		}
		catch (JsonMappingException e) {
			// TODO: handle exception
			System.out.println("Exceptionoccured while converting java object to JSON object");
		}
		catch (IOException e) {
			// TODO: handle exception
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
		catch (JsonParseException e) {
			System.out.println("Exceptionoccured while converting JSON object to java object");
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
			// TODO Auto-generated catch block
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
            out.write(String.valueOf(string)); 
            out.newLine();
            out.close(); 
        }catch (FileNotFoundException e) {
			// TODO: handle exception
        	System.out.println("File Does Not Exist");
		}
		catch (IOException e) {
			
		} 
		
	}
	
	
		
	
}
