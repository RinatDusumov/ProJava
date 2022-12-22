package lesson.basicsOOP.lesson3.enum2;

public class TestEnum {
    public static void main(String[] args) {
        Color color = Color.RED;
        System.out.println(color);

        AlternativEnum alternativEnum = new AlternativEnum();
        System.out.println(alternativEnum.getColorRed());
    }
}
