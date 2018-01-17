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

public class studentPutTest {
	
	@BeforeClass
	public static void init(){
		
		RestAssured.baseURI ="http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";
	}
	
	@Test
	public void putOneStudent(){
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Testing");
		courses.add("Automation");
		courses.add("Performance");
		courses.add("API");
		
		studentDetails student = new studentDetails();
		student.setFirstName("huge");
		student.setLastName("jackman");
		student.setEmail("huge.jackman@test1.org");
		student.setProgramme("SQA");
		student.setCourses(courses);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/102");
		System.out.println(response.body().prettyPeek());
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/102")
		.then()
		.statusCode(200);
	
	}
	
	@Test
	public void putSecondStudent(){
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Testing");
		courses.add("Automation");
		courses.add("Performance");
		courses.add("API");
		
		studentDetails student = new studentDetails();
		student.setFirstName("Divj");
		student.setLastName("M");
		student.setEmail("divij.m@testschool.org");
		student.setProgramme("SQA");
		student.setCourses(courses);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/105");
		System.out.println(response.body().prettyPeek());
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/105")
		.then()
		.statusCode(200);
	
	}
}
