package APIAutomation.RestAssured;


import static io.restassured.RestAssured.*;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostArrayusingOrg_json {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject obj1 = new JSONObject();
		obj1.put("ward", "10");
		obj1.put("dept", "QA");
		JSONObject obj2 = new JSONObject();
		obj2.put("Building", "3rd");
		obj2.put("Floor", "5th");
		JSONArray js = new JSONArray();
		js.put( obj1);
		js.put( obj2);
		
		JSONObject obj = new JSONObject();
		obj.put("Name", "Niladri Das");
		obj.put("Adress", js);
		obj.put("id", "N_04");
		
		System.out.println(obj);
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(obj.toString())
				.when()
				.post(" http://localhost:3000/apistudents");
		System.out.println("Response code is "+res.statusCode());
		System.out.println("Response is "+res.asString());
		
		
		
		
		

	}

}
