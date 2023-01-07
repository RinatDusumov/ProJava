package homeWork.lesson6.mainTask;

import java.util.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // task 1
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Напишите список слов");
//        String words = scanner.nextLine();
//        String[] arrayWords = words.split(" ");
//        Comparator<String> stringLength = new StringLengthSort();
//        Arrays.sort(arrayWords, stringLength);
//        for (String str : arrayWords) {
//            System.out.print(str + " ");
//        }
//        Arrays.sort(arrayWords, Comparator.naturalOrder());
//        System.out.println("\n" + Arrays.toString(arrayWords));
//
//        System.out.println("Напишите список чисел");
//        String numbers = scanner.nextLine();
//        String[] array = numbers.split(" ");
//        int countNumber = array.length;
//        Integer[] numberArray = new Integer[countNumber];
//        for (int i = 0; i < array.length; i++) {
//            numberArray[i] = Integer.parseInt(array[i]);
//        }
//        Arrays.sort(numberArray, Collections.reverseOrder());
//        System.out.println(Arrays.toString(numberArray));

        // task 2
        Random random = new Random();
        long start = System.currentTimeMillis();
        ArrayList<Integer> elements = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            elements.add(random.nextInt(100));
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);

        long start2 = System.currentTimeMillis();
        elements.clear();
        long finish2 = System.currentTimeMillis();
        long elapsed2 = finish2 - start2;
        System.out.println("Прошло времени, мс: " + elapsed2);
    }
}
