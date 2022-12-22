package lessonProJava.lesson5.lessonCode;

import java.util.Random;

/*
*   Напишите программу, в которой:
* - создайте массив целых чисел длиной 3
* - заполните каждую ячейку массива любым целым числом
* - выведите значение каждой ячейки на кансоль
 */
public class Lesson5 {
    public static void main(String[] args) {
        Lesson5 lesson5Code = new Lesson5();
        int arraySize = 3;
        int[] workingArray = lesson5Code.establishing(arraySize);
        lesson5Code.fillIn(workingArray);

        lesson5Code.output(workingArray);
    }
    public int[] establishing(int arraySize) {
        return new int[arraySize];
    }
    public void fillIn(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            //arr[i] = (int) (Math.random() * 10);
            arr[i] = random.nextInt(100);
        }
    }
    public void output(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + " array element - " + arr[i]);
        }
    }
}
