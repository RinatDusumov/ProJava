package proJavaHomeWork.homeWorkTwo;

import java.util.Scanner;

public class AdditionalTask {
    void decision() {
        Scanner scanner = new Scanner(System.in);
        // task 1
        System.out.println("Напишите два числа");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        System.out.println("Сумма = " + (x + y));
        System.out.println("Разница = " + (x - y));
        System.out.println("Произведение = " + (x * y));
        System.out.println("Деление = " + (x / y));

        // task 2
        System.out.println("Напишите своё имя");
        System.out.println("Hello, " + scanner.nextLine());

        // task 3
        System.out.println("Напишите целое число");
        int number = scanner.nextInt();
        int count = 1;
        while (count <= 10) {
            System.out.printf("%d * %d = %d" + "\n", number, count, number * count);
            count++;
        }

        // task 4
        System.out.println("Напишите радиус круга");
        double radius = scanner.nextDouble();
        System.out.println("Периметр = " + Math.PI * (radius * 2));
        System.out.println("Площадь = " + Math.PI * Math.pow(radius, 2));

        // task 5
        System.out.println("Напишите три целых числа");
        int w = scanner.nextInt();
        int z = scanner.nextInt();
        int l = scanner.nextInt();
        System.out.println((double) (w + z + l) / 3);
    }
}
