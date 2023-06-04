package APIs;

import static io.restassured.RestAssured.given;

import base.Specs;
import data.Route;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.TodoModels;

public class TodoAPI {


	public static Response addTodo(TodoModels todo, String access_token) {

		return given()
				.spec(Specs.getReqSpecs())
				.body(todo)
				.auth().oauth2(access_token)

				.when().post(Route.TASKS_ROUTE)
				.then().log().all().extract().response();
		
		
	}

public static Response getTodo(String access_token, String taskID) {
	
	return given()
			.spec(Specs.getReqSpecs())
			.auth().oauth2(access_token)

			.when().get(Route.TASKS_ROUTE+taskID) //must be the id of existed todo on the website
			.then()
			.log().all().extract().response();
}

public static Response deleteTodo(String access_token, String taskID) {
	
	return given()
			.spec(Specs.getReqSpecs())

			.auth().oauth2(access_token)

			.when().delete(Route.TASKS_ROUTE+taskID) 
			.then().log().all().extract().response();
}
}
