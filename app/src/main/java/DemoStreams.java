import com.demo.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class DemoStreams {

    public static void main(String args[]) {
        List<Employee> employeeList = Arrays.asList(new Employee("John", "Smith", 20, "Sales"),
                new Employee("Anny", "Smith", 50, "Sales"),
                new Employee("John", "Ray", 40, "HR"),
                new Employee("Prerna", "Singh", 25, "Tech"),
                new Employee("Neha", "Sharma", 30, "HR"));


        /*iterate through the list*/

        employeeList.forEach(p -> System.out.println(p));

        /*find employees with age more than 30*/
        System.out.println("Employee who age is more than 30");
        employeeList.stream().filter(e -> e.age() > 30).forEach(System.out::println);

        /*find employees with first name starts with J*/
        System.out.println("Employee who first name starts with J");
        employeeList.stream().filter(e -> e.firstName().startsWith("J")).forEach(System.out::println);

        /*group employees by department*/
        System.out.println("Employee  grouped by department");
        Map<String, Long> employeeByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
        System.out.println(employeeByDepartment);

        /*Count employees in department HR*/
        System.out.println("Count employees in department HR");
        long count = employeeList.stream().filter(e -> e.department().equalsIgnoreCase("HR")).count();
        System.out.println(count);


        /*Find Employee with max age */
        System.out.println("Find employees with max age");
        Optional<Employee> employee = employeeList.stream().max(Comparator.comparing(Employee::age));
        employee.ifPresentOrElse(System.out::println, ()->System.out.println("Not Found"));

        /*Find max age in the employee list*/
        System.out.println("Find employees with max age");
        employee.ifPresentOrElse(e->System.out.println(e.age()), ()->System.out.println("Not Found"));

    }
}
