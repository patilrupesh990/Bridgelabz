package com.bridgelabz.oops.cliniquemanagement;


/***************************************************************************
* Author: RupeshPatil
* Date: 10/12/2019
* Purpose:contains Doctors details and a Bean class as MOdel for Clinic management System.
* 
* Users:
* 			-Doctor
***************************************************************************/

public class DoctorDetails 
{
	private String doctorName;
	private String doctorId;
	private String Specialization;
	private String Availablity;
	/** To get doctorName
	 * @param no parameter
	 * @return String
	 * **/
	public String getDoctorName() {
		return doctorName;
	}
	/** To set doctorName
	 * 
	 * @param String
	 * @return void
	 * **/

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	/** To get doctorId
	 * @param no parameter
	 * @return String
	 * **/

	public String getDoctorId() {
		return doctorId;
	}
	
	/** To set doctorId
	 * @param String
	 * @return void
	 * **/

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	
	/** To get doctorSpecialization
	 * @param no parameter
	 * @return String
	 * **/

	public String getSpecialization() {
		return Specialization;
	}
	
	/** To set doctorSpecialization
	 * @param String
	 * @return void
	 * **/

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	
	/** 
	 * To get doctorAvailablity
	 * @param no parameter
	 * @return String
	 **/

	public String getAvailablity() {
		return Availablity;
	}
	
	/** To set doctorAvailablity
	 * @param String
	 * @return void
	 * **/
	public void setAvailablity(String availablity) {
		Availablity = availablity;
	}
	
}
