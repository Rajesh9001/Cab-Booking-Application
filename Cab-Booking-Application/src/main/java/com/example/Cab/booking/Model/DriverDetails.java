package com.example.Cab.booking.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Component
public class DriverDetails{
	
	private String driverName;
	String gender;
	int age;
	
	String vehicleName;
	String vehicleNumber;
	
	private int x;    
	private int y;
	
	
	List<DriverDetails> driverList= new ArrayList<>();
	
	
	public DriverDetails(String driverName, String gender, int age, String vehicleName, String vehicleNumber, int x,
			int y) {
		
		super();
		this.setDriverName(driverName);
		this.gender = gender;
		this.age = age;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.setX(x);
		this.setY(y);
	}


	public DriverDetails() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "DriverDetails [driverName=" + getDriverName() + ", gender=" + gender + ", age=" + age + ", vehicleName="
				+ vehicleName + ", vehicleNumber=" + vehicleNumber + ", x=" + getX() + ", y=" + getY() + "]";
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	
}
