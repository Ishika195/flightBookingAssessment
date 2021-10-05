package com.example.flightBooking;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Column(unique=true)
	String airlineName;
	long contactNo;
	String airlineAddress;
	@OneToMany(cascade = CascadeType.ALL)
	@NotNull
	Set<Flight> flights;

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Flight flight) {
		flights.add(flight);
		//this.flights = flights;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getAirlineAddress() {
		return airlineAddress;
	}

	public void setAirlineAddress(String airlineAddress) {
		this.airlineAddress = airlineAddress;
	}
}
