package com.genericLibrary;

public class EmpArray {
	String Name;
	String Id;
	int[] MobileNumber;
	String[] Email;
	public EmpArray(String name, String id, int[] mobileNumber, String[] email) {
		super();
		Name = name;
		Id = id;
		MobileNumber = mobileNumber;
		Email = email;
	}
	public EmpArray()
	{
	
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public int[] getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(int[] mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String[] getEmail() {
		return Email;
	}
	public void setEmail(String[] email) {
		Email = email;
	}
	

}
