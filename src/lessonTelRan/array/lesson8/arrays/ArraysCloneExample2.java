package lessonTelRan.array.lesson8.arrays;

import java.util.Arrays;

public class ArraysCloneExample2 {
    public static void main(String[] args) {
        String[][] stringArray = new String[3][3];

        stringArray[0][0] = "0 0";
        stringArray[0][1] = "0 1";
        stringArray[0][2] = "0 2";

        stringArray[1][0] = "1 0";
        stringArray[1][1] = "1 1";
        stringArray[1][2] = "1 2";

        stringArray[2][0] = "2 0";
        stringArray[2][1] = "2 1";
        stringArray[2][2] = "2 2";

        System.out.println(Arrays.deepToString(stringArray));
        // преобразование в строку двумерного массива
    }
}
