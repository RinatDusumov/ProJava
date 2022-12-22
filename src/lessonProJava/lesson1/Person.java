package lessonProJava.lesson1;

public class Person {
    String name;
    int age;
    double weight;

    public Person(String n1, int a1, double w1) {
        this.name = n1;
        this.age = a1;
        this.weight = w1;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void say(String text) {
        System.out.println("Person " + this.name + " say " + text);
    }

//    для вывода значений объекта используется переопределение метода toString()
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
