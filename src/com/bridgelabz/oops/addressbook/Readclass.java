package com.bridgelabz.oops.addressbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;


public class Readclass {
	
	
	public void readFromJSON()
	{
		
		String jsonData = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader("/Users/<username>/Documents/Crunchify_JSON.txt"));
			while ((line = br.readLine()) != null) {
				jsonData += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		// System.out.println("File Content: \n" + jsonData);
		JSONObject obj;
		try {
			obj = new JSONObject(jsonData);
			
		
		
		System.out.println("twitter: " + obj.getString("twitter"));
		System.out.println("social: " + obj.getJSONObject("social"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	

}
