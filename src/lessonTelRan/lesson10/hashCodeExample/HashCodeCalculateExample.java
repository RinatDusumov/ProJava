package lessonTelRan.lesson10.hashCodeExample;

public class HashCodeCalculateExample {
    public static void main(String[] args) {
        Person firstPerson = new Person("Vasya");
        Person secondPerson = new Person("Petya");
        Person person3 = new Person("Vasya");

        System.out.println(firstPerson.hashCode());
        System.out.println(secondPerson.hashCode());
        System.out.println(person3.hashCode());
    }
}
