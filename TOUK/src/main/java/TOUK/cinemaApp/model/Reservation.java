package TOUK.cinemaApp.model;

public class Reservation {
    private Screening screening;
    private String personName;
    private String personSurname;
    private Seat[] seats;
    private Ticket[] tickets;
    private int ID;

    public Reservation(Ticket[] tickets, Screening screening, String personName, Seat[] seats, int id, String personSurname) {
        this.tickets = tickets;
        this.seats = seats;
        this.personName = personName;
        this.screening = screening;
        this.personSurname = personSurname;
        this.ID = id;
    }


    public double getCost(){
        double cost = 0;
        for (Ticket t:tickets) cost += t.getPrice();
        return cost;
    }

    public String getPersonSurname() {
        return personSurname;
    }
}
