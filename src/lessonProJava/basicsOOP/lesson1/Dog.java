package lessonProJava.basicsOOP.lesson1;

public class Dog {
    String name;
    String color;

    public Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public void bark() {
        System.out.println(this.name + " подал голос");
    }
}
