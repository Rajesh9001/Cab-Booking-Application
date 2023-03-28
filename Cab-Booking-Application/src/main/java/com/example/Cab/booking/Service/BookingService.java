package com.example.Cab.booking.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Cab.booking.Model.DriverDetails;
import com.example.Cab.booking.Model.User;

@Service
public class BookingService {

	@Autowired
	User user;

	@Autowired
	DriverDetails driverDetails;

	HashMap<String, String> map = new HashMap<>();
	boolean flag = false;
	List<User> userList1 = null;
	List<DriverDetails> driverList1 = null;

	List<User> userList = new ArrayList<>();

	List<DriverDetails> driverList = new ArrayList<>();

	public void add_user(String user) {
		String[] userDetails = user.split(",");

		User user1 = new User(userDetails[0], userDetails[1], Integer.parseInt(userDetails[2]));
		userList.add(user1);

	}

	public List<User> getUsersList() {
		return userList;
	}

	public void add_driver(String driverName, String gender, int age, String vehicleName, String vehicleNumber, int x,
			int y) {

		DriverDetails driver = new DriverDetails(driverName, gender, age, vehicleName, vehicleNumber, x, y);

		driverList.add(driver);
	}

	public List<DriverDetails> getDriversList() {
		return driverList;
	}

	public List<String> ride() {

		add_user("Abhishek,M,23");
		add_user("Rahul,M,29");
		add_user("Nandini,F,22");

		add_driver("Driver1", "M", 22, "Swift", "KA-01-12345", 10, 1);
		add_driver("Driver2", "M", 23, "Swift", "KA-01-12345", 11, 10);
		add_driver("Driver3", "M", 25, "Swift", "KA-01-12345", 5, 3);

		map.put("Driver1", "Available");
		map.put("Driver2", "Available");
		map.put("Driver3", "Available");

		userList1 = getUsersList();
		driverList1 = getDriversList();

		List<List<String>> rideList = new ArrayList<>();

		rideList.add(find_ride("Abhishek", 0, 0, 20, 1));
		rideList.add(find_ride("Rahul", 10, 0, 15, 3));
		rideList.add(find_ride("Nandini", 15, 6, 20, 4));

		List<String> al = new ArrayList<>();

		for (List<String> ride : rideList) {
			boolean flag1 = false;
			for (String str : ride) {

				if (str.substring(0, 6).equalsIgnoreCase("Driver")) {
					al.add(str);
					flag1 = true;
				}

			}
			if (flag1 == false)
				al.add("No ride found");
		}
		return al;
	}

	public List<String> find_ride(String name, int sourceX, int sourceY, int destinationX, int destinationY) {

		double d = 0;
		List<String> find = new ArrayList<>();

		for (DriverDetails record : driverList1) {

			int x1 = record.getX();
			int y1 = record.getY();

			int x2 = sourceX;
			int y2 = sourceY;

			d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

			String key = null;
			String value = null;
			
			if (d <= 5) {
				for (Map.Entry<String, String> entry : map.entrySet()) {
					key = entry.getKey();
					value = entry.getValue();

					if (record.getDriverName() == key && value == "Available") {

						System.out.println(key);
						find.add(key);
						map.put(key, "Unavailable");
						flag = true;
						break;
					} else
						flag = false;
				}
			} else if (d > 5) {
				System.out.println("No ride found");
				find.add("No ride found");
			}
			if (flag)
				break;

		}

		return find;
	}

}
