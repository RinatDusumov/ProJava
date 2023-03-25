package main.java.students.rinat_dusumov.homeWork._15_02_2023;

import java.util.*;

public class Main {
    static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {
        /** Task 1
         Дан набор строк, посчитать количество разных букв во всех
         строках с использованием StreamAPI. */
        String[] anArrayOfLetters = enteringStrings();
        searchForLetters(anArrayOfLetters);

        /** Task 2
         Для любого набора случайно-сгенерированных чисел нужно
         определить количество четных. Посчитать их общую сумму.
         Для решения задачи использовать Stream API. */
//        Set<Integer> numbers = randomNumbers();
//        numberOfEven(numbers);
//        totalSumOfNumbers(numbers);

        /** Task 3
         Задано множество фамилий сотрудников. Разработать программу,
         которая отображает все фамилии, начинающиеся на букву «J».
         Задачу решить с использованием Stream API. */
//        Set<Employee> set = surnameOfEmployees();
//        selection(set);

        /** Task 4
         Задан массив строк. Используя средства StreamAPI
         отсортировать строки в лексикографическом порядке. */
//        sortedLexicographically();
    }
    static String[] enteringStrings() {
        System.out.println("Введите набор строк");
        return scr.nextLine().split("");
    }
    static void searchForLetters (String[] array) {
//        System.out.println("Какая буква интересует?");
//        for (int i = 0; i < array.length; i++) {
//            String letter = scr.next();
//            long result = Arrays.stream(array)
//                    .filter((x) -> x.equals(letter))
//                    .count();
//            System.out.printf("Количество повторений буквы %s - %d. ", letter, result);
//            System.out.println("Какая буква следующая?");
//        }
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l",
            "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        System.out.println("Количество повторений букв:");
        for (int j = 0; j < alphabet.length; j++) {
            String let = alphabet[j];
            long result = Arrays.stream(array)
                    .filter(x -> x.equalsIgnoreCase(let))
                    .count();
            System.out.printf("%s - %d\n", let, result);
        }
    }
    static Set<Integer> randomNumbers () {
        Random rnd = new Random();
        Set<Integer> num = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            num.add(rnd.nextInt(50));
        }
        return num;
    }
    static void numberOfEven (Set<Integer> numbers) {
        long count = numbers.stream()
                .filter(x -> x % 2 == 0)
                .count();
        System.out.printf("Количество чётных чисел = %d", count);
    }
    static void totalSumOfNumbers (Set<Integer> numbers) {
        int result = numbers.stream()
                .mapToInt(s -> Integer.parseInt(String.valueOf(s)))
                .sum();
        System.out.printf("\nОбщая сумма сгенерированных чисел = %d", result);
    }
    static Set<Employee> surnameOfEmployees () {
        Set<Employee> set = new HashSet<>();
        set.add(new Employee("Petrov"));
        set.add(new Employee("James"));
        set.add(new Employee("Ivanov"));
        set.add(new Employee("Johnson"));
        set.add(new Employee("Jones"));
        return set;
    }
    static void selection (Set<Employee> set) {
        System.out.println();
        set.stream()
                .filter(x -> x.getSurname().startsWith("J"))
                .forEach(s -> System.out.print(s + ", "));
    }
    static void sortedLexicographically() {
        System.out.println();
        String[] str = new String[]{"hello", "world", "aaa", "cvc"};
        Arrays.stream(str)
                .sorted()
                .forEach(s -> System.out.println(s));
    }
}