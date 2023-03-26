package main.java.students.rinat_dusumov.homeWork._13_03_2023.task_1;

import java.util.LinkedList;
import java.util.List;

/**
 * Создать класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
 * Создать коллекцию, содержащую объекты класса Student.
 * Написать метод, который удаляет студентов со средним баллом <3.
 * Если средний балл>=3, студент переводится на следующий курс.
 * Напишите метод printStudents(List<Student> students, int course), который получает список студентов и номер курса.
 * А также печатает на консоль имена тех студентов из списка, которые обучаются на данном курсе.
 */

class StudentControlDemo {
    public static void main(String[] args) {
        List<Student> listOfStudents = new LinkedList<>();
        AttendanceLog attendanceLog = new AttendanceLog();
        attendanceLog.addendum(listOfStudents);
        attendanceLog.removing(listOfStudents);
        attendanceLog.forTheNextCourse(listOfStudents);
        attendanceLog.printStudents(listOfStudents, 3);

    }
}