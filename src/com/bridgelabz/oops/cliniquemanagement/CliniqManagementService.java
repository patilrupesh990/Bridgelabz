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

public class CliniqManagementService implements CliniqManagement
{
	
	static JSONObject doctorjson=new JSONObject();
	static JSONObject patientjson=new JSONObject();
	static JSONObject appointmentjson=new JSONObject();
	static DoctorDetails doctorDetails=new DoctorDetails();
	static PatientDetails patientDetails=new PatientDetails();
	static String doctorFile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/cliniquemanagement/Doctors.json";
	static String patientFile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/cliniquemanagement/Patient.json";
	static String appointmentFile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/cliniquemanagement/AppointMent.json";
	
	static int count;
	
	/*********************************************************************************
	 * Override Method From CliniqManagement  its works as MainMenu For the Whole Program there is
	 * multiple choice for different operations like,
	 * -Doctor
	 * -Patient
	 * @param no param
	 * @return void
	 *  
	 *******************************************************************************/	

	@Override
	public void mainMenu()
	{
		int choice = 0;
		while(true)
		{
				System.out.println("Enter your Choice");
				System.out.println("1.Doctor  2.Patient 3.exit");
				try{
					
				 choice=Utility.InputInt();
				 
				}catch (NumberFormatException e) 
				{
					System.out.println("invalid input");
				}
				try {
				if(choice==1)
					
						CliniqManagement.doctorMenu();
					
				else if(choice==2)
					this.patientMenu();
				else if(choice==3)
					System.exit(0);
				
				else
				{
					System.out.println("Invalid Input you have Entered");
					this.mainMenu();
				}
				} catch (JSONException e) {
					e.printStackTrace();
				}
		}
	}
	
	/************************************************************************************************
	 * To Display Menu Options For the User Patient there is multiple choice options user can select
	 * @param no param
	 * @return void
	 *  
	 *  	logic:If user is alrady register then user can continue if new Then Need To Register First
	 *******************************************************************************************/	

		public  void patientMenu() throws JSONException
		{
			System.out.println("============================>>WellCome To Clinic Management<<==========================\n\n\n");
			System.out.println("If you are New Patient Sir Please Register press 2 for registration");
			System.out.println("1. continue  2.Register");
			System.out.println("New User?? press 2 for register");
			int input=0;
			try{
				input=Utility.InputInt();
			}catch (NumberFormatException e) {
					System.out.println("Invalid input please Enter Valid input");
					//CliniqManagement.doctorMenu();
			}
			if(input==1)
			{
				System.out.println("press 1.Get AppointMent 2.Search Doctor 3.All DoctorList 4.Main Menu");
				int choice=Utility.InputInt();
				switch(choice)
				{
					case 1:
							getAppointment();
							break;
					case 2:
							//search appoinment
							
							
							//getAppointment();
							break;
					case 3:
							this.getDoctorDetails();
							break;
					case 4: 
							mainMenu();
							break;
					default:
							System.out.println("invalid choice");
				}
			}
			else if(input==2)
			{
				CliniqManagement.patientRegister();
			}
			else
			{
				System.out.println("Invalid Input");
				patientMenu();
			}
		}
		
		/*************************************************************************************************
		 * its Method to getAppoinment by the Patient who is alrady registered with and can take appointment
		 * 
		 * @param no param
		 * @return void
		 *  
		 *  logic:first will check whether user is registered or not then take doctor details and patient 
		 *  details and to put in .json objects
		 *******************************************************************************/	

		
		public void getAppointment() throws JSONException
		{
			try {
				Object result=searchDoctor();
				if(result==null)
				{
					System.out.println("Doctor Not Avialable For this Speciality");
					patientMenu();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			System.out.println("Enter The Doctor Name or id from Given List");
			String id=Utility.InputString();
			
			System.out.println("Are you Confirm?? press 1 for book Appointment");
			int input=Utility.InputInt();
			if(input==1)
			{
				System.out.println("Enter your mob no");
				long phno=Utility.inputLong();
				
				
				
				AppontmentDetails search=searchPatient(phno,id);
				if(search!=null)
				{
							DoctorDetails appointment=bookAppointMent(id);
							String name=appointment.getDoctorName();
							search.setDoctoreName(name);
							search.setDoctorSpecialization(appointment.getSpecialization());
							search.setTime(appointment.getAvailablity());
							appointmentjson.put("Patient Name", search.getPatientName());
							appointmentjson.put("doctor Name",search.getDoctoreName());
							appointmentjson.put("doctor specialization",search.getDoctorSpecialization());
							appointmentjson.put("time",search.getTime());
							appointmentjson.put("Token No",search.getCount());
							if(AppointmentCount(appointment.getDoctorName())==5)
							{
								System.out.println("Doctor is Not Availale For Today Please book for tommorow or search for another doctor");
							}
							else
							{
								JsonUtility.WriteinFile(appointmentjson.toString(), appointmentFile);
								System.out.println("your appointment is suucessfully booked");
							}
				}
				else
				{
					System.out.println("You are Not registered For this Number please Register First");
				}

				
			}
			else
			{
				System.out.println("Invalid Input please Enter Valid Input");
			}
			
		}
		
		/*********************************************************************************
		 * To book Patient Appointment with Different Doctors it will take doctor name,id,availablity,specializtion
		 * from Doctors.json file and return Doctor Details object.
		 *
		 * @param no param
		 * @return void
		 * @exception JSONException  
		 *******************************************************************************/
		
		public DoctorDetails bookAppointMent(String name) throws JSONException
		{
		     DoctorDetails doctorappoint=new DoctorDetails();
			
		     String jsonData = "";
				BufferedReader br = null;
				try {
					String line;
					br = new BufferedReader(new FileReader(doctorFile));
					while ((line = br.readLine()) != null) {
						jsonData = line + "\n";
						JSONObject obj = new JSONObject(jsonData);
						System.out.println();
						if(obj.getString("Doctor name").equals(name))
						{
						doctorappoint.setDoctorName(obj.getString("Doctor name"));
						doctorappoint.setDoctorId(obj.getString("Doctor id"));
						doctorappoint.setAvailablity(obj.getString("availablity"));
						doctorappoint.setSpecialization(obj.getString("specialization"));
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
				return doctorappoint;
		}
		
		/*********************************************************************************
		 * To get All the details of Doctor like. Doctor name,id,availablity..ect will take from doctors.json
		 * File And print the deatils on consol.
		 *
		 * @param no param
		 * @return void
		 * @exception JSONException 
		 *******************************************************************************/
	
		
		public void getDoctorDetails() throws JSONException
		{
			String jsonData = "";
			BufferedReader br = null;
			try {
				String line;
				br = new BufferedReader(new FileReader(doctorFile));
				while ((line = br.readLine()) != null) {
					jsonData = line + "\n";
					JSONObject obj = new JSONObject(jsonData);
					System.out.println("===============================>>All Doctors List<<=============================");
					System.out.println("Doctor name: " + obj.getString("Doctor name"));
					System.out.println("Doctor id: " + obj.getString("Doctor id"));
					System.out.println("availablity: " + obj.getString("availablity"));
					System.out.println("specialization: " + obj.getString("specialization"));

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
		
		/*********************************************************************************
		 * To search the doctors from the doctors.json file based on the Doctors Specialization
		 * using this user can search the doctors based on their Specialization.
		 * 
		 * 
		 * @param no parameter
		 * @return void
		 * @exception JSONException  
		 *******************************************************************************/
		
		public  DoctorDetails searchDoctor() throws JSONException
		{
			String jsonData = "";
			BufferedReader br = null;
			DoctorDetails doctor=new DoctorDetails();
			System.out.println("Enter The Specialization of Doctor?");
			String specialization=Utility.InputString();
			try {
				String line;
				br = new BufferedReader(new FileReader(doctorFile));
				while ((line = br.readLine()) != null) {
					jsonData = line + "\n";
					JSONObject obj = new JSONObject(jsonData);
					System.out.println();
					if(obj.getString("specialization").equals(specialization))
					{
						System.out.println("Doctor name: " + obj.getString("Doctor name"));
						doctor.setDoctorName(obj.getString("Doctor name"));
						System.out.println("Doctor name: " + obj.getString("Doctor id"));
						System.out.println("availablity: " + obj.getString("availablity"));
						System.out.println("specialization: " + obj.getString("specialization"));
						doctor.setSpecialization(obj.getString("specialization"));
						System.out.println("===============================>>Specialist for "+specialization+"<<=============================");

						return doctorDetails;
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
			return null;
		}
		
		
		
		/*********************************************************************************
		 * To Searh Patients Based on their contact numbers and name.it will be used by doctors
		 * to search the patients based on their contact or name.
		 * 
		 * 
		 * @param no param
		 * @return void
		 * @exception JSONException 
		 *******************************************************************************/
		public AppontmentDetails searchPatient(long phNo,String name) throws JSONException
		{
			
			String jsonData = "";
			BufferedReader br = null;
			System.out.println();
			try {
				String line;
				br = new BufferedReader(new FileReader(patientFile));
				while ((line = br.readLine()) != null) {
					jsonData = line + "\n";
					JSONObject obj = new JSONObject(jsonData);
					long contact=Long.parseLong(obj.getString("Patient Mob No:"));
					//count=Integer.parseInt(obj.getString("Token No"));
					if(contact==phNo)
					{
						AppontmentDetails appointment=new AppontmentDetails();
						String appoinmentid=LogicalProgram.GenerateCode(5);
						appointment.setAppointmentId(appoinmentid);
						appointment.setCount(CliniqManagement.getCount(name));
						appointment.setPatientName(obj.getString("Patient Name"));
						return appointment;
						
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
			return null;
		}
	
		
		/*********************************************************************************
		 * To count the appointments taken by the user for perticuler doctors.
		 * 
		 * logic: it will count all all perticuler doctors appointments if it will reached to 5
		 * it will give message to take appointment for next day or week.
		 * 
		 *
		 * @param no param
		 * @return void
		 * @exception JSONException 
		 *******************************************************************************/
		public  int AppointmentCount(String DoctorName) throws JSONException
		{
			String jsonData = "";
			BufferedReader br = null;
			int result=0;
			try {
				String line;
				br = new BufferedReader(new FileReader(appointmentFile));
				while ((line = br.readLine()) != null) {
					jsonData = line + "\n";
					JSONObject obj = new JSONObject(jsonData);
					System.out.println();
					if(obj.getString("doctor Name").equals(DoctorName))
					{
						count=obj.getInt("Token No");
						
						if(count==5)
						{
							result=count;
							return result;
						}
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
			return result;
		}
		
		
		
		
		
}
