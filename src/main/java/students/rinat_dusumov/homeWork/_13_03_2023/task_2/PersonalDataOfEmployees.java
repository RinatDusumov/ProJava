package main.java.students.rinat_dusumov.homeWork._13_03_2023.task_2;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonalDataOfEmployees {
    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> employees = new ArrayList<>();
        addendum(employees);
        Report report = new Report();
        report.generateReport(employees);
        FullReport fullReport = new FullReport();
        fullReport.generateFullReport(employees);
    }
    static void addendum(List<Employee> employees) {
        employees.add(new Employee("Lili Potter", 3600.50,
                LocalDate.of(2023,03,15)));
        employees.add(new Employee("Severus Sneg", 3200.35,
                LocalDate.of(2023,03,16)));
        employees.add(new Employee("Minerwa MacGonagal", 3700.99,
                LocalDate.of(2023,03,13)));
        employees.add(new Employee("Sirius Black", 3500.47,
                LocalDate.of(2023,03,10)));
    }
}
