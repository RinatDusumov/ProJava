package lesson.basicsOOP.lesson4.example3;

public class Cat {
    String name;
    String breed;
    String color;
    int age;

    public Cat(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }
    public Cat(String name) {
        this.name = name;
    }
    public Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }
    public Cat(String name, String color, String breed) {
        this.name = name;
        this.color = color;
    }
    public Cat (int age, String breed) {
        this.breed = breed;
        this.age = age;
    }
}
