package lessonTelRan.lesson17.streamExample2;

import java.util.Arrays;

public class FlatMapExample2 {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4,5},{6,7,8,9,10}};

        int countArray = 0;
        for (int[] arr1 : arr) {
            for (int element : arr1) {
                countArray++;
            }
        }
        System.out.println(countArray);

        int[] bigData = new int[countArray];
        int counter = 0;
        for (int[] arr1 : arr) {
            for (int element : arr1) {
                bigData[counter] = element;
                counter++;
            }
        }
        System.out.println(Arrays.toString(bigData));

        int[] newArr = Arrays.stream(arr)
                .flatMapToInt(x -> Arrays.stream(x))
                .toArray();
        System.out.println(Arrays.toString(newArr));
    }
}