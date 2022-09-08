package com.requestChaining;

import static io.restassured.RestAssured.given;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;
import com.genericLibrary.EmployeeJSONobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ValidateWithUIUsingRequestChaining {
	
	@Test
	public void validUirqstchain() throws InterruptedException
	{
		JavaUtility jlib = new JavaUtility();
		EmployeeJSONobject emp = new EmployeeJSONobject("Krishna", "Mehendi"+jlib.getRandomNumber(), "Completed", 6);
		
		Response resp= given().body(emp).contentType(ContentType.JSON)
				.when()
				.post("http://localhost:8084/addProject");
		
		String pid = resp.jsonPath().get("projectId");
		System.out.println(pid);
		resp.then().log().all();
		
		given()
		.pathParam("hh", pid)
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:8084/projects/{hh}")
		
		.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
	EmployeeJSONobject emp1 = new EmployeeJSONobject("Sadhu", "Mentos"+jlib.getRandomNumber(), "On going", 9);
	given()
	.body(emp1)
	.contentType(ContentType.JSON)
	.pathParam("hooo",pid)
	.when()
	.put("http://localhost:8084/projects/{hooo}")
	.then()
	.assertThat().contentType(ContentType.JSON)
	.assertThat().statusCode(200)
	.log().all();
		given()
		.pathParam("hi",pid)
		.contentType(ContentType.JSON)
		//.pathParam("mm", postdata)
		.when()
	
		.delete("http://localhost:8084/projects/{hi}")
		.then()
		.contentType(ContentType.JSON)
		.assertThat().statusCode(204)
		.log().all();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8084");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS);
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
	driver.findElement(By.xpath("//button[.='Sign in']")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//a[.='Projects']")).click();
	List<WebElement> projid = driver.findElements(By.xpath("//th[.='ProjectId']"));
	for(WebElement xyz : projid)
	{
		String text = xyz.getText();
		if(text.contains(pid))
		{
			System.out.println("data is not deleted");
		}
		else
		{
			System.out.println("data is deleted");
			break;
		}
	}
	
	driver.findElement(By.xpath("//a[.='Logout']")).click();
		
		
	
		
	}

}
