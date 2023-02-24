package lessonTelRan.lesson14.mapExamples;

import java.util.Arrays;
import java.util.HashMap;

/**
 *  Проверьте, равны ли два массива или нет
 * Учитывая два массива, arr1 и arr2 одинаковой длины N,
 * задача состоит в том, чтобы определить, равны ли данные массивы или нет.
 *
 * Два массива называются равными, если:
 * оба они содержат один и тот же набор элементов,
 * расположение (или перестановки) элементов может/не может быть одинаковым.
 * Если есть повторения, то количество повторяющихся элементов также
 * должно быть одинаковым, чтобы два массива были равны.
 *
 * Ввод: arr1[] = {1, 2, 5, 4, 0}, arr2[] = {2, 4, 5, 0, 1}
 * Вывод: Да
 */
public class Example4 {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 5, 4, 0};
        int[] b = new int[] {2, 4, 5, 0, 1};

//        System.out.println(areEqual(a, b));
        System.out.println(areEqualMoreEffectively(a, b));
    }
    public static boolean areEqual(int[] arr1, int[] arr2) {
        /**
         * Временная сложность: O(N*log(N))
         * Вспомогательное пространство: O(1)
         */
        /** if length of arrays are not equal */
        // если длина массивов не равна
        if (arr1.length != arr2.length) {
            return false;
        }
        /** sort both arrays */
        // сортировка обоих массивов
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        /** linearly compare elements */
        // линейное сравнение элементов
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2.length) {
                return false;
            }
        }
        /** otherwise */
        // иначе
        return true;
    }
    public static boolean areEqualMoreEffectively (int[] arr1, int[] arr2) {
        /**
         * Сначала проверьте, не равна ли длина arr1 длине arr2, затем верните false.
         * Затем перейдите по первому массиву и сохраните количество каждого элемента в хэш-карте.
         * Затем перейдите ко второму массиву и уменьшите количество его элементов в хэш-карте. Если этот элемент
         * отсутствует или количество этого элемента равно нулю в хэш-карте, верните false, иначе уменьшите количество
         * этого элемента.
         * Верните true в конце, так как оба массива на данный момент равны.
         */
        /**
         * Временная сложность: O(N)
         * Вспомогательное пространство: O(N)
         */
        /** if length of arrays are not equal */
        // если длина массивов не равна
        if (arr1.length != arr2.length) {
            return false;
        }

        /** Store arr1[] elements and their counts in hash map */
        // Храните элементы arr1[] и их количество в хэш-карте
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (map.get(arr1[i]) == null) {
                map.put(arr1[i], null);
            } else {
                count = map.get(arr1[i]);
                count++;
                map.put(arr1[i], count);
            }
        }
        /**
         * Traverse arr2[] elements and check if all elements of arr2[]
         * are present same number of times or not.
         */
        /*
        Пройдитесь по элементам arr2[] и проверьте, присутствуют ли все
        элементы arr2[] одинаковое количество раз или нет.
         */
        for (int i = 0; i < arr2.length; i++) {
            if (!map.containsKey(arr2[i])){
                return false;
            }
            if (map.get(arr2[i]) == 0) {
                return false;
            }
            count = map.get(arr2[i]);
            --count;
            map.put(arr2[i], count);
        }
        return true;
    }
}
