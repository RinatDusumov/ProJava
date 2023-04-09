package javaProTesting.module_2.task_2;

import java.util.Objects;

class Person {
    private int temporarySlot = 0;
    private final String visitingTime;
    private final String name;

    public Person(int temporarySlot, String visitingTime, String name) {
        this.temporarySlot = temporarySlot;
        this.visitingTime = visitingTime;
        this.name = name;
    }

    public void setTemporarySlot() {
        this.temporarySlot += 1;
    }

    public String getVisitingTime() {
        return visitingTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Temporary slot - " + temporarySlot +
                ", visiting time - " + visitingTime +
                ", name - " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(visitingTime, person.visitingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temporarySlot, visitingTime, name);
    }
}