package com.example.issuecassandra;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "users")
public class Users {
	
	@Id
	private String userName;
	protected String		profileImage;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	@Override
	public String toString() {
		return "Users [userName=" + userName + ", profileImage=" + profileImage + ", profileImageBytes=]";
	}
	
	

}
