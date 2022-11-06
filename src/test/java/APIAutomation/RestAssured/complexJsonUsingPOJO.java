package APIAutomation.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class complexJsonUsingPOJO {

	public static void main(String[] args) {
		//Address information set value
		AddressInformation ai = new AddressInformation();
		ai.setWardnum("100");
		ai.setBuilding("2nd");
		ai.setHousenum("10/2");
		ai.setSector("7");
		ai.setAdresstype("Primary");
		
		//BAsicInformation Set value
		ComplexJsonBasicInformation bi = new ComplexJsonBasicInformation();
		bi.setFirstname("Tushar");
		bi.setDesignation("QA");
		bi.setLastname("joshi");
		bi.setId("TJ_12");
		
		//passing AdressInformation reference in BasicInformation Address Key
		bi.setAddress(ai);
		
		Response res =
				given()
				.contentType(ContentType.JSON)
				.body(bi)
				.when()
				.post("http://localhost:3000/apistudents");
		System.out.println("Response code is "+res.statusCode());
		System.out.println(res.asString());
	}

}
