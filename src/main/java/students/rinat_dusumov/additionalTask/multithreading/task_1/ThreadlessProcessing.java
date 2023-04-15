package main.java.students.rinat_dusumov.additionalTask.multithreading.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class ThreadlessProcessing {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ThreadlessProcessing tp = new ThreadlessProcessing();
        List<Integer> numbers = new ArrayList<>(50);
        tp.arrayFilling(numbers);
        int user_specified = tp.elementInputFromUser();
        int count = tp.elementSearch(numbers, user_specified);
        tp.resultOutput(user_specified, count);
    }

    private void arrayFilling(List<Integer> numbers) {
        for (int i = 0; i <= 50; i++) {
            numbers.add(random.nextInt(100));
        }
    }

    private int elementInputFromUser() {
        System.out.println("Напишите цифру в диапазоне 0 - 99");
        return scanner.nextInt();
    }

    private int elementSearch(List<Integer> numbers, int user_specified) {
        int count = 0;
        for (Integer number : numbers) {
            if (number == user_specified) {
                count++;
            }
        }
        return count;
    }

    private void resultOutput(int user_specified, int count) {
        System.out.printf("Количество повторений цифры %d - %d",
                user_specified, count);
    }
}