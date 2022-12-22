package lesson.array.lesson5;
// метод бинарного поиска или золотого сечения (деление на пополам)
public class BinarSearch {
    public static void main(String[] args) {
        int[] values = {1,1,2,3,4,10};
        int valueToFind = 3;
        System.out.printf("Index = %d%n", binarySearch(values, valueToFind, 0, values.length));
    }
    private  static int binarySearch(int[] sortedArray, int valueToFind, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < valueToFind) {
                low = mid + 1;
            } else if (sortedArray[mid] > valueToFind) {
                high = mid - 1;
            } else if (sortedArray[mid] == valueToFind) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
