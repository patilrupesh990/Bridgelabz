package com.bridgelabz.oops.cliniquemanagement;

/***********************************************************************************************************
 * @author Rupesh Patil
 * @since 14/12/2019
 * @version 1.0
 * Purpose:Bean class As model of program to set and get Appointment Details
 * Operations:Setter And Getter Method for PatientName,doctorName,Appointment count,doctorsSpecializtaion and 
 * 			  date time when appointment booked. 
 **********************************************************************************************************/

public class AppontmentDetails {
	
	
	private String patientName;
	private String doctoreName;
	private int Count;
	private String doctorSpecialization;
	private String time;
	
	
	/** To get AppointmentTime
	 * @param no parameter
	 * @return String
	 * **/
	public String getTime() {
		return time;
	}
	
	/** To set AppointmentTime
	 * @param String
	 * @return void
	 * **/
	public void setTime(String time) {
		this.time = time;
	}
	private String appointmentId;
	
	/** To get GetAppointmentId
	 * @param no parameter
	 * @return String
	 * **/
	public String getAppointmentId() {
		return appointmentId;
	}
	
	/** To set AppointmentId
	 * 
	 * @param String
	 * @return void
	 * **/
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	/** To get PatientName
	 * @param no parameter
	 * @return String
	 * **/
	public String getPatientName() {
		return patientName;
	}
	
	/** To set PatientName
	 * @param String
	 * @return void
	 * **/
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	/** To get DoctoreName
	 * @param no parameter
	 * @return String
	 * **/
	public String getDoctoreName() {
		return doctoreName;
	}
	
	/** To set DoctoreName
	 * @param String
	 * @return void
	 * **/
	public void setDoctoreName(String doctoreName) {
		this.doctoreName = doctoreName;
	}
	
	/** To get Appointment Count
	 * @param no parameter
	 * @return int
	 * **/
	public int getCount() {
		return Count;
	}
	
	/** To setCount
	 * @param int
	 * @return void
	 * **/
	public void setCount(int count) {
		Count = count;
	}
	
	/** To get DoctoreSpecialization
	 * @param no parameter
	 * @return String
	 * **/
	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}
	
	/** To set DoctoreSpecialization
	 * @param String
	 * @return void
	 * **/
	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}
	
}
