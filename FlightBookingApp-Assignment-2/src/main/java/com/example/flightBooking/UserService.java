package com.example.flightBooking;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	FlightRepository flightrepository;
	@Autowired
	TicketRepository ticketRepository;
	
	Flight searchFlight(Flight flight) {
		return flightrepository.findByFlightId(flight.getFlightId());
	}
	
	Ticket getTicket(int pnr) {
		return ticketRepository.findByPnr(pnr);
	}
	
	String addTicket(Ticket ticket,int flightId) {
		Random r = new Random();
		int pnr = 100000 + (int)(r.nextFloat() * 899900);
		if(flightrepository.findByFlightId(flightId)!=null)
		{
			ticket.setFlightId(flightId);
			ticket.setPnr(pnr);
			ticketRepository.save(ticket);
			return "ticket booked successfully for flight id = "+flightId;
		}
		else {
			return "Flight does not exist";
		}
	}

	List<Ticket> getHistory(String email) {
		return ticketRepository.findByEmail(email);
	}

	public void deleteTicket(int pnr) {
		Ticket ticket = getTicket(pnr);
		ticketRepository.delete(ticket);
	}
	
}
