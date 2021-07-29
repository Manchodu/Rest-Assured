package tests;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LocalAPITest {
	
	@Test(enabled = false)
	public void getTest() {
		baseURI = "http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();	
	}
	
	@Test(enabled = false)
	public void postTest() {
		JSONObject jobject=new JSONObject();
		jobject.put("firstName", "Jeevan");
		jobject.put("lastName", "V");
		jobject.put("subjectId", "3");
		jobject.put("id", "3");
		System.out.println(jobject);
		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(jobject.toJSONString()).when().post("/users").then().statusCode(201);
	}
	
	@Test(enabled = false)
	public void putTest() {
		JSONObject jobject=new JSONObject();
		jobject.put("firstName", "JeevanKumar");
		jobject.put("lastName", "Vangumalli");
		jobject.put("subjectId", "3");
		System.out.println(jobject);
		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(jobject.toJSONString()).when().put("/users/3").then().statusCode(200);
	}
	
	@Test(enabled = false)
	public void patchTest() {
		JSONObject jobject=new JSONObject();
		jobject.put("firstName", "Jeevan Kumar");
		System.out.println(jobject);
		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(jobject.toJSONString()).when().patch("/users/3").then().statusCode(200);
	}
	
	//@Test
	public void deleteTest() {
		baseURI = "http://localhost:3000";
		when().delete("/users/3").then().statusCode(200).log().all();	
	}
}
