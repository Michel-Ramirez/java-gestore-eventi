package org.lessons.java.eventmanager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {

	private String title;
	private String date;
	private int totNumplaces;
	private int placeReserved = 0;

	private LocalDate today = LocalDate.now();

	public Event(String title, String date, int totNumplaces) throws Exception {

		setTitle(title);
		setDate(date);
		setTotNumplaces(totNumplaces);

	}

	// GETTER & SETTER

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {

		return date;
	}

	public void setDate(String date) throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		// PARSE DEL DATO IN MODO DA CREARE IL FORMATO CORRETTO
		LocalDate userDate = LocalDate.parse(date, formatter);

		// PRENDO LA DATA ODIERNA E LA FORMATTO IN STRINGA

		if (!userDate.isAfter(today)) {
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

	private LocalDate dateFormatter(String value) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate newDateFormated = LocalDate.parse(value, formatter);

		return newDateFormated;

	}

	public void booking(String bookingDate) throws Exception {

		if (!dateFormatter(bookingDate).isAfter(today)) {
			throw new Exception("the booking date has already passed");

		} else if (placeReserved == totNumplaces) {
			throw new Exception("There are no more places");

		} else {
			placeReserved++;
		}

	}

	public void cancellingReserv(String bookingDate) throws Exception {

		if (!dateFormatter(bookingDate).isAfter(today) || placeReserved == 0) {
			throw new Exception("the booking date has already passed");
		} else if (placeReserved == 0) {
			throw new Exception("There are no reservations");
		} else {
			placeReserved--;
		}

	}

	@Override
	public String toString() {

		return "Evento: " + getDate() + "-" + getTitle() + "\n" + "Posti riservati: " + placeReserved;
	}

}
