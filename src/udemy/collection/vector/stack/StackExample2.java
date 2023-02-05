package udemy.collection.vector.stack;

import java.util.Stack;

public class StackExample2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // push() - вставляет элемент в конец (на самый верх)
        stack.push("Zaur");
        stack.push("Oleg");
        stack.push("Misha");
        stack.push("Katya");
        System.out.println(stack);

        /* pop() - возвращает элемент, который находится в самом конце
            и сразу этот элемент удаляет.
         */
        System.out.println(stack.pop());
        System.out.println(stack);

        // isEmpty - метод на проверку, пустой ли.
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
            System.out.println(stack);
        }

        /* peek() - возвращает элемент, который находится в самом конце,
            но не удаляет элемент (в отличии от pop()).
         */
        System.out.println(stack.peek());
    }
}
