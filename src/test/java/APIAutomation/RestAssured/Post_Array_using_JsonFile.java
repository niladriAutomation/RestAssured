package APIAutomation.RestAssured;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post_Array_using_JsonFile {

	public static void main(String[] args) throws FileNotFoundException {
		// JSON File Read
		File input = new File("../RestAssured/Array_JsonFile.json");
		FileReader reader = new FileReader(input);
		JSONTokener jsonreader = new JSONTokener(reader);
		JSONObject js = new JSONObject(jsonreader);

		// Random Number creation
		Random numcreate = new Random();
		Integer randomnumber = numcreate.nextInt();

		//passing Random number as a string in id variable of json data file 
		String jsondata = js.toString();
		jsondata=jsondata.replaceAll(Pattern.quote("{{id}}"), randomnumber.toString());

		//Scanner class to take i/p from user for fullname
		System.out.println("Enter Fullname");
		Scanner scannerobj = new Scanner(System.in);
		String fullname = scannerobj.next();
		jsondata=jsondata.replaceAll(Pattern.quote("{{fullname}}"), fullname);
		
		//Response
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(jsondata.toString())
				.when()
				.post("http://localhost:3000/apistudents");
		System.out.println("Response status code is "+res.statusCode());
		System.out.println("Response is "+res.asString());



	}

}
