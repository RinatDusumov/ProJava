package lessonTelRan.array.lesson5;

import java.util.Random;

public class LessonCode {
    // for (int elem : arrays);
    // for (int elem = 0; elem < arrays.length; elem++); (обращение к индексу)
    public static void main(String[] args) {
        LessonCode lesson5Code = new LessonCode();
        Random random = new Random();
        int arraySize = random.nextInt(50);

        int[] workingArray = lesson5Code.establishing(arraySize);
        lesson5Code.fillIn(workingArray);
        lesson5Code.output(workingArray);
        System.out.println("Increase each element: ");

        int[] arrayAfterIncrease = lesson5Code.increaseByTwo(workingArray);

        lesson5Code.output(arrayAfterIncrease);
        System.out.println("Original array");
        lesson5Code.output(workingArray);
    }


    public int[] establishing(int arraySize) {
        return new int[arraySize];
    }
    public void fillIn(int[] arr) {
        Random random2 = new Random();
        for (int i = 0; i < arr.length; i++) {
            //arr[i] = (int) (Math.random() * 10);
            arr[i] = random2.nextInt(100);
        }
    }
    public int[] increaseByTwo(int[] arr) {
        int[] arrayAfterIncrease = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrayAfterIncrease[i] = arr[i] * 2;
        }
        return arrayAfterIncrease;
    }
    public void output(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + " array element - " + arr[i]);
        }
    }
}
