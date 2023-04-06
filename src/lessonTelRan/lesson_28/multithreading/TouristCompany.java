package lessonTelRan.lesson_28.multithreading;

public class TouristCompany {
    public static void main(String[] args) {
        People queue1 = new People(1,"John", "Mark", "Olga", "Viktor");
        People queue2 = new People(2,"Anton", "Boris", "Serge", "Alisa");

        System.out.println("Start program");
        queue1.start();
        queue2.start();
        System.out.println("Finish program");

        System.out.println(queue1.result);
        System.out.println(queue2.result);
    }
}