package lessonTelRan.lesson_24.lessoncode;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] newArray = {1, 2, 3};
        int[] newArray2 = {4, 5, 6};
        System.out.println(Arrays.equals(newArray, newArray2));
        newArray.toString(); /** массив наследуется от класса Object */

        int[][] array1 = {{1,2,3,4}, {5,6}};
        int[][] array2 = {{1,2,3,4}, {5,6}};

        /** метод для глубокого сравнения только двумерных массивов */
        Arrays.deepEquals(array1, array2);
    }
}
