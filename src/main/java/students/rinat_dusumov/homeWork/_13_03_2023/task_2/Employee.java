package main.java.students.rinat_dusumov.homeWork._13_03_2023.task_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Objects;

class Employee {
    private String fullName;
    private double salary;
    private LocalDate salaryDate;

    public Employee(String fullName, double salary, LocalDate salaryDate) {
        this.fullName = fullName;
        this.salary = salary;
        this.salaryDate = salaryDate;
    }
    void writingToAFile(StringBuilder countingDown) throws FileNotFoundException {
        File file = new File("testFile");
        PrintWriter pw = new PrintWriter(file);
        pw.println(countingDown);
        pw.close();

    }
    String getFullName() {
        return fullName;
    }
    double getSalary() {
        return salary;
    }

    public LocalDate getSalaryDate() {
        return salaryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
