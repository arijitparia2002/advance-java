import java.util.*;

public class LocalDemo {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println("The default locale is: " + locale);

        System.out.println("All the locales available in the world are: ");
        Locale[] locales = Locale.getAvailableLocales();

        // print onn a proper format
        System.out.println("Country name\tCountry code\tLanguage");
        for (Locale l : locales) {
            System.out.println(l.getDisplayCountry() + "\t" + l.getCountry() + "\t" + l.getLanguage());

        }
    }
}
