package com.bridgelabz.oops.cliniquemanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.oops.addressbook.AddressBookimplementation;
import com.bridgelabz.util.JsonUtility;
import com.bridgelabz.util.LogicalProgram;
import com.bridgelabz.util.Utility;
import com.fasterxml.jackson.core.JsonParser;

/***************************************************************************
* Author: RupeshPatil
* Date: 10/12/2019
* Purpose:This Program is used to manage a list of Doctors associated with the clinic. This also manages the list of patients who use the clinic. 
* It manages Doctors by Name, Id, Specialization and Availability (AM or PM) . It manages Patients by Name, ID, Mobile Number and Age. The Program allows
* users to search Doctor by name, id, Specialization or Availability. Also the programs allows users to search patient by name, mobile number or id.
* The programs allows patients to take appointment with the doctor. A doctor at any availability time can see only 5 patients. If exceeded the user can 
* take appointment for patient at different date or availability time.
* 
* Users:
* 			-Doctor
* 			-Patient
***************************************************************************/
public interface CliniqManagement 
{
	
	static DoctorDetails doctorDetails=new DoctorDetails();
	static PatientDetails patientdetails=new PatientDetails();
	static JSONObject doctorjson=new JSONObject();
	static JSONObject patientjson=new JSONObject();
	static String doctorFile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/cliniquemanagement/Doctors.json";
	static String patientFile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/cliniquemanagement/Patient.json";
	static String appointmentFile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/cliniquemanagement/AppointMent.json";
	static CliniqManagementService clinic=new CliniqManagementService();
	
	public static void doctorMenu() throws JSONException
	{
		System.out.println("============================>>WellCome To Clinic Management<<==========================\n\n\n");
		System.out.println("If you are New Doctor Sir Please Register press 1 for registration");
		System.out.println("1.Register  2.Continue");
		int input=0;
		try{
				input=Utility.InputInt();
		}catch (NumberFormatException e) {
			System.out.println("Invalid input please Enter Valid input");
			doctorMenu();
		}
		if(input==1)
		{
			doctorRegister();
		}
		else if(input==2)
		{
			System.out.println("press 1 For Search Patient press 2 for all patient List");
			System.out.println("1.Search Patient 2.All Patient List");
			int input2=0;
			try{
					input2=Utility.InputInt();
			}catch (Exception e) {
				System.out.println("inavalid input");
			}
			
			switch(input2)
			{
				case 1:
						
						searchPatientByDoctor();
						break;
				case 2:
						getPatientList();
						break;
				case 3:
						clinic.mainMenu();
						break;
				case 4:
						System.exit(0);
				default:
						System.out.println("Invalid choice");
					
			}
		}
		else
		{
			System.out.println("Invalid Input");
			doctorMenu();
		}
	}
	
	/*************************************************************************************************
	 * static Method to Register Patients who are new.
	 * 
	 * @param no param
	 * @return void
	 *  @throws JSONException
	 *******************************************************************************/	
	
	@SuppressWarnings("unchecked")
	public static void patientRegister() throws JSONException
	{
		JSONObject mainobject=new JSONObject();
		System.out.println("Enter Your Name");
		String name=Utility.InputString();
		patientdetails.setPatientName(name);
		patientjson.put("Patient Name", name);

		String id=LogicalProgram.GenerateCode(10);
		patientdetails.setPatientId(id);
		patientjson.put("Patient Id", id);

		
		System.out.println("Enter your age");
		int age=Utility.InputInt();
		patientdetails.setAge(age);
		patientjson.put("Patient Age", Integer.toString(age));

		
		System.out.println("Enter your Mobile Number");
		long mobNo=Utility.inputLong();
		patientdetails.setMoNumber(mobNo);
		patientjson.put("Patient Mob No:", Long.toString(mobNo));
		mainobject.put(mobNo, patientjson);
		JsonUtility.writeToFile(patientFile, mainobject);
		System.out.println();
		System.out.println();

		System.out.println(name+"You Registered SuccessFully");

	}


	/*************************************************************************************************
	 * static Method to Register Doctors who are new.
	 * 
	 * @param no param
	 * @return void
	 *  @exception JSONException
	 *******************************************************************************/	
	
	@SuppressWarnings("unchecked")
	public static void doctorRegister() throws JSONException
	{
		JSONObject mainobject=new JSONObject();
		System.out.println("Enter Your Id");
		String id=Utility.InputString();
		doctorDetails.setDoctorId(id);
		doctorjson.put("Doctor id", id);
		
		System.out.println("Enter your Name");
		String name=Utility.InputString();
		doctorDetails.setDoctorName(name);
		doctorjson.put("Doctor name", name);
		
		System.out.println("Enter your Specialization");
		String specialization=Utility.InputString();
		doctorDetails.setSpecialization(specialization);
		doctorjson.put("specialization", specialization);
		
		System.out.println("Enter Your Availablity For Patient");
		String availablity=Utility.InputString();
		doctorDetails.setAvailablity(availablity);
		doctorjson.put("availablity", availablity);
		mainobject.put(id, doctorjson);
		System.out.println();
		System.out.println();
		JsonUtility.writeToFile(doctorFile, mainobject);
		System.out.println("Dr. "+name+" You Registered SuccessFully");
	}

	/*************************************************************************************************
	 * static Method to Search Patients by the doctors and get the details of patients.
	 * 
	 * @param no parameters
	 * @return void
	 * @exception JSONException
	 *  
	 *******************************************************************************/	
	
	public static void  searchPatientByDoctor() throws JSONException
	{
		
		System.out.println("Enter Patiet Name");
		String name=Utility.InputString();
		System.out.println("Enter Patiet Contact");
		String phno=Utility.InputString();
		JSONObject PersonObject = new JSONObject();
		JSONParser parser=null;
		//Iterating through ArrayObjects
		try 
		{
			String fileRead = JsonUtility.readFile(patientFile);
			try {
				PersonObject = (JSONObject)parser.parse(fileRead);
				if(PersonObject.containsKey(phno))
				{
					JSONObject object=(JSONObject) PersonObject.get(phno);
					
					System.out.println("Patient Id:"+object.get("Patient Id"));
					System.out.println("Patient Name:"+object.get("Patient Name"));
					System.out.println("Patient Age:"+object.get("Patient Age"));

				}	
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	

	/*************************************************************************************************
	 * static Method to gel all Patients list and informations.
	 * @param no param
	 * @return void
	 *  @exception JSONException
	 *******************************************************************************/	
	
	
	@SuppressWarnings("unchecked")
	public static void getPatientList() throws JSONException
	{
		JSONObject PersonObject=new JSONObject();
		JSONParser parser=null;
		try 
		{
			String fileRead = JsonUtility.readFile(patientFile);
			try {
				PersonObject = (JSONObject)parser.parse(fileRead);
				JSONObject temp=PersonObject;
				System.out.println(" Patient Id\tPatient Name\tAge");
				PersonObject.keySet().forEach(key ->{ 
					//System.out.println(key);			
						JSONArray arrayItems = new JSONArray();
						arrayItems.add(temp.get(key));
						Iterator<?> iterator = arrayItems.iterator();
						JSONObject jsonObject=null;
						while(iterator.hasNext())
						{
							jsonObject=(JSONObject) iterator.next();

							System.out.print("Patient Id:"+jsonObject.get("Patient Id"));
							System.out.print("Patient Name:"+jsonObject.get("Patient Name"));
							System.out.print("Patient Age:"+jsonObject.get("Patient Age"));
							System.out.println();
						} 
					
				});
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		}
	
	}
	

	/*************************************************************************************************
	 * static Method to count Appointments for perticuler Doctors..
	 * 
	 * @param no param
	 * @return void
	 *  
	 *******************************************************************************/	
	
	public static int getCount(String doctorName)
	{
		int count=0;
		String jsonData = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(appointmentFile));
			while ((line = br.readLine()) != null) {
				jsonData = line + "\n";
				JSONObject obj;
				try {
					obj = new JSONObject(jsonData);
				
				System.out.println();
				if(obj.getString("doctor Name").equals(doctorName))
				{
					count=obj.getInt("Token No");
				}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
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
		return ++count;
	}
	public void mainMenu(); 

}
