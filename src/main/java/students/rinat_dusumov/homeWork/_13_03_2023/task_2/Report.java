package main.java.students.rinat_dusumov.homeWork._13_03_2023.task_2;

import java.util.List;
class Report {
    void generateReport(List<Employee> employees) {
        for (Employee emp : employees) {
            System.out.printf("Имя сотрудника: %s, заработная плата - %.2f\n",
                    emp.getFullName(), emp.getSalary());
        }
    }
}