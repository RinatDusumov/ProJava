package lessonTelRan.lesson_28.multithreading;

public class Example2 {
    public static void main(String[] args) {
        /**
         * Поиск всех простых чисел в диапазоне до 1_000_000
         */
        int count = 0;
        long timeStart = System.currentTimeMillis();

        for (int i = 2; i < 1_000_000; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("Total numbers of prime: " + count);
        System.out.println("Time: " + (timeEnd - timeStart));
    }
}
