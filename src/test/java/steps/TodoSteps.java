package steps;

import com.github.javafaker.Faker;

import APIs.TodoAPI;
import io.restassured.response.Response;
import models.TodoModels;

public class TodoSteps {
	
	public static TodoModels generateTodo() {
		
		Faker faker=new Faker();

		String item=faker.book().title();
		Boolean isCompleted =false;
		TodoModels todo = new TodoModels(item, isCompleted);

		return todo;
		
	}

	public static String getTodoID(TodoModels todo,String access_token) {
		
		Response respo= TodoAPI.addTodo(todo, access_token);
		
		return respo.body().path("_id");
		
		
	}
}
