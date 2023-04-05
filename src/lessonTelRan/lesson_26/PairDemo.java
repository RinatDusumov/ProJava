package lessonTelRan.lesson_26;

public class PairDemo {
    public static void main(String[] args) {
        PairInteger firstPairInteger  = new PairInteger(25,25);
        PairDouble secondPair = new PairDouble(20.5,100.75);

        PairUniversal<String, Integer> universalPair1 = new PairUniversal<>("Rustam", 25);
    }
}
