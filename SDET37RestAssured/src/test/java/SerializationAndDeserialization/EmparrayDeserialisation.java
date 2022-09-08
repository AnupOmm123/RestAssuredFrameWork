package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.genericLibrary.EmpArray;
import com.genericLibrary.Employee;

public class EmparrayDeserialisation {

	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		ObjectMapper omap1 = new ObjectMapper();
	 EmpArray emp2 = omap1.readValue(new File("./emparr.json"),EmpArray.class);
		System.out.println(emp2.getEmail()[0]);
	}

}
