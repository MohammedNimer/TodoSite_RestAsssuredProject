package steps;

import com.github.javafaker.Faker;

import APIs.UserAPI;
import io.restassured.response.Response;
import models.UserModels;

public class UserSteps {

	public static UserModels generateUser() {
		
		Faker faker=new Faker();
		
		String email=faker.internet().emailAddress();
		String firstName=faker.name().firstName();
		String lastName=faker.name().lastName();
		String password = "12345678";
		
		UserModels user=new UserModels(email, firstName, lastName, password);
		return user;
	}
	
	
	public static UserModels getRegisteredUser() {
		
		UserModels user = generateUser();
		UserAPI.register(user);
		
		return user;
	}
	
	public static String getUserToken() {
		UserModels user=generateUser();
		Response respo =UserAPI.register(user);
		return respo.body().path("access_token");
				
		
	}
}
