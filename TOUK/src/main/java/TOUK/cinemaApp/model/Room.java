package TOUK.cinemaApp.model;

public class Room {
    private int rows;
    private int places;
    private int roomNumber;

    public Room(int X, int Y, int _roomNumber) {
        rows = X;
        places = Y;
        roomNumber = _roomNumber;
    }

    public int getPlaces() {
        return places;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getRows() {
        return rows;
    }
}
