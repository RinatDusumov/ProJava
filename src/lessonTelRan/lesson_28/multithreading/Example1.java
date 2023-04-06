package lessonTelRan.lesson_28.multithreading;

public class Example1 {
    public static void main(String[] args) {
        /**
         * Поиск всех целых чисел которые делятся на number без остатка
         */
        int number = 5;
        int count = 0;

        long timeStart = System.currentTimeMillis();
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            if (i % number == 0) {
                count++;
            }
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("Total divisible by " + number + ": " + count);
        System.out.println("Time: " + (timeEnd - timeStart));
    }
}
