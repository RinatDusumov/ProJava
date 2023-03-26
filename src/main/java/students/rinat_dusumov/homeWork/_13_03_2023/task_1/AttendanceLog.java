package main.java.students.rinat_dusumov.homeWork._13_03_2023.task_1;

import java.util.List;
class AttendanceLog {
    void addendum (List<Student> listOfStudents) {
        listOfStudents.add(new Student("Arsen", "A", 2, 3.1));
        listOfStudents.add(new Student("Elena", "C", 1, 2.2));
        listOfStudents.add(new Student("Irina", "A", 3, 3.0));
        listOfStudents.add(new Student("Boris", "B", 2, 2.7));
        listOfStudents.add(new Student("James", "B", 1, 3.5));
        listOfStudents.add(new Student("Thomas", "A", 1, 2.0));
    }
    void removing(List<Student> listOfStudents) {
        listOfStudents.removeIf(student -> student.getGradesBySubject() < 3.0);
    }
    void forTheNextCourse(List<Student> listOfStudents) {
        for (Student student : listOfStudents) {
            if (student.getGradesBySubject() >= 3.0) {
                student.setCourse(student.getCourse()+1);
            }
        }
    }
    void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}