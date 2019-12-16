package com.bridgelabz.oops.cliniquemanagement;


public class PatientDetails {

	private String patientId;
	private String patientName;
	private long moNumber;
	private int age;

	/** To get PatientId
	 * @param no parameter
	 * @return String
	 * **/
	public String getPatientId() {
		return patientId;
	}

	/** To set PatientId
	 * 
	 * @param String
	 * @return void
	 * **/
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	/** To get PatientName
	 * @param no parameter
	 * @return String
	 * **/
	public String getPatientName() {
		return patientName;
	}
	/** To set doctorNumber
	 * 
	 * @param String
	 * @return void
	 * **/
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	/** To get PatientNumber
	 * @param no parameter
	 * @return String
	 * **/

	public long getMoNumber() {
		return moNumber;
	}

	public void setMoNumber(long moNumber) {
		this.moNumber = moNumber;
	}
	/** To get PatientAge
	 * @param no parameter
	 * @return String
	 * **/
	public int getAge() {
		return age;
	}
	/** To set PatientAge
	 * 
	 * @param String
	 * @return void
	 * **/
	public void setAge(int age) {
		this.age = age;
	}
}
