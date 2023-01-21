package lessonTelRan.array.lesson6;

import java.util.ArrayList;
import java.util.List;

public class PersonDataBaseArrayListDemo {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        getPersonList(personList);
//        for (Person currentPerson : personList) {
//            System.out.println(currentPerson);
//            currentPerson.say();
//        }
        for (int i = 0; i < personList.size(); i++) {
            Person currentPerson = personList.get(i);
            currentPerson.say();
            currentPerson.setName(currentPerson.getName() + " super Hero!");
        }
    }
    private static void getPersonList(List<Person> personList) {
        personList.add(new Person( "Ruslan", 29, 123321999));
        personList.add(new Person(  "Petr", 31, 1233142999));
        personList.add(new Person(  "Viktor", 35, 1525476999));
        personList.add(new Person(  "Vladislav", 26, 835833465));
        personList.add(new Person(  "Alex", 30, 321999));
        personList.add(new Person(  "John", 33, 833465));
    }
}
