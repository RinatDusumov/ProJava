package main.java.students.rinat_dusumov.homeWork._13_03_2023.task_2;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
public class FullReport {
//    void generateFullReport(List<Employee> employees) {
//        for (Employee emp : employees) {
//            System.out.printf("Имя сотрудника: %s, заработная плата составляет %.2f " +
//                            "и дата выдачи - %s\n",
//                    emp.getFullName(), emp.getSalary(), emp.getSalaryDate());
//        }
//    }
    void generateFullReport(List<Employee> employees) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        String countingDown = null;
        Employee employee = new Employee();
        for (Employee emp : employees) {
            countingDown = String.valueOf(sb.append("Имя сотрудника: " + emp.getFullName() + ", заработная плата составляет " +
                            emp.getSalary() + " и дата выдачи - " + emp.getSalaryDate() + "\n"));
        }
//        System.out.println(countingDown);
        employee.writingToAFile(countingDown);
    }
}