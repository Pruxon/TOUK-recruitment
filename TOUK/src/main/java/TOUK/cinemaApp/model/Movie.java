package TOUK.cinemaApp.model;

public class Movie {
    String title;
    int duration;

    public Movie (String _title, int _duration) {
        this.title = _title;
        this.duration = _duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}
