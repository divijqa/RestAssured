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

public class studentPatchTest {

	@BeforeClass
	public static void init(){
		
		RestAssured.baseURI ="http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";
	}
	@Test
	public void patchOneStudent(){
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Testing");
		courses.add("Automation");
		courses.add("PerformanceEngineer");
		courses.add("APITester");
		
		studentDetails student = new studentDetails();
		student.setFirstName("huge");
		student.setLastName("jackman");
		student.setEmail("huge.jackman@qatester.org");
		student.setProgramme("SQA");
		student.setCourses(courses);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/102");
		System.out.println(response.body().prettyPeek());
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/102")
		.then()
		.statusCode(200);
	
	}
	
	@Test
	public void patchSecondStudent(){
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Testing");
		courses.add("Automation");
		courses.add("PerformanceEngineer");
		courses.add("APITester");
		
		studentDetails student = new studentDetails();
		student.setFirstName("Divj");
		student.setLastName("M");
		student.setEmail("divij.m@qatestschool.org");
		student.setProgramme("SQA");
		student.setCourses(courses);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/105");
		System.out.println(response.body().prettyPeek());
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/105")
		.then()
		.statusCode(200);
	
	}
	
}
