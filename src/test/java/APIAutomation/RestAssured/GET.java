package APIAutomation.RestAssured;
import static io.restassured.RestAssured.*;

import org.json.JSONArray;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GET 
{
	/**
	 * Rigorous Test :-)
	 * 
	 */
	public static void main(String[] args) {
		Response res = 
				given().contentType(ContentType.JSON)

				.when().get("http://localhost:3000/apistudents");
		System.out.println("Response is" + res.statusCode());
		System.out.println("Response is" + res.asString());
		




	}



}
