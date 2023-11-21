package org.lessons.java.eventmanager;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event {

	private LocalTime time;
	private BigDecimal price;

	public Concert(String eName, int totNumplaces, String date, String time, String price) throws Exception {
		super(eName, totNumplaces, date);

		setPrice(price);
		setTime(time);
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(String time) {

		this.time = timeFormatter(time);

	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(String value) {

		BigDecimal price = new BigDecimal(value);

		this.price = price;
	}

	// OTHER METHODS

	private LocalTime timeFormatter(String value) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime localTime = LocalTime.parse(value, formatter);

		return localTime;

	}

	@Override
	public String toString() {

		return "Concerto: " + getDate() + "-" + getTime() + "-" + geteName() + "-" + getPrice() + "€";
	}

}
