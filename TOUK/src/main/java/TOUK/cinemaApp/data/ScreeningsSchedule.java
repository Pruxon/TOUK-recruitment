package TOUK.cinemaApp.data;

import TOUK.cinemaApp.model.Screening;
import TOUK.cinemaApp.model.SortScreenings;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class ScreeningsSchedule {
    private Map<Integer, Screening> schedule = new HashMap<Integer, Screening>();
    private Integer counter = 0;

    public Screening findOne(String key) {
        return schedule.get(key);
    }

    public ArrayList<Screening> getAll(){
        ArrayList<Screening> toReturn = new ArrayList<>();
        schedule.forEach((k, v) -> {
                toReturn.add(v);
        });
        return toReturn;
    }

    public ArrayList<Screening> findByTime(LocalDateTime first, LocalDateTime second) {
        if (first.isAfter(second)) {
            LocalDateTime temp = first;
            first = second;
            second = temp;
        }
        LocalDateTime _first = first;
        LocalDateTime _second = second;
        ArrayList<Screening> toReturn = new ArrayList<>();
        schedule.forEach((k, v) -> {
            LocalDateTime time = v.getTime();
            if (time.isAfter(_first) && time.isBefore(_second)) {
                toReturn.add(v);
            }
        });
        Collections.sort(toReturn, new SortScreenings());
        return toReturn;
    }

    public void add(Screening screening) {
        if (screening.getKey() == 0) {
            counter += 1;
            screening.setKey(counter);
            schedule.put(counter, screening);
        } else {
            schedule.put(screening.getKey(), screening);
        }
    }

    private ArrayList<Screening> sort(ArrayList<Screening> toSort){
        //ArrayList<Screening> toReturn = new ArrayList<>();
        toSort.sort(new SortScreenings());
        return toSort;
    }
}
