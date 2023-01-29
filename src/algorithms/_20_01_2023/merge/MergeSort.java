package algorithms._20_01_2023.merge;

/*  метод писать наиболее упрощённым, разбивая его на отельные методы
    взаимодействующие друг с другом.
 */

// merge более памятнозатратно нежели quick, но при большом кол-ве элементов merge работает быстрее
// O(log n)

import java.util.Random;

public class MergeSort {
    static  int[] array = new int[100_000_000];

    public static void main(String[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            array[i] = new Random().nextInt(100_000_000);
        }
        //System.out.println(arrayToString(array));
        long time = System.currentTimeMillis();
        array = mergeSort(array);
        System.out.println(System.currentTimeMillis() - time);
    }

    public static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] currentSourse = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSourse, i, currentSourse, i + size, currentDest, i, size);
            }
            tmp = currentSourse;
            currentSourse = currentDest;
            currentDest = tmp;

            size = size * 2;
        }
        return  currentSourse;
    }
    private static String arrayToString (int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
    private static void merge (int[] src1, int src1Start, int[] src2, int src2Start,
                               int[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        if (src1Start + size > src1.length) {
            for (int i = src1Start; i < src1End; i++) {
                dest[i] = src1[i];
            }
            return;
        }
        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }
}
