package com.bridgelabz.oops.cliniquemanagement;

import org.json.JSONException;


/***************************************************************************
* Author: RupeshPatil
* Date: 10/12/2019
* Purpose:This Program is Controller of Clinic Management Program. list of Doctors associated with the clinic. This also manages the list of patients who use the clinic. 
* It manages Doctors by Name, Id, Specialization and Availability (AM or PM) . It manages Patients by Name, ID, Mobile Number and Age. The Program allows
* users to search Doctor by name, id, Specialization or Availability. 
* Users:
* 			-Doctor
* 			-Patient
***************************************************************************/

public class CliniqController 
{
	public static void main(String args[]) throws JSONException
	{
		CliniqManagementService clinic=new CliniqManagementService();
		clinic.mainMenu();
	}
}
