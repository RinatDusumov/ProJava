package main.java.students.rinat_dusumov.homeWork._13_03_2023.task_1;

import java.util.Objects;
class Student {
    private String name;
    private String group;
    private int course;
    private double gradesBySubject;
    public Student(String name, String group, int course, double gradesBySubject) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.gradesBySubject = gradesBySubject;
    }
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    public String getGroup() {
        return group;
    }
    void setGroup(String group) {
        this.group = group;
    }
    int getCourse() {
        return course;
    }
    void setCourse(int course) {
        this.course = course;
    }
    double getGradesBySubject() {
        return gradesBySubject;
    }
    void setGradesBySubject(int gradesBySubject) {
        this.gradesBySubject = gradesBySubject;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && gradesBySubject == student.gradesBySubject && Objects.equals(name, student.name) && Objects.equals(group, student.group);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, group, course, gradesBySubject);
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", gradesBySubject=" + gradesBySubject +
                '}';
    }
}