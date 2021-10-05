package com.example.flightBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	FlightRepository repository;
	@Autowired
	AirlineRepository airlineRepository;
	@Autowired
	AdminRepository adminRepository;

	String addFlight(Flight flight) {
		Airline airline = new Airline();
		if(airlineRepository.findByAirlineName(flight.getAirline())!=null) {
			repository.save(flight);
			return "flight added to airline";
		}
		else {
			return "airline does not exist";
		}
	}

	public void addAirline(Airline airline) {
		airlineRepository.save(airline);
	}

	public Admin login(Admin adminDetails) {
		Admin temporaryAdmin = adminRepository.findByEmail(adminDetails.getEmail());
		String password1 = temporaryAdmin.getPassword();
		System.out.println(password1);
		if(password1.equals(adminDetails.getPassword())) {
			return temporaryAdmin;
		}
		else return null;
	}

	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
	}
}
