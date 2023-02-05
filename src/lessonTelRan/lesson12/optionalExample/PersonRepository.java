package lessonTelRan.lesson12.optionalExample;

import java.util.Map;
import java.util.Optional;

public class PersonRepository {
    private final Map<Integer, Person> persons;

    public PersonRepository(Map<Integer, Person> persons) {
        this.persons = persons;
    }
//    public Person findById (int id) {
//        return persons.get(id);
//    }

    public Optional<Person> findById (Integer id) {
        return Optional.ofNullable(persons.get(id));
    }
}
