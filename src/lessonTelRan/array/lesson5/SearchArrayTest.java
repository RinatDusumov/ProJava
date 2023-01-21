package lessonTelRan.array.lesson5;

import java.util.Arrays;

public class SearchArrayTest {
    public static void main(String[] args) {
        SearchInArray searchInArray = new SearchInArray();
        SearchArrayTest searchArrayTest = new SearchArrayTest();
        int[] workingArray = {6,4,332,546,3,5,767,89,67};
        int[] expectedSortResult = {3,4,5,6,67,89,332,546,767};
        int elementForSearch = 6;
        int expectedIndex = 3;

        int[] testSortResult = searchInArray.sortedArray(workingArray);

        if (searchArrayTest.isSortedCorrect(testSortResult, expectedSortResult)) {
            System.out.println("Test sorted array - correct");
        } else {
            System.out.println("Test sorted array - not correct");
            System.out.println("Expected " + Arrays.toString(expectedSortResult));
            System.out.println("But test result " + Arrays.toString(testSortResult));
        }

        int testIndexResult = searchInArray.searchIndex(testSortResult, elementForSearch);
        if (testIndexResult == expectedIndex) {
            System.out.println("Test index search - correct");
        } else {
            System.out.println("Test index search - not correct");
            System.out.println("Expected " + expectedIndex);
            System.out.println("But test result " + testIndexResult);
        }
    }
    public boolean isSortedCorrect(int[] testArray, int[] expectedArray) {
        boolean isTestCorrect = true;
        if (testArray.length != expectedArray.length) {
            isTestCorrect = false;
            return isTestCorrect;
        }
        for (int i = 0; i < testArray.length; i++) {
            if (testArray[i] == expectedArray[i]) {
                isTestCorrect = isTestCorrect && true;
            } else {
                isTestCorrect = isTestCorrect && false;
            }
        }
        return isTestCorrect;
    }
}
