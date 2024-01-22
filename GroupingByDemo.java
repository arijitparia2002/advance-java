import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByDemo {
    public static void main(String[] args) {

        ArrayList<Mobile> al = new ArrayList<>();
        al.add(new Mobile("Redme 8", 8, "Android"));
        al.add(new Mobile("Nokia N2", 16, "Windows"));
        al.add(new Mobile("Realme 5i", 8, "Android"));
        al.add(new Mobile("I Phone 14", 8, "ios"));
        al.add(new Mobile("I Phone 13", 4, "ios"));

        // Map <Boolean, List<Mobile>> mp = al.stream().sorted((m1, m2) ->
        // m2.ram.compareTo(m1.ram) )
        // .collect(Collectors.partitioningBy(a -> a.OS.equals("Android")));

        // Map<String, List<Mobile>> mp = al.stream().sorted((m1, m2) ->
        // m2.ram.compareTo(m1.ram))
        // .collect(Collectors.groupingBy(x -> x.OS));

        Map<Integer, List<Mobile>> mp = al.stream().sorted((m1, m2) -> m2.ram.compareTo(m1.ram))
                .collect(Collectors.groupingBy(x -> x.ram));

        List<Mobile> l = mp.get(8);
        for (Mobile m : l)
            System.out.println(m.model + "\t" + m.ram + "\t" + m.OS);
    }

}

class Mobile {
    Integer ram;
    String OS, model;

    Mobile(String mod, int ram, String os) {
        model = mod;
        this.ram = ram;
        OS = os;
    }
}
