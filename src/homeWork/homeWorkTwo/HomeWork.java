package homeWork.homeWorkTwo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    void solutions() {
        Random random = new Random();

        // task 10, 12
        int[] number = new int[3];
        for (int i = 0; i < number.length; i++) {
            number[i] = random.nextInt(10);
            System.out.print(number[i] + " ");
        }

        //task 11, 13, 14, 15
        Scanner scanner = new Scanner(System.in);
        double[] number2 = new double[3];
        double sum = 0;
        double medium = 0;
        for (int i = 0; i < number2.length; i++) {
            System.out.println("Напишите число");
            number2[i] = scanner.nextDouble();
            sum += number2[i];
            medium = sum / number2.length;
        }
        System.out.println(Arrays.toString(number2) + ", сумма чисел = " + sum);
        System.out.println(medium);

        for (int i = 0; i < number2.length; i++) {
            number2[i] *= 2;
        }
        System.out.println(Arrays.toString(number2));

        //task 25, 26, 27, 28, 29, 30
        System.out.println("Напишите длину массива");
        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
//            System.out.println("Напишите число");
//            array[i] = scanner.nextInt();
            array[i] = random.nextInt(100);
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
            }
        }
        Arrays.sort(array);
        int max = array[array.length - 1];
        int min = array[0];
        System.out.println("\n" + Arrays.toString(array));
        System.out.println("max: " + max + ", min: " + min);
    }
}
