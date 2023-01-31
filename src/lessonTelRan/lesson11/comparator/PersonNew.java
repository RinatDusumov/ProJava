package lessonTelRan.lesson11.comparator;

import java.util.Comparator;
import java.util.Objects;

public class PersonNew implements Comparator<PersonNew> {
    private String firstName;
    private String secondName;
    private int age;

    public PersonNew(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compare(PersonNew o1, PersonNew o2) {
        String person1Data = o1.secondName + o1.firstName + o1.age;
        String person2Data = o2.secondName + o2.firstName + o2.age;
        return person1Data.compareTo(person2Data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonNew personNew = (PersonNew) o;
        return age == personNew.age && Objects.equals(firstName, personNew.firstName) &&
                Objects.equals(secondName, personNew.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, age);
    }
}
