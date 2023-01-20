package lessonTelRan.array.lesson8.arrays;

import java.util.Arrays;

public class ArraysCloneExample {
    public static void main(String[] args) {
        String[] stringArray = new String[5];

        stringArray[0] = "1";
        stringArray[1] = "2";
        stringArray[2] = "3";
        stringArray[3] = "4";
        stringArray[4] = "5";

        System.out.println(Arrays.toString(stringArray));

        String[] stringArraryDublicate = stringArray.clone();
        // всегда нужно клонировать ссылочные переменные для сохранения оригинальных данных

        stringArraryDublicate[3] = "12";
        System.out.println("------------");

        System.out.println(Arrays.toString(stringArray));
        System.out.println(Arrays.toString(stringArraryDublicate));

        System.out.println("-------------");

        Dog[] ourKannel = new Dog[5];

        System.out.println(ourKannel);

        ourKannel[0] = new Dog("Tusik");
        ourKannel[1] = new Dog("Bobik");
        ourKannel[2] = ourKannel[1];
        ourKannel[3] = new Dog("Arlekin");

        System.out.println(Arrays.toString(ourKannel));

        System.out.println("-------------");

        System.out.println(Arrays.toString(stringArray));

        clearArray(stringArraryDublicate);
        System.out.println(Arrays.toString(stringArraryDublicate));
        System.out.println(Arrays.toString(stringArray));
    }
    public static void clearArray(String[] arrayString) {
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = "";
        }
    }
}
