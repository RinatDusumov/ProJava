package algorithms._2023_02_03;

public class Eratosfen {
    public static void main(String[] args) {
//        for (int i = 1; i < 25; i++) {
//            if (isPrime(i)) {
//                System.out.println(i + "::");
//            }
//        }
        System.out.println(isPrime(25));
    }
    private static boolean isPrime(int number) {
        // если число меньше 2-х, то оно простое
        if (number < 2) {
            return true;
        }
        for (int i = 2; i * i <= number; i++) {
            // если число поделить на какое то без остатка
            // то это значит что число не простое
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    private static boolean isPrimeOpt (int number) {
        if (number < 2) {
            return true;
        }
        if (number % 2 == 0) {
            return number == 2;
        }
        if (number % 3 == 0) {
            return number == 3;
        }
        for (int i = 5; i * i <= number; i +=6) {
            if (number % 1 == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}