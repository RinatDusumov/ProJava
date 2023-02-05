package lessonTelRan.lesson12;

public class WrapperExample {
    public static void main(String[] args) {
        int x = 5;
        Integer xInt = x;

        int newX = xInt.intValue();

        String str = "11";
        int b = Integer.parseInt(str);

        System.out.println(Integer.toBinaryString(xInt));
        System.out.println(Integer.toHexString(xInt));
    }
}
