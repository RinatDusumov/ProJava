package lessonTelRan.array.lesson5;

import java.util.Arrays;
import java.util.Random;

public class SearchInArray {
    public static void main(String[] args) {
        Random random = new Random();
        SearchInArray searchInArray = new SearchInArray();


        int[] workingArray = searchInArray.createArray();

        System.out.println(Arrays.toString(workingArray));

        int[] sortedArray = searchInArray.sortedArray(workingArray);
        /* System.arraycopy (копирует источник,его начальный элемент, куда, также начальный элемент, количество копируемых элементов);
        System.arraycopy(workingArray, 0, sortedArray, 0, workingArray.length);
        Arrays.sort(sortedArray);
         */
        System.out.println(Arrays.toString(sortedArray));

        int element = random.nextInt(25);
        System.out.println("Element for search - " + element);
        System.out.println("Index in array - " + searchInArray.searchIndex(sortedArray, element));
    }
    public int[] createArray() {
        //int[] workingArray = {6,4,332,546,3,5,767,89,67};
        Random random = new Random();
        int sizeArray = random.nextInt(10);
        int[] workingArray = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            workingArray[i] = random.nextInt(25);
        }
        return workingArray;
    }
    public int[] sortedArray(int[] workingArray) {
        int[] sortedArray = new int[workingArray.length];
        System.arraycopy(workingArray, 0, sortedArray, 0, workingArray.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }
    public static int searchIndex (int[] arrayForSearch, int element) {
        int index = -1;
        for (int i = 0; i < arrayForSearch.length; i++) {
            if (element == arrayForSearch[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
