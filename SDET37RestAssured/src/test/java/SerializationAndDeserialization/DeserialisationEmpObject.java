package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.genericLibrary.*;

public class DeserialisationEmpObject {

	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		ObjectMapper obm3 = new ObjectMapper();
		com.genericLibrary.EmployeeWithObject spemp1 = obm3.readValue(new File("./empspouce.json"),EmployeeWithObject.class);
	System.out.println(spemp1.getEid());
	}
	

}
