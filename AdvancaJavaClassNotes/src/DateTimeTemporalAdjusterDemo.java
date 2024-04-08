import java.time.*;
import java.time.temporal.*;

public class DateTimeTemporalAdjusterDemo {
    static public void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate firstSaturday = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.SATURDAY));
        LocalDate lastSaturday = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.SATURDAY));


        System.out.println("First Saturday of the month: " + firstSaturday);
        System.out.println("Last Saturday of the month: " + lastSaturday);

    }
}
