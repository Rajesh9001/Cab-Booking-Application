package com.example.Cab.booking.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@Data
public class User{
	String userName;
	String gender;
	int age;
	List<User> userList= new ArrayList<>();
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String userName, String gender, int age) {
		super();
		this.userName = userName;
		this.gender = gender;
		this.age = age;
	}
	
	
	
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Users [userName=" + userName + ", gender=" + gender + ", age=" + age +  "]";
	}
	
	
	
}
