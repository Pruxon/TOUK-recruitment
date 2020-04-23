package TOUK.cinemaApp.model;

public class Seat {
    private int Row;
    private int Place;

    public Seat (int _row, int _place) {
        Row = _row;
        Place = _place;
    }

    public int getRow(){
        return Row;
    }

    public int getPlace() {
        return Place;
    }
}
