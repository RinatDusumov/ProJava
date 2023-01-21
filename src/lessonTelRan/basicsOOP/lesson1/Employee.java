package lessonTelRan.basicsOOP.lesson1;

public class Employee {
    private String name;
    private int age;
    private String position;
    public int salary;

    public Employee(String name, int age, String position,
                    int salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }
}
