import java.time.*;
import java.time.temporal.*;
import java.util.Scanner;

/*
Bruce Lee is working in an IT company which is providing the Holidays on all Sundays and
2nd and 4th Saturday.
Bruce Lee wanted to know the Holidays in the Month in which his Birthday Falls so that
he can plan a long weekend Holidays.
Help Bruce Lee to find out the dates and Days of Holiday of that Month.
Read the DoB from Command Line Arguments.

Input Format: 2002-10-05
OutFormat: 2002-10-03 Sunday
2002-10-09 Saturday
2002-10-10 Sunday
2002-10-17 Sunday
2002-10-23 Saturday
2002-10-24 Sunday
2002-10-31 Sunday



*/

public class FindHoliday {
    public static void main(String[] args) {
        // takedate of birth as input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the date of birth in the format yyyy-mm-dd");
        String date = sc.nextLine();
        sc.close();
        // parse the date
        LocalDate dob = LocalDate.parse(date);
        // get the month of the date

        // get all sundays and 2nd and 4th saturday of the month using temporal adjuster
        // in a loop
        LocalDate firstSunday = dob.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
        LocalDate secondSaturday = dob.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SATURDAY));
        LocalDate thirdSunday = dob.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.SUNDAY));
        LocalDate fourthSaturday = dob.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.SATURDAY));
        LocalDate fifthSunday = dob.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));

        // print the dates
        System.out.println(firstSunday);
        System.out.println(secondSaturday);
        System.out.println(thirdSunday);
        System.out.println(fourthSaturday);
        System.out.println(fifthSunday);

    }
}
