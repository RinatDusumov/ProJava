package lessonTelRan.lesson_25.lessoncode.entity;

import java.util.Objects;

public class Employer extends Person{
    private double salary;
    private String nameOfDepartment;
    public Employer(int id, String name, SEX sex, int age, double salary, String nameOfDepartment) {
        super(id, name, sex, age);
        this.salary = salary;
        this.nameOfDepartment = nameOfDepartment;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employer employer = (Employer) o;
        return Double.compare(employer.salary, salary) == 0 && Objects.equals(nameOfDepartment, employer.nameOfDepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, nameOfDepartment);
    }

    @Override
    public String toString() {
        return "Employer{" +
                "salary=" + salary +
                ", nameOfDepartment='" + nameOfDepartment + '\'' +
                '}';
    }
}
