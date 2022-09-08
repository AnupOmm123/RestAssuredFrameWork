package com.genericLibrary;

public class Employee {
	String EmpName;
	String EmpId;
	String EmpMail;
	int MobileNum;
	public Employee(String empName, String empId, String empMail, int mobileNum) {
	
		EmpName = empName;
		EmpId = empId;
		EmpMail = empMail;
		MobileNum = mobileNum;
	}
	public Employee()
	{
	

}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpId() {
		return EmpId;
	}
	public void setEmpId(String empId) {
		EmpId = empId;
	}
	public String getEmpMail() {
		return EmpMail;
	}
	public void setEmpMail(String empMail) {
		EmpMail = empMail;
	}
	public int getMobileNum() {
		return MobileNum;
	}
	public void setMobileNum(int mobileNum) {
		MobileNum = mobileNum;
	}
}
