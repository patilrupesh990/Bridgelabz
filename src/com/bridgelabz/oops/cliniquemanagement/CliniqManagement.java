package com.bridgelabz.oops.cliniquemanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import com.bridgelabz.oops.addressbook.JsonUtility;
import com.bridgelabz.util.LogicalProgram;
import com.bridgelabz.util.Utility;

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
	
	
	public static void patientRegister() throws JSONException
	{
		
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
		patientjson.put("Patient Age", age);

		
		System.out.println("Enter your Mobile Number");
		long mobNo=Utility.inputLong();
		patientdetails.setMoNumber(mobNo);
		patientjson.put("Patient Mob No:", mobNo);
		JsonUtility.WriteinFile(patientjson.toString(), patientFile);
	}

	
	
	public static void doctorRegister() throws JSONException
	{
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
		
		JsonUtility.WriteinFile(doctorjson.toString(), doctorFile);
	
	}
	
	
	public static void  searchPatientByDoctor() throws JSONException
	{
		
		String jsonData = "";
		BufferedReader br = null;
		
		try {
			String line;
			br = new BufferedReader(new FileReader(patientFile));
			while ((line = br.readLine()) != null) {
				jsonData = line + "\n";
				JSONObject obj = new JSONObject(jsonData);
					System.out.println(obj.getString("Patient Name"));
					System.out.println(Integer.parseInt(obj.getString("Patient Age")));
					System.out.println(Long.parseLong(obj.getString("Patient Age")));
				
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
	}
	
	
	
	
	public static void getPatientList() throws JSONException
	{
		String jsonData = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(patientFile));
			while ((line = br.readLine()) != null) {
				jsonData = line + "\n";
				JSONObject obj = new JSONObject(jsonData);
				System.out.println();
				
				System.out.println("Patient Name: " + obj.getString("Patient Name"));
				System.out.println("Patient Id: " + obj.getString("Patient Id"));
				System.out.println("Patient Age: " + obj.getString("Patient Age"));
				System.out.println("Patient Mob No: " + obj.getString("Patient Mob No:"));
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
	
	}
	
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
