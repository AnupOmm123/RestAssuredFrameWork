package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.genericLibrary.Employee;

public class EmployeeSerialisation {
	public static void main(String[] args) throws Throwable, Throwable, Throwable  {

	Employee employee=new Employee("Anupam","ty123","anu@gmail",123456);
	
	ObjectMapper obj = new ObjectMapper();
	 obj.writeValue(new File("./Emloyee.json"),employee);
	 //run this and refresh the project we get a Employee.json file
		
	}

}
