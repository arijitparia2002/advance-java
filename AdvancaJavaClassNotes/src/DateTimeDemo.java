import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Scanner;

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
        LocalTime customTime = LocalTime.of(1, 9, 45);
        System.out.println("Custom time is: " + customTime);

        //Methods of LocalDate
        LocalDate parsedDate = LocalDate.parse("2024-11-30"); //ISO 8601 format should be there [YYYY-MM-DD]
        System.out.println(parsedDate);
        System.out.println();
        

        //***TASK: 
        //read the date of birth and display the day of the week and print the calender of that month */

        // input a string
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a DOB in the format of YYYY-MM-DD: ");
        String inputDate = sc.nextLine();
        sc.close();

        LocalDate dob = LocalDate.parse(inputDate);
        System.out.println("You are born on: " + dob.getDayOfWeek());

        //calculate the age as of today
        LocalDate today = LocalDate.now();
        Period period = Period.between(dob, today);
        // System.out.println(period);
        System.out.println("Age: " + period.getYears() + " years " + period.getMonths() + " months " + period.getDays() + " days");


        //print the calender of that month
        // int month = dob.getMonthValue();
        // int year = dob.getYear();

        // System.out.println("Calender of the month: ");
        // System.out.println("Mon\tTue\tWed\tThu\tFri\tSat\tSun");
        // LocalDate firstDay = LocalDate.of(year, month, 1);
        // int dayOfWeek = firstDay.getDayOfWeek().getValue();
        // for (int i = 1; i < dayOfWeek; i++) {
        //     System.out.print("\t");
        // }
        // while (firstDay.getMonthValue() == month) {
        //     System.out.print(firstDay.getDayOfMonth() + "\t");
        //     if (firstDay.getDayOfWeek().getValue() == 7) {
        //         System.out.println();
        //     }
        //     firstDay = firstDay.plusDays(1);
        // }


        

        
    }

    
}
