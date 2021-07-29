package tests;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import org.apache.commons.io.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SoapXmlRequest {
	
	@Test
	public void validateSoapXML() throws Exception {
		File file=new File("./TestData/Add.xml");
		if(file.exists()) {
			System.out.println("File Exist");
		}
		FileInputStream fis = new FileInputStream(file);
		String reqbody = IOUtils.toString(fis, "UTF-8");
		baseURI = "http://www.dneonline.com/";
		given().contentType("text/xml").accept(ContentType.XML).body(reqbody).
		when().post("/calculator.asmx").
		then().statusCode(200).log().all().
		and().body("//*:AddResult.text()", equalTo("143"));	
	}
	

}
