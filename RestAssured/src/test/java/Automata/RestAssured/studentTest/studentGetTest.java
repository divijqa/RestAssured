package Automata.RestAssured.studentTest;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;
public class studentGetTest {

	@BeforeClass
	public static void init(){
		
		RestAssured.baseURI ="http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";
	}
	
	@Test
	public void getAllStudentInformation(){
		/**
		 * given()
		 * set cookies,add auth,adding parameters, setting header info
		 * when()
		 * GET,POST,PUT,DELETE... etc
		 * Then()
		 * validate status code , extract response,extract headers,cookies, extract the response body
		 */
		
		Response response = given()
		.when()
	    .get("/list");
		System.out.println(response.body().prettyPrint());
		
		given()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
	}
	
	@Test
	 public void getStudentInfo(){
		
		Response response = given()
		//given()
		.when()
		.get("/2");
		System.out.println(response.body().prettyPrint());
		
		given()
		.when()
		.get("/2")
		.then()
		.statusCode(200);
	}
	
	@Test
	public void getStudentsFromFA(){
		Response response = given()
		.when()
		.get("/list?programme=Financial Analysis&limit=2");
		System.out.println(response.body().prettyPeek());
		
		Response response2 = given()
		.param("programme","Financial Analysis")
		.param("limit", 2)
		.when()
		.get("/list");
		System.out.println(response2.body().prettyPeek());
				
	}
	
	
}
