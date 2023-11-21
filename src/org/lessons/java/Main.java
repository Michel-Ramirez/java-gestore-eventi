package org.lessons.java;

import java.util.Scanner;

import org.lessons.java.eventmanager.Event;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);

		try {

			System.out.println("Inserisci nuovo evento");
			System.out.println("--------------------------\n");

			System.out.print("Nome evento: ");
			String title = in.nextLine();

			System.out.print("Data del evento es.(dd-mm-yyyy): ");
			String eventDate = in.nextLine();

			System.out.print("Numero massimo di posti: ");
			String strSeats = in.nextLine();
			int seats = Integer.valueOf(strSeats);

			Event e = new Event(title, eventDate, seats);

			System.out.println("Vuoi prenotare un posto?: \n" + "y - Si" + " / " + "n - No");
			String userChoose = in.nextLine().toLowerCase();

			if (userChoose.equals("y")) {

				System.out.print("Quante prenotazioni vuoi fare?: ");
				String strNbooking = in.nextLine();
				int nBooking = Integer.valueOf(strNbooking);

				if (nBooking > 1) {
					for (int x = 0; x < nBooking; x++) {
						e.booking(eventDate);
					}

					System.out.println();
					System.out.println("+---------------------------------+");
					System.out.println("| Prenotazione andata a buon fine |");
					System.out.println("+---------------------------------+");
					System.out.println();
					System.out.println("+-----------------------------------+");
					System.out.println("Hai prenotato: " + nBooking + " posti " + "per l'evento: " + "\n" + e.getTitle()
							+ " del " + e.getDate());
					System.out.println("+-----------------------------------+");
					System.out.println();
					System.out.println("Ci sono ancora: " + e.availableSeats() + "posti disponibili");
				} else if (nBooking > e.availableSeats()) {
					System.out.println("Spiacente non ci sono posti a sufficienza \n" + "Rimangono: "
							+ e.availableSeats() + " posti");

				} else {
					System.out.println("Attenzione valore non valido");
				}

			} else
				return;

			System.out.println();
			System.out.print("Vuoi disdire una prenotazione?" + "\n" + "y - Si" + " / " + "n - No");
			String strCancelBook = in.nextLine().toLowerCase();

			if (strCancelBook.equals("y")) {

				System.out.println("Quante prenotazioni vuoi disdire?");
				String strCancel = in.nextLine();
				int cancelBookInt = Integer.valueOf(strCancel);

				if (cancelBookInt <= e.getPlaceReserved()) {

					e.cancellingReserv(cancelBookInt);
					System.out.println("+-----------------------------------------+");
					System.out.println("Prenotazione/i cancellata/e correttamente");
					System.out.println("+-----------------------------------------+");
					System.out.println();
					System.out.println("Totale posti prenotati: " + e.getPlaceReserved() + " Posti disponibili: "
							+ e.availableSeats());
				} else if (cancelBookInt > e.getPlaceReserved()) {
					System.err.println("Errore, non ci sono sufficienti prenotazioni");
				}

			}

//			--------| TEST |-----------
//			e.booking("28-11-2023");
//			System.out.println(e);
//			e.cancellingReserv("28-11-2023");
//			System.out.println(e);

		} catch (

		Exception e) {
			System.err.println("Errore: " + e.getMessage());
		} finally {

		}

	}

}
