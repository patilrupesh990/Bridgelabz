package com.bridgelabz.oops.cliniquemanagement;

public class AppontmentDetails {
	
	
	private String patientName;
	private String doctoreName;
	private int Count;
	private String doctorSpecialization;
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String appointmentId;
	
	
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctoreName() {
		return doctoreName;
	}
	public void setDoctoreName(String doctoreName) {
		this.doctoreName = doctoreName;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}
	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}
	
}
