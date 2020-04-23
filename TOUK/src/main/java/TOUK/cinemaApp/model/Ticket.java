package TOUK.cinemaApp.model;

public class Ticket {
    private TicketType ticketType;

    public Ticket(TicketType _ticketType){
        this.ticketType = _ticketType;
    }

    public double getPrice(){
        if (ticketType == TicketType.adult){
            return 25;
        } else if (ticketType == TicketType.child) {
            return 12.50;
        } else if (ticketType == TicketType.student) {
            return 18;
        }
        return -1;
    }
}
