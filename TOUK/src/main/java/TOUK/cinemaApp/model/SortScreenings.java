package TOUK.cinemaApp.model;

import java.time.LocalDateTime;
import java.util.Comparator;

public class SortScreenings implements Comparator<Screening> {
    public int compare(Screening a, Screening b){
        String a1 = a.getMovie().getTitle();
        String b1 = b.getMovie().getTitle();
        int sComp = a1.compareTo(b1);

        if (sComp != 0)
            return sComp;

        LocalDateTime a2 = a.getTime();
        LocalDateTime b2 = b.getTime();

        return  a2.compareTo(b2);
    }
}

