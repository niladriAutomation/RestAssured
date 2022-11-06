package APIAutomation.RestAssured;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class POSTcomplex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// First we need to create inner Object
		JSONObject inner = new JSONObject();
		inner.put("Name", "Niladri Das");
		inner.put("id", "01");
		
		JSONObject outer = new JSONObject();
		outer.put("Address", " CA Road");
		outer.put("sector", "5");
		outer.put("Details", inner);
		
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(outer.toString())
				.when()
				.post("http://localhost:3000/apistudents");
		System.out.println(res.statusCode());
		System.out.println(res.asString());
		
				
				
		
		
		
		
		

	}

}
