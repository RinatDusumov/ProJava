package udemy.comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
    Интерфейс Comparable используется для сравнения объектов,
    используя естественный порядок.
    Требуется иплементировать интерфейс и переопределить
    метод compareTo(Element e)

    Интерфейс Comparator используется для сравнения объектов,
    используя НЕ естественный порядок.
    Требуется иплементировать интерфейс и переопределить
    метод compare(Element e1, element e2)
 */
public class Test1 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        Employee emp1 = new Employee(100, "Ivan", " Petrov", 15000);
        Employee emp2 = new Employee(90, "Marina", "Ivanova", 13000);
        Employee emp3 = new Employee(102, "Gena", "Krokodil", 13500);

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println("Before sorting: " + list);

        Collections.sort(list);
        System.out.println("After sorting: " + list);


    }
}
class Employee implements Comparable<Employee> {
    Integer id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee anotherEmp) {
        // 1 способ
//        if (this.id == anotherEmp.id) {
//            return 0;
//        } else if (this.id < anotherEmp.id) {
//            return -1;
//        } else {
//            return 1;
//        }

        // 2 способ
//        return this.id - anotherEmp.id;

        // 3 способ
//        return this.id.compareTo(anotherEmp.id);

        // 4 способ
//        return this.name.compareTo(anotherEmp.name);
        // или
        int res = this.name.compareTo(anotherEmp.name);
        if (res == 0) {
            res = this.surname.compareTo(anotherEmp.surname);
        }
        return res;
    }
}
