package lesson.array.lesson6;

import java.util.Arrays;

public class PersonDatabaseArrayDemo {
    public static void main(String[] args) {

        // для сравнения объектов следует переопределить метод equals и установить правила по которым будет сравнение
        /* если что то создаёся внутри метода его требуется вернуть,
          иначе оно так и останется внутри
        */

        Person[] personArray = new Person[5];
        personArray = getPersonArray(personArray);
        introduce(personArray);
        checkClone(personArray);

        Person testPerson = personArray[0];
        testPerson.setName("HERO!");
        System.out.println(Arrays.toString(personArray));
    }
    private static void checkClone(Person[] personArray) {
        if (personArray[0].equals(personArray[1])) {
            System.out.println("Clone");
        } else {
            System.out.println("Different");
        }
    }
    private static void introduce(Person[] personArray) {
        for (int i = 0; i < personArray.length; i++) {
            if (personArray[i] != null) {
                System.out.println(personArray[i]);
                personArray[i].say();
            }
        }
    }
    private static Person[] getPersonArray(Person[] personArray) {
        personArray = getPeople(personArray, "Petr", 29, 3456457);
        personArray = getPeople(personArray, "Victor", 23, 67585795);
        personArray = getPeople(personArray, "Alex", 20, 564564);
        personArray = getPeople(personArray, "John", 30, 6896543);
        return personArray;
    }
    private static Person[] getPeople(Person[] personArray, String name, int age, int personalCode) {
        if (personArray[personArray.length - 1] == null) {
            addToDataBase(personArray, new Person(name, age, personalCode));
        } else {
            personArray = increaseDataBase(personArray);
            addToDataBase(personArray, new Person(name, age, personalCode));
        }
        return personArray;
    }
    public static Person[] increaseDataBase(Person[] oldArray) {
        Person[] newPersonArray = new Person[oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++) {
            newPersonArray[i] = oldArray[i];
        }
        return newPersonArray;
    }
    public static void addToDataBase(Person[] personArray, Person newPerson) {
        for (int i = 0; i < personArray.length; i++) {
            if (personArray[i] == null) {
                personArray[i] = newPerson;
                return;
            }
        }
    }
}
