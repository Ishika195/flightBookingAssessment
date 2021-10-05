package com.example.flightBooking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/flight")
public class UserController {
	
	@Autowired
	UserService userService;
	@PostMapping("/booking/{flightId}")
	String bookingFlight(@PathVariable int flightId,@RequestBody Ticket ticket ) {
		return userService.addTicket(ticket,flightId);
		//return "Successfully Booked";
	}
	
	@PostMapping("/search")
	Flight searchFlight(@RequestBody Flight flight) {
		return userService.searchFlight(flight);
	}
	
	@GetMapping("/ticket/{pnr}")
		Ticket getBookedTicketsByPnr(@PathVariable int pnr) {
		return userService.getTicket(pnr);
	}
	
	@GetMapping("/booking/history/{emailId}")
		List<Ticket> getPreviousTickets(@PathVariable String emailId) {
		
		return userService.getHistory(emailId);
	}
	
	@DeleteMapping("/booking/cancel/{pnr}")
		String cancelTicket(@PathVariable int pnr) {
			userService.deleteTicket(pnr);
			return "ticket with pnr = "+pnr+ " cancelled";
		}
}
