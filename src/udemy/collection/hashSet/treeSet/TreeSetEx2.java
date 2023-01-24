package udemy.collection.hashSet.treeSet;

import java.util.Objects;
import java.util.TreeSet;

public class TreeSetEx2 {
    public void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();

        Student st1 = new Student("Elena", 1);
        Student st2 = new Student("Regina", 5);
        Student st3 = new Student("Polina", 2);
        Student st4 = new Student("Kristina", 4);

        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        System.out.println(treeSet);

        System.out.println(treeSet.first()); // первый элемент
        System.out.println(treeSet.last()); // крайний элемент

        Student st5 = new Student("James", 3);
        System.out.println(treeSet.headSet(st5)); // выведутся все кто учится на младших курсах
        System.out.println(treeSet.tailSet(st5)); // выведутся все кто учится на старших курсах

        Student st6 = new Student("Ivan", 4);
        System.out.println(treeSet.subSet(st2, st6)); // выводит элементы, что между элементами указанных в параметрах
    }
    class Student implements Comparable<Student> {
        String name;
        int course;

        public Student(String name, int course) {
            this.name = name;
            this.course = course;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", course=" + course +
                    '}';
        }

        @Override
        public int compareTo(Student other) {
            return this.course - other.course;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return course == student.course;
        }

        @Override
        public int hashCode() {
            return Objects.hash(course);
        }
    }
}
