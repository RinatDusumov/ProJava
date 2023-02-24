package main.java.students.rinat_dusumov.homeWork._15_02_2023;

public class Employee {
    String surname;

    public String getSurname() {
        return surname;
    }
    public Employee(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return surname;
    }
}