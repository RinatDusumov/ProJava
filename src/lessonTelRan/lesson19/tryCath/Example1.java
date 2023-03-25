package lessonTelRan.lesson19.tryCath;

public class Example1 {
    public static void main(String[] args) {

        /*
        Если возникает ошибка, мы можем использовать try...catch, чтобы поймать ошибку и обработать ее
         */

        try {
            int[] numbers = new int[]{1, 2, 3};
            System.out.println(numbers[10]);
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            if (e.getMessage().contains("out of bounds")){
                System.out.println("CHECK ARRAY INDEX!!!!");
            }
            System.out.println("the catch block");
        } finally {
            System.out.println("After try-catch block");
        }


    }
}
