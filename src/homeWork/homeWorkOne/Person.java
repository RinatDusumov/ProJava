package homeWork.homeWorkOne;

public class Person {
    private String fullName;
    private int age;
    private String fullName2 = "Nameless второй";

    public Person ( String name, int age ) {
        this.fullName = name;
        this.age = age;
    }
    void talk () {
        System.out.println (fullName + " говорит");
    }
    public Person () {};
    void move () {
        System.out.println (fullName2 + " говорит");
    };
}
