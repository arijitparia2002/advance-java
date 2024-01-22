import java.util.ArrayList;
import java.util.stream.*;

class Employee {
    int emp_id;
    String name;
    String country;
    double salary;

    Employee(int emp_id, String name, String country, double salary) {
        this.emp_id = emp_id;
        this.name = name;
        this.country = country;
        this.salary = salary;
    }

}

public class EmployeeSort {
    public static void main(String... rk) {
        ArrayList<Employee> al = new ArrayList<>();

        al.add(new Employee(105, "Raj", "India", 14000.0));
        al.add(new Employee(107, "Nikhil", "India", 18000.0));
        al.add(new Employee(108, "Prabhash", "India", 67000.0));
        al.add(new Employee(102, "Raman", "India", 17000.0));
        al.add(new Employee(103, "Arijit", "US", 40000.0));
        al.add(new Employee(104, "Rudra", "Japan", 60000.0));

        Stream<Employee> str = al.stream().filter(emp -> emp.country == "India")
                .sorted((e1, e2) -> (e1.salary - e2.salary) > 0 & (e1.emp_id - e2.emp_id) > 0 ? 1 : -1);

        str.forEach(emp -> System.out.println(emp.emp_id + " " + emp.name + " " + emp.country + " " + emp.salary));
    }

}
