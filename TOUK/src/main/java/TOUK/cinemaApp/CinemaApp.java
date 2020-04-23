package TOUK.cinemaApp;

import TOUK.cinemaApp.api.ReservationController;
import TOUK.cinemaApp.data.ScreeningsSchedule;
import TOUK.cinemaApp.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class CinemaApp {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.of(2020, 4, 23, 16, 30);
        LocalDateTime time2 = LocalDateTime.of(2020, 4, 20, 15, 10);
        LocalDateTime time3 = LocalDateTime.of(2020, 4, 20, 15, 00);
        LocalDateTime time4 = LocalDateTime.of(2020, 4, 20, 17, 30);
        Room room1 = new Room(10, 10, 1);
        Room room2 = new Room(15, 15,2);
        Movie movie1 = new Movie("tytul1", 120);
        Movie movie2 = new Movie("aytulik 2", 135);
        Movie movie3 = new Movie("lalalal", 95);

        Screening screening1 = new Screening(movie1, room1, time, new boolean[room1.getRows()][room1.getPlaces()]);
        Screening screening2 = new Screening(movie2, room2, time, new boolean[room2.getRows()][room2.getPlaces()]);
        Screening screening3 = new Screening(movie3, room1, time2, new boolean[room1.getRows()][room1.getPlaces()]);
        Screening screening4 = new Screening(movie1, room2, time2, new boolean[room2.getRows()][room2.getPlaces()]);

        ScreeningsSchedule screeningsSchedule = new ScreeningsSchedule();
        screeningsSchedule.add(screening1);
        screeningsSchedule.add(screening2);
        screeningsSchedule.add(screening3);
        screeningsSchedule.add(screening4);
        Ticket[] tickets1 = new Ticket[3];
        Ticket ticket1 = new Ticket(TicketType.adult);
        Ticket ticket2 = new Ticket(TicketType.student);
        Ticket ticket3 = new Ticket(TicketType.child);
        tickets1[0] = ticket1;
        tickets1[1] = ticket2;
        tickets1[2] = ticket3;
        Seat seat1 = new Seat(1,3);
        Seat seat2 = new Seat(1,4);
        Seat seat3 = new Seat(1,5);
        Seat seat4 = new Seat(2,1);
        Seat[] seats1 = new Seat[3];
        seats1[0] = seat1;
        seats1[1] = seat2;
        seats1[2] = seat3;
        ReservationController reservationController = new ReservationController();
        if (reservationController.makeReservation(screening1,seats1,"lalala",tickets1, "kośo")) {
            System.out.println("Reservation made");
            System.out.println("Cost:" + reservationController.getReservation(0).getCost());
            System.out.println(reservationController.getReservation(0).getPersonSurname());
        }
        else
            System.out.println("nie działa");
        Ticket[] tickets2 = new Ticket[1];
        tickets2[0] = ticket1;
        Seat[] seats2 = new Seat[1];
        seats2[0] = seat4;
        if (reservationController.makeReservation(screening1, seats2, "koko", tickets2, "loko")) {
            System.out.println("res 2 made");
            System.out.println("Cost:" + reservationController.getReservation(1).getCost());
        }
        else
            System.out.println("nie działa 2");

        ArrayList<Screening> find = screeningsSchedule.findByTime(time3, time4);
        for (Screening x: find
             ) {
            System.out.println(x.getMovie().getTitle()+ "  " + x.getTime());
        }
        for (Screening x: screeningsSchedule.getAll()
        ) {
            System.out.println(x.getMovie().getTitle());
        }



        SpringApplication.run(CinemaApp.class, args);
    }
}
