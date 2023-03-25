package lessonTelRan.lesson18.output;

public class ArrayExamplePrint {

    public static void main(String[] args) {
        int[][] arr = {{10,20,30},{100,200,300},{1000,2000,3000}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%10.4s", arr[i][j] +" ");
            }
            System.out.println();
        }
    }
}

