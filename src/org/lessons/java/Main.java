package org.lessons.java;

import org.lessons.java.eventmanager.Event;

public class Main {

	public static void main(String[] args) throws Exception {

		try {

			Event e = new Event("Games Week", "28-11-2023", 1000);

//			--------| TEST |-----------
//			e.booking("28-11-2023");
//			System.out.println(e);
//			e.cancellingReserv("28-11-2023");
//			System.out.println(e);

		} catch (Exception e) {
			System.err.println("Errore: " + e.getMessage());
		} finally {

		}

	}

}
