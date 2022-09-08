package com.crm.genericUtilities;

import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseApiClass {

	public DataBaseUtility dlib = new DataBaseUtility();
	public JavaUtility jlib = new JavaUtility();
	
	//connect to database
	@BeforeSuite
	 public void dbbsconfig()
	 {
		 dlib.connectionToDB("projects");
		
	 }
//	@BeforeClass
//	public void validate(String query, int colm, String projectId) throws SQLException
//	{
//		dlib.executeQuery(query, colm, projectId);
//	}
//	
//	@AfterClass
//	public void updatequery(String query) throws SQLException {
//		dlib.executeUpdate(query);
//	}
	//disconnect to db
	@AfterSuite
	public void dbasconifg()
	{
		dlib.closeDB();
		System.out.println("Data base closed");
		
	}
	
	
	
	
}
