package APIAutomation.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.Random;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SimpleJsonUsingPOJO {

	public static void main(String[] args) {
	//Random number generate
		
		Random num = new Random();
		Integer id = num.nextInt(50);
	// pojo class to fetch info fromBasicInformation class	
		BasicInformation bi = new BasicInformation();
		bi.setFirstname("Hariom");
		bi.setLastname("kishore");
		bi.setDesignation("Manager");
		bi.setId(id.toString());
		
		//Response 
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(bi)
				.when()
				.post("http://localhost:3000/apistudents");
		System.out.println("Response code is"+res.statusCode());
		System.out.println("Response is"+res.asString());
				

	}

}
