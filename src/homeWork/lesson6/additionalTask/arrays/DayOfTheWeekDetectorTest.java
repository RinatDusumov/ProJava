package homeWork.lesson6.additionalTask.arrays;

public class DayOfTheWeekDetectorTest {
    public static void main(String[] args) {
        DayOfTheWeekDetectorTest test = new DayOfTheWeekDetectorTest();
        test.shouldReturnMonday();
    }
    public void shouldReturnMonday(){
        DayOfTheWeekDetector detector = new DayOfTheWeekDetector();
        String dayOfTheWeek = detector.findDayOfTheWeek(1);
        checkTestResult("Monday".equals(dayOfTheWeek), "Monday");

        String dayOfTheWeek2 = detector.findDayOfTheWeek(2);
        checkTestResult("Tuesday".equals(dayOfTheWeek2), "Tuesday");

        String dayOfTheWeek3 = detector.findDayOfTheWeek(3);
        checkTestResult("Wednesday".equals(dayOfTheWeek3), "Wednesday");

        String dayOfTheWeek4 = detector.findDayOfTheWeek(4);
        checkTestResult("Thursday".equals(dayOfTheWeek4), "Thursday");

        String dayOfTheWeek5 = detector.findDayOfTheWeek(5);
        checkTestResult("Friday".equals(dayOfTheWeek5), "Friday");

        String dayOfTheWeek6 = detector.findDayOfTheWeek(6);
        checkTestResult("Saturday".equals(dayOfTheWeek6), "Saturday");

        String dayOfTheWeek7 = detector.findDayOfTheWeek(35);
        checkTestResult("Sunday".equals(dayOfTheWeek7), "Sunday");
    }
    private void checkTestResult(boolean condition, String testName) {
        if (condition) {
            System.out.println(testName + " = Ok!");
        } else {
            System.out.println("Not correct day number");
        }
    }
}
