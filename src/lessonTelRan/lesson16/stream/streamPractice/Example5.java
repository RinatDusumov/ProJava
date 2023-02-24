package lessonTelRan.lesson16.stream.streamPractice;

import java.util.ArrayList;
import java.util.List;

public class Example5 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Aleks", "Developer", 1500));
        employeeList.add(new Employee("Thomas", "Manager", 680.50));
        employeeList.add(new Employee("Thea", "CEO", 2000));
        employeeList.add(new Employee("Mary", "Manager", 700));
        employeeList.add(new Employee("Ken", "Developer", 900));

        List<Employee> employeesNoCEO = employeeList.stream()
                .filter(x -> !"CEO".equals(x.getStaff()))
                .toList();
        System.out.println(employeesNoCEO);

        List<Employee> employeesDevOnly = employeeList.stream()
                .filter(x -> !"CEO".equals(x.getStaff()))
                .filter(x -> !"Manager".equals(x.getStaff()))
                .toList();
        System.out.println(employeesDevOnly);
    }
}
class Employee {
    private String name, staff;
    private double salary;

    public Employee(String name, String staff, double salary) {
        this.name = name;
        this.staff = staff;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name +  " is " + staff+ " salary=" + salary;
    }

    public String getName() {
        return name;
    }

    public String getStaff() {
        return staff;
    }

    public double getSalary() {
        return salary;
    }
}
