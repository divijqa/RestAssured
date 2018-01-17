package Automata.RestAssured.studentTest;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import Automata.RestAssured.studentModel.studentDetails;

import static com.jayway.restassured.RestAssured.*;

public class studentDeleteTest {
	@BeforeClass
	public static void init(){
		
		RestAssured.baseURI ="http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";
	}
	
	@Test
	public void deleteStudent105(){
		Response response = given()
		.contentType(ContentType.JSON)
		.when()
		.delete("/105");
		System.out.println(response.body().prettyPeek());
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.delete("/105")
		.then()
		.statusCode(204);
	
	}
}
