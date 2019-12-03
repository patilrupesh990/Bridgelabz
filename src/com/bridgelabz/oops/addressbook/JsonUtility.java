package com.bridgelabz.oops.addressbook;

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
		T result=null;
		try {
			result=mapper.readValue(jsonstring, cls);
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
		return result;
		
	}
}
