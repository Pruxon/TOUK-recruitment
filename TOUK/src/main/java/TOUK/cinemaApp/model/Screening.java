package TOUK.cinemaApp.model;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private Room room;
    private LocalDateTime time;
    private boolean seats [] [];
    private Integer key;

    public Screening(Movie _movie, Room _room, LocalDateTime _time, boolean[][] seats) {
        this.movie = _movie;
        this.room = _room;
        this.time = _time;
        this.seats = seats;
        this.key = 0;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Movie getMovie() {
        return movie;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public boolean reserve (Seat _seats[]) {
        for (Seat s: _seats) {
            seats[s.getRow()][s.getPlace()] = true;
        }
        if (checkSeats(_seats)) {
            return true;
        } else {
            revertReserve(_seats);
            return false;
        }
    }

    private boolean checkSeats(Seat _seats[]) {
        boolean checker = true;
        int places = getRoom().getPlaces();
        for (Seat seat: _seats) {
            int rowNum = seat.getRow();
            int placeNum = seat.getPlace();
            if (placeNum == 0 || placeNum == 1) {
                if (seats[rowNum][placeNum + 1] == false && seats[rowNum][placeNum + 2] == true) {
                    checker = false;
                }
            } else if (placeNum == places || placeNum == places-1) {
                if (seats[rowNum][placeNum - 1] == false && seats[rowNum][placeNum - 2] == true) {
                    checker = false;
                }
            }
        }
        return checker;
    }

    private void revertReserve(Seat _seats[]) {
        for (Seat s: _seats) {
            seats[s.getRow()][s.getPlace()] = false;
        }
    }
}
