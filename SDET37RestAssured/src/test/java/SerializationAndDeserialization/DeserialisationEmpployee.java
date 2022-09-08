package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.genericLibrary.Employee;

public class DeserialisationEmpployee {

	public static void main(String[] args) throws Throwable, Throwable, Throwable {

		ObjectMapper ojmap = new ObjectMapper();
		Employee emp1 = ojmap.readValue(new File("./Emloyee.json"),Employee.class);
		System.out.println(emp1.getEmpName());

	}

}
