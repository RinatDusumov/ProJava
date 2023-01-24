package udemy.collection.iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* listiterator расширяет возможности простого iterator,
   в котором можно работать не только со следующим элементом
   но и с предыдущим тоже с помощью метода hasPrevious()
 */

// задача с проверкой на палиндром
public class ListIteratorExample {
    public static void main(String[] args) {
        String s = "Madam";
        List<Character> list = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            list.add(ch);
        }
        ListIterator<Character> iter = list.listIterator(); // начинается с нуля
        ListIterator<Character> reverseIter = list.listIterator(list.size());

        boolean isPalindrome = true;
        while (iter.hasNext() && reverseIter.hasPrevious()) {
            if (iter.next() != reverseIter.previous()) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not palindrome");
        }
    }
}
