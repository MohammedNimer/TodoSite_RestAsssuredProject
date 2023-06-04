package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoModels {

	@JsonProperty("isCompleted")
	private Boolean isCompleted;
	@JsonProperty("_id")
	private String id;
	private String item;
	private String userID;
	private String createdAt;
	@JsonProperty("__v")
	private String v;
	
	public TodoModels() {};
	
	public TodoModels(String item, Boolean isCompleted) {
		this.item=item;
		this.isCompleted=isCompleted;
	}
	
	public Boolean getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	
	

}
