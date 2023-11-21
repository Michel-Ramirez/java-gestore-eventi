package org.lessons.java.eventmanager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {

	private String eName;
	private String date;
	private int totNumplaces;
	private int placeReserved = 0;

	private LocalDate today = LocalDate.now();

	public Event(String eName, int totNumplaces, String date) throws Exception {

		seteName(eName);
		setDate(date);
		setTotNumplaces(totNumplaces);

	}

	// GETTER & SETTER

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getDate() {

		return date;
	}

	public void setDate(String date) throws Exception {

		if (!dateFormatter(date).isAfter(today)) {
			throw new Exception("The date entered has already passed");
		}

		this.date = date;
	}

	public int getTotNumplaces() {
		return totNumplaces;
	}

	private void setTotNumplaces(int totNumplaces) throws Exception {

		if (totNumplaces < 0) {
			throw new Exception("The number of places must be positive");
		}

		this.totNumplaces = totNumplaces;
	}

	public int getPlaceReserved() {
		return placeReserved;
	}

	private void setPlaceReserved(int placeReserved) {
		this.placeReserved = placeReserved;
	}

	// OTHER METHODS

	private LocalDate dateFormatter(String value) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate newDateFormated = LocalDate.parse(value, formatter);

		return newDateFormated;

	}

	public void booking(String bookingDate) throws Exception {

		if (!dateFormatter(bookingDate).isAfter(today)) {
			throw new Exception("the booking date has already passed");

		} else {
			placeReserved++;
		}

	}

	public void cancellingReserv(int value) throws Exception {

		if (placeReserved == 0 || value < 0) {
			throw new Exception("value not valid or actually no exist place reserved");
		} else {
			placeReserved -= value;
		}

	}

	public int availableSeats() {

		int availableSeats = totNumplaces - placeReserved;

		return availableSeats;

	}

	@Override
	public String toString() {

		return "Evento: " + getDate() + "-" + geteName() + "\n" + "Posti riservati: " + placeReserved;
	}

}
