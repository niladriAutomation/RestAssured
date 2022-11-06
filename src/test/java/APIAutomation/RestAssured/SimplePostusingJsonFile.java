package APIAutomation.RestAssured;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class SimplePostusingJsonFile {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File input = new File("../RestAssured/simplebody.json");
		FileReader reader = new FileReader(input);
		JSONTokener fileobj = new JSONTokener(reader);
		JSONObject js = new JSONObject(fileobj);
		
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(js.toString())
				.when()
				.post("http://localhost:3000/apistudents");
		System.out.println("Response code is "+res.statusCode());
		System.out.println("Response code is "+res.asString());
		
		
		
		

	}

}
