package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Testone {
	@Test(enabled = false)
	public void test_1() {
		Response res=get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody().asString());
		System.out.println(res.asString());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		int statusCode=res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(enabled = false)
	public void test_2() {
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2")
		.then().statusCode(200).
		body("data[1].id", equalTo(8))
		.log().all();
	}

	@Test(enabled = false)
	public void get1() {
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2")
		.then().statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("George","Lindsay"))
		.log().all();
	}

	@Test(enabled = false)
	public void post() {
		baseURI = "https://reqres.in/api";
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject req = new JSONObject();
		req.put("name", "Jeevan");
		req.put("job", "QA");
		System.out.println(req.toJSONString());
		given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(req.toJSONString()).when().post("/users").then().statusCode(201).log().all();	
	}

	@Test(enabled = false)
	public void put() {
		baseURI = "https://reqres.in/api";
		JSONObject req = new JSONObject();
		req.put("name", "Geevan");
		req.put("job", "SQA");
		System.out.println(req.toJSONString());
		given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(req.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();	
	}
	
	@Test(enabled = false)
	public void patch() {
		baseURI = "https://reqres.in/api";
		JSONObject req = new JSONObject();
		req.put("name", "Geevon");
		req.put("job", "SQA");
		System.out.println(req.toJSONString());
		given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(req.toJSONString()).when().patch("/users/2").then().statusCode(200).log().all();	
	}
	
	@Test
	public void delete1() {
		baseURI = "https://reqres.in/api";
		when().delete("/users/2").then().statusCode(204).log().all();	
	}
}
