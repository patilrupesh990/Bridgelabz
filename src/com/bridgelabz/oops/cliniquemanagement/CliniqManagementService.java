package com.bridgelabz.oops.cliniquemanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.bridgelabz.algorithmprograms.PermutationOfString;
import com.bridgelabz.oops.addressbook.JsonUtility;
import com.bridgelabz.util.LogicalProgram;
import com.bridgelabz.util.Utility;

public class CliniqManagementService 
{
	static HashMap<String,DoctorDetails> doctorMap=new HashMap<String,DoctorDetails>();
	static HashMap<String,PatientDetails> patientMap=new HashMap<String,PatientDetails>();
	static JSONObject doctorjson=new JSONObject();
	static JSONObject patientjson=new JSONObject();
	static DoctorDetails doctorDetails=new DoctorDetails();
	static PatientDetails patientDetails=new PatientDetails();
	static String doctorFile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/cliniquemanagement/Doctors.json";
	static String patientFile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/cliniquemanagement/Patient.json";
	
		public static void mainMenu() throws JSONException
		{
			int choice = 0;
			System.out.println("Enter your Choice");
			System.out.println("1.Doctor  2.Patient");
			try{
			 choice=Utility.InputInt();
			}catch (NumberFormatException e) {
				System.out.println("");
			}
			if(choice==1)
			{
				doctorMenu();
			}
			else if(choice==2)
			{
				patientRegister();
			}
			else
			{
				System.out.println("Invalid Input you have Entered");
				mainMenu();
			}
		}
		
		
		public static void doctorMenu() throws JSONException
		{
			System.out.println("Press 1 For Cotinue");
			System.out.println("Are You New ?? press 2 for Register");
			int input=Utility.InputInt();
			if(input==1)
			{
				getPatientList();
			}
			else if(input==2)
			{
				register();
			}
			else
			{
				System.out.println("Invalid Input");
				doctorMenu();
			}
		}
		
		public static void patientMenu() throws JSONException
		{
			System.out.println("press 1 for continue");
			System.out.println("New User?? press 2 for register");
			int input=Utility.InputInt();
			if(input==1)
			{
				System.out.println("press 1.Get AppointMent 2.Search Doctor 3.All DoctorList");
				int choice=Utility.InputInt();
				switch(choice)
				{
					case 1:
							//get appointmrnt
							break;
					case 2:
							//search appoinment
							break;
					case 3:
							getDoctorDetails();
							break;
					default:
							System.out.println("invalid choice");
				
				}
			}
			else if(input==2)
			{
				patientRegister();
			}
			else
			{
				System.out.println("Invalid Input");
				patientMenu();
			}
		}
		
		public static void register() throws JSONException
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
		
		public static void patientRegister() throws JSONException
		{
			
			System.out.println("Enter Your Name");
			String name=Utility.InputString();
			patientDetails.setPatientName(name);
			patientjson.put("Patient Name", name);

			String id=LogicalProgram.GenerateCode(10);
			patientDetails.setPatientId(id);
			patientjson.put("Patient Id", id);

			
			System.out.println("Enter your age");
			String age=Utility.InputString();
			patientDetails.setAge(age);
			patientjson.put("Patient Age", age);

			
			System.out.println("Enter your Mobile Number");
			String mobNo=Utility.InputString();
			patientDetails.setMoNumber(mobNo);
			patientjson.put("Patient Mob No:", mobNo);
			JsonUtility.WriteinFile(patientjson.toString(), patientFile);
		}
		
		static String json = "...";
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
		
		public static void getDoctorDetails() throws JSONException
		{
			String jsonData = "";
			BufferedReader br = null;
			try {
				String line;
				br = new BufferedReader(new FileReader(doctorFile));
				while ((line = br.readLine()) != null) {
					jsonData = line + "\n";
					JSONObject obj = new JSONObject(jsonData);
					System.out.println();
					DoctorDetails details=new DoctorDetails();
					System.out.println("Doctor name: " + obj.getString("Doctor name"));
					details.setAvailablity(obj.getString("Doctor name"));
					System.out.println("Doctor name: " + obj.getString("Doctor id"));
					details.setAvailablity(obj.getString("Doctor id"));
					System.out.println("availablity: " + obj.getString("availablity"));
					details.setAvailablity(obj.getString("availablity"));
					System.out.println("specialization: " + obj.getString("specialization"));
					details.setAvailablity(obj.getString("specialization"));
					doctorMap.put(obj.getString("specialization"), details);
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
		
}
