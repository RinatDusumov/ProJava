package lessonTelRan.lesson19.tryCath.lessonCode;

public class FinallyException {
    public static void main(String[] args) {
        int number = getNumber();
        System.out.println(number);
    }
    private static int getNumber() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
