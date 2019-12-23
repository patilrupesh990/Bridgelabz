package com.bridgelabz.oops.addressbook;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

abstract class AddressBookReadWrite 
{
	@SuppressWarnings("unused")
	public  JSONObject readFile2(String filePath)
	{
		JSONObject mainArrayObject = new JSONObject();
		try(FileReader fileReader = new FileReader(filePath))
		{
			if(fileReader==null)
			{
				return null;
			}
			else{
			JSONParser parser = new JSONParser();
			mainArrayObject = (JSONObject) parser.parse(fileReader);
			
			fileReader.close();
			return mainArrayObject;
			}
		}
		catch(Exception e)
		{
		}
		return null;
	}	
	
	/*********************************************************************************
	 * To Write in file
	 * 
	 * --> LinkedList to add stocks
	 * 
	 *  @param String filename
	 *  @return String
	 *******************************************************************************/	
	
	public  void writeToFile(String filePath, JSONObject mainObject)
	{
		try(FileWriter fileWriter = new FileWriter(filePath))
		{
			fileWriter.write(mainObject.toJSONString());
			fileWriter.flush();
			fileWriter.close();
		} 
		catch (Exception e) 
		{
		}
	}

}
