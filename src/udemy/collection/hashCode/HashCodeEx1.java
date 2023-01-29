package udemy.collection.hashCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
    Если переопределили equals, то обязательно переопределите
    и hashcode.

    Хеширование - это преобразование с помощью метода hashcode
    любого объекта в число int.

    Результат нескольких выполнений метода hashcode для одного и
    того же объекта должен быть одинаковым.

    Если, согласно методу equals, два объекта равны, то и hashcode
    данных объектов обязательно должен быть одинаковым.

    Если, согласно методу equals, два объекта НЕ равны, то hashcode
    данных объектов НЕ обязательно должен быть разным.

    Ситуация, когда результат метода hashcode для разных объектов
    одинаков, называется коллизией. Чем её меньше, тем лучше.

    Проверка сначала по hashcode только затем по equals
 */
public class HashCodeEx1 {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        Student st1 = new Student("Marina", "Ivanova", 3);
        Student st2 = new Student("Anton", "Petrov", 2);
        Student st3 = new Student("Sergey", "Tregulov", 5);

        map.put(st1, 7.5);
        map.put(st2, 8.5);
        map.put(st3, 5.0);
        System.out.println(map);

        System.out.println(st1.hashCode());
        System.out.println(st2.hashCode());
    }
}
class Student {
    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }
}
