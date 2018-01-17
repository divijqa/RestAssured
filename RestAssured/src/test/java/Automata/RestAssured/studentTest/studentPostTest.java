package Automata.RestAssured.studentTest;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import Automata.RestAssured.studentModel.studentDetails;

public class studentPostTest {
	
	@BeforeClass
	public static void init(){
		
		RestAssured.baseURI ="http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";
	}
	
	@Test
	public void postOneStudent(){
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Testing");
		courses.add("Automation");
		
		studentDetails student = new studentDetails();
		student.setFirstName("huge");
		student.setLastName("jackman");
		student.setEmail("huge.jackman@testschool.org");
		student.setProgramme("SQA");
		student.setCourses(courses);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post();
		System.out.println(response.body().prettyPeek());
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
	
	}
	
	@Test
	public void postSecondStudent(){
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Testing");
		courses.add("Automation");
		
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
		.post();
		System.out.println(response.body().prettyPeek());
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
	
	}
}
