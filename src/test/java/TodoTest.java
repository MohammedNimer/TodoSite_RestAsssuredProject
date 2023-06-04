import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;

import org.testng.annotations.Test;

import APIs.TodoAPI;
import data.Errors;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.ErrorMessage;
import models.TodoModels;
import steps.TodoSteps;
import steps.UserSteps;

public class TodoTest {

	@Test(description = "Adding Todo Successfully")
	public void positiveAddTodo() {

		
		TodoModels todo=TodoSteps.generateTodo();
		String access_token = UserSteps.getUserToken();

		Response respo = TodoAPI.addTodo(todo, access_token);
		
		TodoModels returnedTodo=respo.body().as(TodoModels.class);
		
		assertThat(returnedTodo.getItem(), equalTo(todo.getItem()));
		assertThat(respo.statusCode(), equalTo(201));

	}
	
	@Test(description = "Adding Todo Unsuccessfully")
	public void negativeAddTodo() { //with todo name less than 3 characters
		
		TodoModels todo=new TodoModels("d",false);
		String access_token = UserSteps.getUserToken();

		Response respo = TodoAPI.addTodo(todo, access_token);

		
		ErrorMessage returnedError=respo.body().as(ErrorMessage.class);
		
		assertThat(returnedError.getMessage(), equalTo(Errors.ITEM_LENGTH_MUST_BE_MORE_THAN_3_CHARACTERS));
		assertThat(respo.statusCode(), equalTo(400));

	}
	
	@Test(description = "Getting Todo Successfully")
	public void getTodo() {
		
		String access_token = UserSteps.getUserToken();
		TodoModels todo =TodoSteps.generateTodo();
		String taskID =TodoSteps.getTodoID(todo, access_token);
		
		Response respo= TodoAPI.getTodo(access_token, taskID);
		
		TodoModels returnedTodo=respo.body().as(TodoModels.class);
		
		assertThat(returnedTodo.getItem(), equalTo(todo.getItem()));
		assertThat(respo.statusCode(), equalTo(200));

	}
	
	@Test(description = "deleting Todo Successfully")
	public void deleteTodo() {
		
		String access_token = UserSteps.getUserToken();
		TodoModels todo =TodoSteps.generateTodo();
		String taskID =TodoSteps.getTodoID(todo, access_token);

		Response respo= TodoAPI.deleteTodo(access_token, taskID);
		
		TodoModels returnedTodo=respo.body().as(TodoModels.class);
		
		assertThat(returnedTodo.getItem(), equalTo(todo.getItem()));
		assertThat(respo.statusCode(), equalTo(200));

	}
}
