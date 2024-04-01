import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeDemo {
    static public void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println("Today's date is: " + date);


        LocalTime time = LocalTime.now();
        System.out.println("Current time is: " + time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current date and time is: " + dateTime);

        //create a date object from custom date
        LocalDate customDate = LocalDate.of(2021, 12, 25);
        System.out.println("Custom date is: " + customDate);

        //create a time object from custom time
        LocalTime customTime = LocalTime.of(1, 09, 45);
        System.out.println("Custom time is: " + customTime);
    }

    
}
