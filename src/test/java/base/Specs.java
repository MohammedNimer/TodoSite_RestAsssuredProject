package base;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specs {

	public static RequestSpecification getReqSpecs() {
		return given().baseUri("https://todo.qacart.com/")
				.contentType(ContentType.JSON);
	}
}
