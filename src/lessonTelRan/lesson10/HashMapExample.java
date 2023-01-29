package lessonTelRan.lesson10;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Person, Dog> personDogMap = new HashMap<>();

        personDogMap.put(new Person("Robert", 30), new Dog("Reks"));
    }
}
