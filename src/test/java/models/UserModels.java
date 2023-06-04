package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModels {

	private String email;
	private String firstName;
	private String lastName;
	private String password;
	@JsonProperty("access_token")
	private String accessToken;
	private String userID;
	
	public UserModels() {} //we create this default constructor for the deserialization process
	
	
	public UserModels(String email, String firstName, String lastName, String password) { //we create this method to set values by constructor .. for register testcases
		this.email=email;
		this.firstName=firstName;
		this.lastName=lastName;
		this.password=password; 
	}
	
	public UserModels(String email,  String password) { //we create this method to set values by constructor .. for login testcases
		this.email=email;
		this.password=password; 
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@JsonProperty("access_token")
	public String getaccessToken() {
		return accessToken;
	}
	
	@JsonProperty("access_token")
	public void setaccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

}
