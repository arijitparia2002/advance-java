import java.time.*;
import java.time.format.*;
import java.util.Scanner;

public class DateFormatterDemo {
    public static void main(String[] args) {
        System.out.println("Enter the date of birth in the format dd/MM/yyyy:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        // we can create a custom format using DateTimeFormatter based on whatever user
        // input format is.
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dob = LocalDate.parse(input, f); // for parsing the date
        System.out.println("The parsed date is from custom format: " + dob);

        // we can also use the formatter for output formatting
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = dob.format(f2);
        System.out.println("The formatted date is: " + formattedDate);

    }
}
