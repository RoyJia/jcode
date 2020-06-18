package stream;

import model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeStreams {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(1, "Tomq", 5000),
                new Employee(2, "Tomw", 4000),
                new Employee(3, "Tome", 3000),
                new Employee(4, "Tomr", 7000),
                new Employee(5, "Tomt", 5000),
                new Employee(6, "Tomy", 1000),
                new Employee(7, "Tomu", 5000),
        };

        Stream<Employee> stream = Stream.of(employees);
        List<Employee> employeeList = Arrays.asList(employees);

        employeeList.stream().forEach(employee -> System.out.println(employee.getName()));

        List<Integer> ids = stream.map(Employee::getId).collect(Collectors.toList());
        ids.forEach(System.out::println);
    }
}
