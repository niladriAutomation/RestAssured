package APIAutomation.RestAssured;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ArrayJSON_POJO {

	public static void main(String[] args) {
		// Address Infomration class is Array type declared in BasicInformation
		// two index Array is declared of that class
		//Inner Array
		AddressInformation[] address = new AddressInformation [2];
		
		//O th index Object and set values
		address[0] = new AddressInformation();
		address[0].setHousenum("12");
		address[0].setBuilding("8");
		address[0].setSector("1");
		address[0].setWardnum("700");
		address[0].setAdresstype("primary");
		//1 st index Object and set values
		address[1] = new AddressInformation();
		address[1].setHousenum("5");
		address[1].setBuilding("1");
		address[1].setSector("3");
		address[1].setWardnum("31");
		address[1].setAdresstype("secondary");
		//Outer Object
		BasicInformation bi = new BasicInformation();
		bi.setFirstname("Tushar");
		bi.setDesignation("QA");
		bi.setLastname("joshi");
		bi.setId("TJ_10");
		//passing AdressInformation reference in BasicInformation Address Key
		bi.setAddress(address);
		
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
