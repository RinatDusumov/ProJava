package proJavaHomeWork.homeWorkOne;

public class HomeWork1 {
    public static void main(String[] args) {
        // task 1
        Person person = new Person ("Nameless", 7);
        person.talk ();

        Person person2 = new Person ();
        person2.move ();


        // task 2
        Phone myPhone = new Phone (6553, "samsung", 160);
        Phone myPhone_2 = new Phone (7777, "iphone", 150);
        Phone myPhone_3 = new Phone (4565886, "realmi", 155);

        System.out.println(myPhone);
        System.out.println(myPhone_2);
        System.out.println(myPhone_3);

        myPhone.receiveCall();
        myPhone_2.receiveCall();
        myPhone_3.receiveCall();
    }
}
