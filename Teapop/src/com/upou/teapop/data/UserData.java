package com.upou.teapop.data;

import com.upou.teapop.constants.DisplayConstants;

public class UserData {
	
	private int userId;
	
	private int accessLevel;
	
	private String firstName;
	
	private String lastName;

	private String position;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getDisplayName() {
		return this.firstName + DisplayConstants.SPACE + this.lastName;
	}


}
