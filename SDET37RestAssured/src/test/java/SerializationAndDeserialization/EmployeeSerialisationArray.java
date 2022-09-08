package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.genericLibrary.EmpArray;

public class EmployeeSerialisationArray {

	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		//create object of an array
		int[] marr= {1234,5678};
		String[] arrs = {"anu@gmail.com","anu@yahoo.com"};
		EmpArray aeparr = new EmpArray("Raghu","ty234",marr,arrs); 
		ObjectMapper objma = new ObjectMapper();
		objma.writeValue(new File("./emparr.json"), aeparr);
		

	}

}
