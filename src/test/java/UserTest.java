import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


import java.util.HashMap;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import APIs.UserAPI;
import data.Errors;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.ErrorMessage;
import models.UserModels;
import steps.UserSteps;

public class UserTest {

	@Test(description = "Register To The Site Successfully")
	public void positiveRegister() {
		
		UserModels user= UserSteps.generateUser();
		
		Response responsee = UserAPI.register(user);
		
		UserModels returnedUser= responsee.body().as(UserModels.class);

		assertThat(responsee.statusCode(), equalTo(201));
		assertThat(returnedUser.getFirstName(), equalTo(user.getFirstName()));

	}
	
	@Test(description = "Register To The Site Unsuccessfully")
	public void negativeRegister() {//register with an already registered email

		UserModels user= UserSteps.getRegisteredUser(); 

		Response respo= UserAPI.register(user);
		
		ErrorMessage returnedError=respo.body().as(ErrorMessage.class);
		
		assertThat(respo.statusCode(),equalTo(400));
		assertThat(returnedError.getMessage(),equalTo (Errors.EMAIL_ALREADY_REGISTERED));	
	}
	@Test(description = "Login To The Site Successfully")
	public void positiveLogin() {

		UserModels user= UserSteps.getRegisteredUser();
		UserModels loginData=new UserModels(user.getEmail(), user.getPassword());

		Response respo= UserAPI.login(loginData);
		
		UserModels returnedUser=respo.body().as(UserModels.class);
		
		assertThat(respo.statusCode(), equalTo(200));
		assertThat(returnedUser.getFirstName(), equalTo(user.getFirstName()));

	}

	@Test(description = "Login To The Site Unsuccessfully")
	public void negaiveLogin() { //with wrong password

		UserModels user= UserSteps.getRegisteredUser();
		UserModels loginData=new UserModels(user.getEmail(), "1234");

		Response respo= UserAPI.login(loginData);

		
		ErrorMessage returnedError=respo.body().as(ErrorMessage.class);
		
		assertThat(returnedError.getMessage(), equalTo(Errors.INCORRECT_PASSWORD));
		assertThat(respo.statusCode(), equalTo(400));

	}
}
