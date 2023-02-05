package lessonTelRan.lesson12.deque;

import java.util.ArrayDeque;

public class DequeExample2 {
    public static void main(String[] args) {

        ArrayDeque<String> states = new ArrayDeque<>();

        states.add("Germany");
        System.out.println(states);
        states.addFirst("France");
        System.out.println(states);
        states.push("Greate Britain");
        System.out.println(states);
        states.addLast("Spain");
        System.out.println(states);
        states.add("Greece");

        System.out.println(states);

    }
}
