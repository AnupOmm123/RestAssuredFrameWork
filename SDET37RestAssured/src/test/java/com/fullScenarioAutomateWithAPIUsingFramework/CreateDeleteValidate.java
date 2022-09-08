package com.fullScenarioAutomateWithAPIUsingFramework;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.genericUtilities.BaseApiClass;
import com.crm.genericUtilities.EndPointLibrary;
import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.JavaUtility;
import com.crm.genericUtilities.RestAssuredLibrary;
import com.crm.genericUtilities.WebDriverUtility;

import POJOClasses.ProjectLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateDeleteValidate extends BaseApiClass{
@Test
public void validateCrudOperation() throws SQLException, InterruptedException {
	WebDriver driver = null;
	
	baseURI="http://localhost";
	port=8084;

	JavaUtility jlib = new JavaUtility();
	ProjectLibrary plib = new ProjectLibrary("Testyantra", "rmgyantra"+jlib.getRandomNumber(), "On Going", 5);
	
	Response resp = given()
	.body(plib)
	.contentType(ContentType.JSON)
	.when()
	.post(EndPointLibrary.createProject);
	
	RestAssuredLibrary rlib = new RestAssuredLibrary();
	String id1 = rlib.getJsonData(resp, "projectId");
	System.out.println(id1);
	
	resp.then()
	.assertThat().statusCode(201)
	.log().all();
	
	
	
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	WebDriverUtility wlib = new WebDriverUtility();
	wlib.maximizeTheWindow(driver);
	wlib.refershThePage(driver);
	
	driver.get("http://localhost:8084");
	
	driver.findElement(By.id("usernmae")).sendKeys(IConstants.appUserName);
	driver.findElement(By.id("inputPassword")).sendKeys(IConstants.appPassword);
	driver.findElement(By.xpath("//button[.='Sign in']")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//a[.='Projects']")).click();

	List<WebElement> pids = driver.findElements(By.xpath("//td[1]"));
	boolean flag=false;
	int count = 0;
	//Thread.sleep(3000);
	for(WebElement wpid : pids)
	{
		String text = wpid.getText();
		if(text.contains(id1))
		{
			flag=true;
			break;
		}
		count++;
	}
	if(flag==true)
	{
	Assert.assertTrue(true);
	System.out.println("Data is present in GUI");
	}else
	{
		System.out.println("Data is not present in GUI");
		Assert.assertTrue(false);
	}
	//System.out.println("data is verified");
	
	driver.findElement(By.xpath("//a[.='Logout']")).click();
	driver.quit();
	
	dlib.executeQuery("select * from project", 1, id1);
	
	
	given()
	.contentType(ContentType.JSON)
	.pathParam("ids", id1)
	.when()
	.delete(EndPointLibrary.deleteProject+"{ids}")
	.then()
	.assertThat().statusCode(204)
	.log().all();
	
	
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	WebDriverUtility wlib1 = new WebDriverUtility();
	wlib1.maximizeTheWindow(driver);
	wlib1.refershThePage(driver);
	
	driver.get("http://localhost:8084");
	
	driver.findElement(By.id("usernmae")).sendKeys(IConstants.appUserName);
	driver.findElement(By.id("inputPassword")).sendKeys(IConstants.appPassword);
	driver.findElement(By.xpath("//button[.='Sign in']")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//a[.='Projects']")).click();

	List<WebElement> pids1 = driver.findElements(By.xpath("//td[1]"));
	boolean fly=false;
	int countt = 0;
	//Thread.sleep(3000);
	for(WebElement wpids : pids1)
	{
		String text = wpids.getText();
		if(text.contains(id1))
		{
			fly=true;
			break;
		}
		countt++;
	}
	if(fly==true)
	{
	Assert.assertTrue(true);
	System.out.println("Data is present in GUI 2");
	}else
	{
		System.out.println("Data is not present in GUI 2");
		
	}
	//System.out.println("data is verified");
	
	driver.findElement(By.xpath("//a[.='Logout']")).click();
	driver.quit();
	
	dlib.executeQuery("select * from project", 1, id1);
	
	
	
	
	
	
}
	
	
}
