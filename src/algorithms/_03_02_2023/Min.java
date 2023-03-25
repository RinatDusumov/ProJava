package algorithms._03_02_2023;

public class Min {
    public static void getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int min2 = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min2 = min;
                min = arr[i];
            } else if (arr[i] < min2 && arr[i] != min) {
                min2 = arr[i];
            }
        }
        if(min2 != Integer.MAX_VALUE) {
            System.out.println("Min2: " + min2);
        } else {
            System.out.println("There isn't second min digit in the array");
        }
        System.out.println("Min: " + min);
    }
    public static void main(String[] args) {
        int[] arr = {12,0,3,6,5,47,89,65,41,2,36,54,8,52};
        getMin(arr);
    }
}
