package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.genericLibrary.EmployeeWithObject;
import com.genericLibrary.spouceObject;

public class EmployeeObjectSerialisation {

	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		spouceObject sp = new spouceObject("Sai","Sai123");
		EmployeeWithObject eobj = new EmployeeWithObject("Anup","ty123",sp);
		ObjectMapper objsp=new ObjectMapper();
		objsp.writeValue(new File("./empspouce.json"), eobj);

	}

}
