package com.bridgelabz.oops.cliniquemanagement;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.LogicalProgram;
import com.bridgelabz.util.Utility;


/***************************************************************************
* Author: Rupesh Patil
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

public class CliniqManagementService extends AppointmentFilesReadWrite implements CliniqManagement
{
	
	static JSONObject doctorjson=new JSONObject();
	static JSONObject patientjson=new JSONObject();
	static JSONObject appointmentjson=new JSONObject();
	static DoctorDetails doctorDetails=new DoctorDetails();
	static PatientDetails patientDetails=new PatientDetails();
	static AppointmentFilesReadWrite readwrite =new CliniqManagementService();
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

		
		@SuppressWarnings("unchecked")
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

			System.out.println("Enter The Doctor Name from Given List");
			String id=Utility.InputString();
			
			System.out.println("Are you Confirm?? press 1 for book Appointment");
			int input=Utility.InputInt();
			if(input==1)
			{
				System.out.println("Enter your mob no");
				String phno=Utility.InputString();
				
				
				JSONObject temp=new JSONObject();
				AppontmentDetails search=searchPatient(phno,id);
				if(search!=null)
				{
					JSONParser parser=new JSONParser();
					String fileRead;
					try {
						fileRead = readwrite.readFile(appointmentFile);
					
						temp = (JSONObject)parser.parse(fileRead);
					} catch (FileNotFoundException|ParseException e) {
					}
							DoctorDetails appointment=bookAppointMent(id);
							String name=appointment.getDoctorName();
							search.setDoctoreName(name);
							search.setDoctorSpecialization(appointment.getSpecialization());
							search.setTime(appointment.getAvailablity());
							String id2=LogicalProgram.GenerateCode(10);
							appointmentjson.put("Appointment id:", id2);
							appointmentjson.put("Patient Name", search.getPatientName());
							appointmentjson.put("doctor Name",id);
							appointmentjson.put("doctor specialization",appointment.getSpecialization());
							appointmentjson.put("time",java.time.LocalDateTime.now().toString());
							int count=CliniqManagement.getCount(id);
							appointmentjson.put("Token No",Integer.toString(count));
							temp.put(id2, appointmentjson);
							if(count==6)
							{
								appointmentjson.put("Appointment id:", id2);
								appointmentjson.put("Patient Name", search.getPatientName());
								appointmentjson.put("doctor Name",id);
								appointmentjson.put("doctor specialization",appointment.getSpecialization());
								 Calendar calendar = Calendar.getInstance();
								    								 
								    calendar.add(Calendar.DAY_OF_YEAR, 1);
								    
								    Date tomorrow = calendar.getTime();
								appointmentjson.put("time",tomorrow);
								 count=CliniqManagement.getCount(id);
								appointmentjson.put("Token No",Integer.toString(count));
								temp.put(id2, appointmentjson);
								System.out.println("Doctor is Not Availale For Today Please book for tommorow or search for another doctor ");
								System.out.println("Do you want to Book For Next Day press 1 For Book Appointment..");
								int choice=Utility.InputInt();
								if(choice==1)
								{
									readwrite.writeToFile( appointmentFile,temp);
									System.out.println("your appointment is suucessfully booked");
								}
								else {
									System.out.println("Thans for visit");
								}
								
							}
							else
							{
								readwrite.writeToFile( appointmentFile,temp);
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
		
		static int count2=0;
		/** To get Appointment Count
		 * @param no parameter
		 * @return int
		 * **/
		public static int getCount() {
			return count2;
		}
		
		/** To setCount
		 * @param int
		 * @return void
		 * **/
		public static void setCount(int count) {
			count2 = count;
		}
		/*********************************************************************************
		 * To book Patient Appointment with Different Doctors it will take doctor name,id,availablity,specializtion
		 * from Doctors.json file and return Doctor Details object.
		 *
		 * @param no param
		 * @return void
		 * @exception JSONException  
		 *******************************************************************************/
		
		@SuppressWarnings("unchecked")
		public DoctorDetails bookAppointMent(String name) throws JSONException
		{
		     	DoctorDetails doctorappoint=new DoctorDetails();
		     	JSONObject doctorjson=new JSONObject();
		     	JSONParser parser=new JSONParser();
		     	String fileRead=null;
		     	try {
					fileRead = readwrite.readFile(doctorFile);
				
				doctorjson = (JSONObject)parser.parse(fileRead);
				} catch (FileNotFoundException | ParseException e) {
					e.printStackTrace();
				}	
		     	JSONObject temp=doctorjson;
				doctorjson.keySet().forEach(key ->{ 
					//System.out.println(key);			
						JSONObject jsonObject=(JSONObject) temp.get(key);
							if(jsonObject.get("Doctor name").equals(name))
							{
								
								doctorappoint.setDoctorName(jsonObject.get("Doctor name").toString());
								doctorappoint.setDoctorId(jsonObject.get("Doctor id").toString());
								doctorappoint.setAvailablity(jsonObject.get("availablity").toString());
								doctorappoint.setSpecialization(jsonObject.get("specialization").toString());
							}
							
						 
				});
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
	
		
		@SuppressWarnings("unchecked")
		public void getDoctorDetails() throws JSONException
		{
			JSONObject doctorjson=new JSONObject();
			JSONParser parser=new JSONParser();
			JSONObject stockJson=new JSONObject();

			DoctorDetails doctor=new DoctorDetails();
		
			String fileRead=new String();
			try {
				fileRead = readwrite.readFile(doctorFile);
			
				doctorjson = (JSONObject)parser.parse(fileRead);
			} catch (FileNotFoundException | ParseException e) {
				e.printStackTrace();
			}	
			JSONObject temp=doctorjson;
			doctorjson.keySet().forEach(key->{
				JSONArray arrayItems = new JSONArray();
				arrayItems.add(temp.get(key));
				Iterator<?> iterator = arrayItems.iterator();
				while(iterator.hasNext())
				{
					
					 JSONObject jsonObject=(JSONObject) iterator.next();
					
						System.out.println("Doctor name: " + jsonObject.get("Doctor name"));
						doctor.setDoctorName(jsonObject.get("Doctor name").toString());
						System.out.println("Doctor name: " + jsonObject.get("Doctor id"));
						System.out.println("availablity: " + jsonObject.get("availablity"));
						System.out.println("specialization: " + jsonObject.get("specialization"));
						doctor.setSpecialization(jsonObject.get("specialization").toString());
						System.out.println("===============================>><<=============================");
					 
				}
			});
			
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
		
		@SuppressWarnings("unchecked")
		public  DoctorDetails searchDoctor() throws JSONException
		{
			JSONObject personObject=new JSONObject();
			JSONParser parser=new JSONParser();

			DoctorDetails doctor=new DoctorDetails();
			System.out.println("Enter The Specialization of Doctor?");
			String specialization=Utility.InputString();
			String fileRead;
			try {
				fileRead = readwrite.readFile(doctorFile);
			
				personObject = (JSONObject)parser.parse(fileRead);
			} catch (FileNotFoundException|ParseException e) {
				e.printStackTrace();
			}	
			JSONObject temp=personObject;
			personObject.keySet().forEach(key ->{ 
				//System.out.println(key);			
					JSONObject jsonObject=(JSONObject) temp.get(key);
						String contact=(String) jsonObject.get("specialization");
						System.out.println(contact);
						if(contact.equals(specialization))
						{
							System.out.println("Doctor name: " + jsonObject.get("Doctor name"));
							doctor.setDoctorName(jsonObject.get("Doctor name").toString());
							System.out.println("Doctor name: " + jsonObject.get("Doctor id"));
							System.out.println("availablity: " + jsonObject.get("availablity"));
							System.out.println("specialization: " + jsonObject.get("specialization"));
							doctor.setSpecialization(jsonObject.get("specialization").toString());
							System.out.println("===============================>>Specialist for "+specialization+"<<=============================");						}
			});
		
			return doctorDetails;

		}
		
		
		
		/*********************************************************************************
		 * To Searh Patients Based on their contact numbers and name.it will be used by doctors
		 * to search the patients based on their contact or name.
		 * 
		 * 
		 * @param no param
		 * @return 
		 * @return 
		 * @return void
		 * @exception JSONException 
		 *******************************************************************************/
		AppontmentDetails appointment=new AppontmentDetails();

		@SuppressWarnings("unchecked")
		public AppontmentDetails searchPatient(String phNo,String name) throws JSONException
		{
		
			JSONObject personObject=new JSONObject();
			JSONParser parser=new JSONParser();
			String fileRead;
			try {
				fileRead = readwrite.readFile(patientFile);
			
			personObject = (JSONObject)parser.parse(fileRead);
			} catch (FileNotFoundException|ParseException e) {
				e.printStackTrace();
			}	
			JSONObject temp=personObject;
			personObject.keySet().forEach(key ->{ 
					JSONObject jsonObject=(JSONObject) temp.get(key);
						String contact=(String) jsonObject.get("Patient Mob No:");
						if(contact.equals(phNo))
						{
							String appoinmentid=LogicalProgram.GenerateCode(5);
							appointment.setAppointmentId(appoinmentid);
							appointment.setPatientName(jsonObject.get("Patient Name").toString());
							appointment.setCount(CliniqManagement.getCount(name));
						}
			});
			
			return appointment;
				}
	
		
		/*********************************************************************************
		 * To count the appointments taken by the user for perticuler doctors.
		 * 
		 * logic: it will count all all perticuler doctors appointments if it will reached to 5
		 * it will give message to take appointment for next day or week.
		 * 
		 *
		 * @param no param
		 * @return 
		 * @return void
		 * @exception JSONException 
		 *******************************************************************************/
		@SuppressWarnings("unchecked")
		public  int AppointmentCount(String DoctorName) throws JSONException
		{
			JSONObject appointment=new JSONObject();
			String fileRead=null;
			JSONParser parser=new JSONParser();
			try {
				if(readwrite.readFile(appointmentFile)!=null)
				{
					fileRead = readwrite.readFile(appointmentFile);
				}
				else
				{
					return 1;
				}
				appointment = (JSONObject)parser.parse(fileRead);
			} catch (FileNotFoundException|ParseException e) {
			}	
			JSONObject temp=appointment;
			appointment.keySet().forEach(key ->{ 
				//System.out.println(key);			
					JSONObject jsonObject= (JSONObject) temp.get(key);
						String contact=jsonObject.get("doctor Name").toString();
						System.out.println(contact);
						if(contact.equals(DoctorName))
						{
							int count=Integer.parseInt(jsonObject.get("Token No").toString());
							
							if(count==5)
							{
								return;
							}						
						}
			});
			return 1;		
			
			
		}
		
		
		
		
		
}
