package main.java.students.rinat_dusumov.additionalTask.multithreading.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class DualThreadProcessing implements Runnable {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    private static volatile int user_specified;
    private static volatile int count = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(new DualThreadProcessing());
        thread.start();

        user_specified = elementInputFromUser();
        resultOutput(user_specified, count);
    }

    private static int elementInputFromUser() {
        System.out.println("Напишите цифру в диапазоне 0 - 99");
        return scanner.nextInt();
    }

    private static void resultOutput(int user_specified, int count) {
        System.out.println("Количество повторений цифры " + user_specified +
                " - " + count);
    }

    @Override
    public void run() {
        List<Integer> numbers = new ArrayList<>(50);
        arrayFilling(numbers);
        elementSearchThread(numbers, user_specified);
    }

    private void arrayFilling(List<Integer> numbers) {
        for (int i = 0; i <= 50; i++) {
            numbers.add(random.nextInt(100));
        }
    }

    private void elementSearchThread(List<Integer> numbers, int user_specified) {
        for (Integer number : numbers) {
            if (number == user_specified) {
                count++;
            }
        }
    }
}