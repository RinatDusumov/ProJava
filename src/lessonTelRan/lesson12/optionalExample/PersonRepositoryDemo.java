package lessonTelRan.lesson12.optionalExample;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
    Optional в первую очередь предназначен для использования в качестве
    типа данных когда существует явная возможность получения отсутствия
    результата
 */
public class PersonRepositoryDemo {
    public static void main(String[] args) {
        Map<Integer, Person> personMap = new HashMap<>();
        Person person1 = new Person(null);
        personMap.put(1, person1);

        PersonRepository personRepository = new PersonRepository(personMap);
        Optional<Person> optionalPerson = personRepository.findById(1);

        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            String firstName = person.getFirstName();

            if (firstName != null) {
                System.out.println("Длина твоего имени: " + firstName.length());
            } else {
                System.out.println("Your name is null");
            }
        }
    }
}
