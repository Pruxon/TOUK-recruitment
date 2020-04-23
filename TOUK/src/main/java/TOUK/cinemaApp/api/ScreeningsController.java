package TOUK.cinemaApp.api;

import TOUK.cinemaApp.data.ScreeningsSchedule;
import TOUK.cinemaApp.model.Reservation;
import TOUK.cinemaApp.model.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("touk")
@RestController
public class ScreeningsController {

    private ScreeningsSchedule screeningsSchedule;
    private ReservationController reservationController;

    public ScreeningsController(ScreeningsSchedule _screeningsSchedule) {
        this.screeningsSchedule = _screeningsSchedule;
    }

    @GetMapping("/screenings")
    public List<Screening> getAll() {
        return screeningsSchedule.getAll();
    }

    @GetMapping("/screenings/{firstTime},{secondTime}")
    public List<Screening> getByTime(@PathVariable LocalDateTime firstTime, LocalDateTime secondTime) {
        return screeningsSchedule.findByTime(firstTime, secondTime);
    }

    /*
    @PostMapping("/reservation/{}/")
    public boolean reserve(){
        return reservationController.makeReservation();
    }
    ////////////////
    tu miała być metoda od rezerwacji, chciałem wczytywać JSONa jako argument, który symulowałby paczke z frontu i na jej podstawie tworzyć rezerwację
    ///////////////
     */
}
