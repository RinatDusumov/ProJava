package lessonTelRan.basicsOOP.lesson1;

public class PhoneDemo {
    public static void main(String[] args) {
        Phone iphone = new Phone("Iphone 13", "black");
        Phone samsung = new Phone("Note 20 Ultra", "white");

        ImportPhone importPhone1 = new ImportPhone("Apple", iphone);
        ImportPhone importPhone2 = new ImportPhone("Samsung", samsung);

        System.out.println(importPhone1);

        MyPhone myPersonalPhone = new MyPhone(2134432, iphone);
        System.out.println(myPersonalPhone);

        myPersonalPhone.ring(9454302);

        Employee employee1 = new Employee("James", 25, "developer",
                2400);
        Employee employee2 = new Employee("Richard", 37, "developer",
                3000);
        Employee employee3 = new Employee("Juliana", 22, "developer",
                2000);
        System.out.println(salaryIncrease(employee2.salary));
    }
    public static int salaryIncrease(int newSalary) {
        return newSalary *= 2;
    }
}
