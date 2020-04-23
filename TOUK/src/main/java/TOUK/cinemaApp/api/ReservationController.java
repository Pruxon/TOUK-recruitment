package TOUK.cinemaApp.api;

import TOUK.cinemaApp.model.Reservation;
import TOUK.cinemaApp.model.Screening;
import TOUK.cinemaApp.model.Seat;
import TOUK.cinemaApp.model.Ticket;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReservationController {
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private int reservationCount = 0;

    public boolean makeReservation (Screening _screening, Seat _seats[], String _personName, Ticket _tickets[], String _personSurname) {
        if (_personName.length() < 3 || _personSurname.length() < 3)
            return false;
        Reservation newReservation = new Reservation(_tickets,_screening,_personName,_seats, reservationCount+1, _personSurname);
        if (checkDate(_screening)) {
            if (_screening.reserve(_seats)) {
                reservations.add(newReservation);
                reservationCount+=1;
                return true;
            }
        }
        return false;
    }

    public Reservation getReservation(int num){
        return reservations.get(num);
    }

    private boolean checkDate(Screening _screening){
        LocalDateTime now = LocalDateTime.now();
        if (_screening.getTime().isAfter(now.plusMinutes(15)))
            return true;
        else
            return false;
    }
}
