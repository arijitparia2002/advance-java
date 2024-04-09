import java.util.*;

public class LocalDemo {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println("The default locale is: " + locale);

        // System.out.println("All the locales available in the world are: ");
        // Locale[] locales = Locale.getAvailableLocales();

        // // print onn a proper format
        // System.out.println("Country name\tCountry code\tLanguage");
        // for (Locale l : locales) {
        // System.out.println(l.getDisplayCountry() + "\t" + l.getCountry() + "\t" +
        // l.getLanguage());

        // }

        //TASK: create locale object in 4 ways
        
        Locale l1 = new Locale("en", "US");
        Locale l2 = new Locale("fr");
        Locale l3 = new Locale("fr", "CA");
        Locale l4 = Locale.getDefault();
        Locale l5 = new Locale.Builder().setLanguage("en").setRegion("US").build();
        Locale l6 = Locale.CANADA;

        Locale[] locales = { l1, l2, l3, l4, l5, l6 };
        for (Locale l : locales) {
            System.out.println(l.getDisplayCountry() + "\t" + l.getCountry() + "\t" + l.getLanguage());
        }

    }
}
