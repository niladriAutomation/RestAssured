package APIAutomation.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingResponse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Json parsing to retrieve results
		Response re = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.get(" http://localhost:3000/apistudents");
		//System.out.println(re.asString());
		JSONArray array = new JSONArray(re.asString());
		JSONObject object = array.getJSONObject(7);
		System.out.println(object.get("Name"));
		JSONArray array1 = new JSONArray(re.asString());
		JSONObject nextthobject = array1.getJSONObject(8);
		JSONArray adressarray = nextthobject.getJSONArray("Adress");
		JSONObject addressobj = adressarray.getJSONObject(1);
		System.out.println(addressobj.get("Building"));
		System.out.println(addressobj.get("Floor"));
		JSONArray arraynext = new JSONArray(re.asString());
		JSONObject tenObject = arraynext.getJSONObject(10);
		Set <String> allkeys = tenObject.keySet();
		for (String key:allkeys) {
			System.out.println("key name is "+key+"\t value is "+tenObject.getString(key));
		}
		JSONArray resarray = new JSONArray(re.asString());
		int arrayLength = resarray.length();
		for(int i = 0;i<arrayLength;i++) {
			JSONObject multipleObject = arraynext.getJSONObject(i);
			System.out.println(multipleObject.get("id"));
		}
		
		
		
		

	}

}
