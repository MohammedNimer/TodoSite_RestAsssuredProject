package APIs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import base.Specs;
import data.Route;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.UserModels;

public class UserAPI {

	public static Response register(UserModels user) {
		
		return given()
				
		.spec(Specs.getReqSpecs())
		.body(user)
		
		.when().post(Route.REGISTER_ROUTE)
		.then()
		.log().all()
		.extract().response();
	}
	
	public static Response login(UserModels user) {
		
		return given()
				.spec(Specs.getReqSpecs())
				.body(user)
				.when().post(Route.LOGIN_ROUTE)
				.then().log().all().extract().response();
	}
}
