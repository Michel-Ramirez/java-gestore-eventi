package org.lessons.java.eventmanager;

import java.util.ArrayList;
import java.util.List;

public class EventProgram {

	private String title;
	private List<Event> eventList = new ArrayList<>();

	public EventProgram(String title, List<Event> eventList) throws Exception {

		setTitle(title);
		setEventList(eventList);
	}

	public EventProgram() {
		// TODO Auto-generated constructor stub
	}

	// GETTER & SETTER

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	// OTHERS METHODS

	public void addInEventList(Event value) {

		eventList.add(value);

	}

	// FILTRA NELLA LISTA E RESTITUISCE UNA NUOVA LISTA CON GLI EVENTI IN UNE
	// DETERMINATA DATA
	public List<Event> searchEventforDate(String date) {

		List<Event> eventListOnDate = new ArrayList<>();

		for (Event event : eventList) {
			if (event.getDate().equals(date)) {
				eventListOnDate.add(event);
			}
		}

		return eventListOnDate;
	}

	public int howManyElements() {

		int nElements = eventList.size();

		return nElements;
	}

	public void emptyList() {

		for (int x = 0; x < eventList.size(); x++) {
			eventList.remove(x);
		}

	}

	public List<String> getList() {

		List<String> list = new ArrayList<>();

		for (Event event : eventList) {
			String name = event.geteName();
			String date = event.getDate();
			String newString = name + "-" + date;
		}

		return list;
	}

	@Override
	public String toString() {

		List<String> list = new ArrayList<>();
		for (Event event : eventList) {
			String name = event.geteName();
			String date = event.getDate();
			list.add(date + " - " + name + "\n");
		}
		return "Lista di eventi: \n" + list;
	}

}
