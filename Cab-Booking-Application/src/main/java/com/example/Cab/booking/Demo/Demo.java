package com.example.Cab.booking.Demo;

import java.util.*;

class User{
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
	
	
	public void add_user(String user) {
		String[] userDetails=user.split(",");
		
		userName=userDetails[0];
		gender=userDetails[1];
		age=Integer.parseInt(userDetails[2]);
		
		
		User user1 = new User(userName,gender,age);
		userList.add(user1);
		
	}
	
	public List<User> getUsersList()
	{
		return userList;
	}


	@Override
	public String toString() {
		return "Users [userName=" + userName + ", gender=" + gender + ", age=" + age +  "]";
	}
	
	
	
}



class DriverDetails{
	
	String driverName;
	String gender;
	int age;
	
	String vehicleName;
	String vehicleNumber;
	
	int x;    
	int y;
	
	
	List<DriverDetails> driverList= new ArrayList<>();
	
	
	public DriverDetails(String driverName, String gender, int age, String vehicleName, String vehicleNumber, int x,
			int y) {
		
		super();
		this.driverName = driverName;
		this.gender = gender;
		this.age = age;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.x = x;
		this.y = y;
	}


	public DriverDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void add_driver(String driverName, String gender, int age, String vehicleName, String vehicleNumber, int x,
			int y) {
		this.driverName = driverName;
		this.gender = gender;
		this.age = age;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.x = x;
		this.y = y;
		
		DriverDetails driver= new DriverDetails(driverName,gender,age,vehicleName,vehicleNumber,x,y);
		
		driverList.add(driver);
	}    
	
	public List<DriverDetails> getDriversList()
	{
		return driverList;
	}


	@Override
	public String toString() {
		return "DriverDetails [driverName=" + driverName + ", gender=" + gender + ", age=" + age + ", vehicleName="
				+ vehicleName + ", vehicleNumber=" + vehicleNumber + ", x=" + x + ", y=" + y + "]";
	}
	
	
}


public class Demo {
	
	static HashMap<String, String> map= new HashMap<>();
	static List<User> userList1=null;
	static List<DriverDetails> driverList1=null;
	boolean flag=false;
	
	  
    public static void main(String args[]) {
    	User user = new User();
    	
    	user.add_user("Abhishek,M,23"); 
    	user.add_user("Rahul,M,29"); 
    	user.add_user("Nandini,F,22") ;

    	
    	
    	DriverDetails driver= new DriverDetails();
    	
    	driver.add_driver("Driver1", "M", 22 ,"Swift", "KA-01-12345",10,1);
    	driver.add_driver("Driver2", "M", 23 ,"Swift", "KA-01-12345",11,10);
    	driver.add_driver("Driver3", "M", 25 ,"Swift", "KA-01-12345",5,3);
    	driver.add_driver("Driver4", "M", 25 ,"Swift", "KA-01-12345",6,3);
    	
    	map.put("Driver1", "Available");
    	map.put("Driver2", "Available");
    	map.put("Driver3", "Available");
    	
    	
    	userList1=user.getUsersList();
    	driverList1=driver.getDriversList();
    	
    	
    	Demo demo=new Demo();
//    	demo.find_ride("Nandini" ,15,6,20,4);
//    	demo.find_ride("Abhishek",0,0,20,1);
//    	demo.find_ride("Rahul" ,10,0,15,3);
    	
    


    	
    }

	public  List<String> find_ride(String name, int sourceX, int sourceY, int destinationX, int destinationY, List<com.example.Cab.booking.Model.DriverDetails> driverList12) {
		
		int dcount=0,unavailable=0, d=0;
		List<String> find= new ArrayList<>();
		
		System.out.println("HII");
		
			for(com.example.Cab.booking.Model.DriverDetails record:driverList12) {
	    	dcount++;
	    	
	    	int x1= record.getX();
	    	int y1= record.getY();
	    	
	    	int x2=sourceX;
	    	int y2=sourceY;
	    	
	    	 d= (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	    	
	    	
	    
	    	String key=null;
	    	String value;
	    	if(d<=5)
	    	{
	    		for (Map.Entry<String, String> entry : map.entrySet())
		    	{
	    			key=entry.getKey();
		    	   value = entry.getValue();

		    	 if(record.getDriverName()==key && value == "Available") { 
    		 
		    		 System.out.println(key);
		    		 find.add(key);
		    		 map.put(key,"Unavailable");
		    		 flag=true;
		    		 break;
		    		 }
		    	 else
		    		 flag=false;
		    	}	
	    	}
	    	else if(d>5) // && dcount==driverList1.size()-1)  // && value.equalsIgnoreCase("Unavailable")
	    	{ 
	    		System.out.println("No ride found");
	    		find.add("No ride found");
	    	}
	    	if(flag) break;
	    	
	    	
//	    	if(d>5) {
//	    		dcount++;
//	    		continue;
//	    	}
	    	
//	    	 if(d>5 ){ System.out.println("No ride found");}
         
	    	
	    }
	    
	       return find;  
	}


}






//
//class Driver{
//	String driverName;
//	String gender;
//	int age;
//	
//	public Driver(String driverName, String gender, int age) {
//		super();
//		this.driverName = driverName;
//		this.gender = gender;
//		this.age = age;
//	}
//}
//
//
//
//class Vehicle{
//	String vehicleName;
//	String vehicleNumber;
//	
//	public Vehicle(String vehicleName, String vehicleNumber) {
//		super();
//		this.vehicleName = vehicleName;
//		this.vehicleNumber = vehicleNumber;
//	}	
//}
//
//
//class Point{
//	private double x;    
//	private double y;    
//
//
//	public Point(double initialX, double initialY) {
//	    x = initialX;
//	    y = initialY;
//	}
//
//
//	public Point() {
//	    x = 0;
//	    y = 0;
//	}
//
//
//	public double getX() {
//	    return x;
//	}
//
//
//	public double getY() {
//	    return y;
//	}
//
//}

