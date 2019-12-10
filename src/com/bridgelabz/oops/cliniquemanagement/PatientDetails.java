package com.bridgelabz.oops.cliniquemanagement;

public class PatientDetails {

	private String patientId;
	private String patientName;
	private long moNumber;
	private int age;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public long getMoNumber() {
		return moNumber;
	}

	public void setMoNumber(long moNumber) {
		this.moNumber = moNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
