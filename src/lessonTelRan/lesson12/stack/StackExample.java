package lessonTelRan.lesson12.stack;

import java.util.Stack;

public class StackExample {
    // последний зашел, первый вышел
    /* stack необходимы для решения задач когда нужно обратиться к
        вершине stack и получить информацию о том, что там есть.
     */

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("I");
        stack.push("love");
        stack.push("Java");

        System.out.println(stack);

        System.out.println(stack.search("I")); // глубина элемента

        // peek() обращается
        System.out.println("The element at the top of the stack is: " + stack.peek());
        System.out.println(stack);

        System.out.println("Pop element " + stack.pop()); // извлечение
        System.out.println(stack);

        System.out.println(stack.empty()); // пустой ли?
    }
}
