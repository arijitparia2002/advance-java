import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeFormatterDemo {

    public static void main(String[] args) {
        LocalTime time = LocalTime.now();

        System.out.println("The current time is: " + time);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm:ss a");

        System.out.println("The formatted time is: " + time.format(f));
    }

}
