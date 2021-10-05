package com.example.flightBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/flight")
public class AdminController {
	@Autowired
	AdminService adminService;
	boolean isadmin = false;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/airline/register")
	String registerAirline(@RequestBody Airline airline) {
		if(isadmin) {
			adminService.addAirline(airline);
			return "Successfully added Airline";
		}
		else {
			return "login as admin to add new airline";
		}
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/admin/add")
	String addAdmin(@RequestBody Admin admin) {
		adminService.saveAdmin(admin);
		return "Admin details saved";
	}

	@PostMapping("/admin/login")
	Admin adminLogin(@RequestBody Admin adminDetails) {
		isadmin = true;
		return adminService.login(adminDetails);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/airline/inventory/add")
	String addInventory(@RequestBody Flight flight) {
		if(isadmin)
		return adminService.addFlight(flight);
		else return "login as admin to add new flights or schedule flights";
		// return "Flight added successfully";
	}

}
