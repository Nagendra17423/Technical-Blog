package com.tech.blog.entities;

import java.sql.Time;
import java.sql.Timestamp;

public class Entity {

	private String name;
	private String password;
	private String about;
	private String email;
	private String gender;
	private String date;
	private String profile;
private int User_id;

	public int getUser_id() {
	return User_id;
}

public void setUser_id(int user_id) {
	User_id = user_id;
}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String string) {
		this.date = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
