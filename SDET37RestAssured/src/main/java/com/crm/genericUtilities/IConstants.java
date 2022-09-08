package com.crm.genericUtilities;

public interface IConstants 
{
	String filePath="./src/test/resources/commonDataOLMT.properties";
	String excelPath="./src/test/resources/OlmEmployeeData1.xlsx";
	String chromePath="./src/main/resources/chromedriver.exe";
	String  firefoxPath="/src/main/resources/geckodriver.exe";
	String chromeKey="webdriver.chrome.driver";
	
	int implicitlyWaitDuration=10;
	int explicitWaitDuration=10;
	int scriptTimeOutDuration=10;
	
	
	String DbUrl="jdbc:mysql://localhost:3306/";
	String DBUsername="root";
	String DBPassword="root";
	
	String appUserName = "rmgyantra";
	String appPassword="rmgy@9999";
	
}
