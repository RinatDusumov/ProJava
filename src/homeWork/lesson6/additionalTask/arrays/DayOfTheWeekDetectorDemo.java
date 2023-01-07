package homeWork.lesson6.additionalTask.arrays;

import java.util.Scanner;

public class DayOfTheWeekDetectorDemo {
    public static void main(String[] args) {
        DayOfTheWeekDetector detector = new DayOfTheWeekDetector();
        int dayNumber = detector.getDayNumberFromUser();

        String dayOfTheWeek = detector.findDayOfTheWeek(dayNumber);
        System.out.println(dayOfTheWeek);
    }
}

