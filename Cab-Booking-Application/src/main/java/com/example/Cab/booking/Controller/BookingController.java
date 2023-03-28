package com.example.Cab.booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Cab.booking.Service.BookingService;

@RestController
public class BookingController {
		
	@Autowired
	BookingService bookingService;
	
    @RequestMapping("/welcome")
    public List<String> welcome() {
        return bookingService.ride();
    }
    
}
