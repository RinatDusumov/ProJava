package lessonTelRan.lesson17.streamExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonMaxAge {
    public static void main(String[] args) {
        Person person1 = new Person("Petr", 28);
        Person person2 = new Person("Ruslan", 32);
        Person person3 = new Person("Victor", 29);
        Person person4 = new Person("Mike", 48);
        Person person5 = new Person("Vadim", 38);

        List<Person> users = Arrays.asList(person1,person2,person3,person4,person5);

        Person userWithMaxAge = users.stream()
                .reduce(Person :: maxAge)
                .get();
        System.out.println("User with max age - " + userWithMaxAge);

        userWithMaxAge= null;
        userWithMaxAge = users.get(0);
        for (Person person : users) {
            userWithMaxAge = Person.maxAge(userWithMaxAge, person);
        }
        System.out.println("User with max age - " + userWithMaxAge);
    }
}