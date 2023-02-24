package lessonTelRan.lesson17.streamExample;

import java.util.Arrays;
import java.util.Collection;

class StreamFilter1 {
    private static void findAndSkipCount() {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1", "a10");
        System.out.println("findFirst and skip");
        String first = collection.stream().findFirst().orElse("Test 1");
        System.out.println("first element = " + first);

        String last = collection.stream().skip(collection.size() - 1).findAny().orElse("Test 2");
        System.out.println("last element = " + last);

        String a3Element = collection.stream().filter("a3"::equals).findFirst().get();
        System.out.println("a3 element = " + a3Element);

        String fourthElement = collection.stream().skip(3).findFirst().get();
        System.out.println("fourth element = " + fourthElement);
    }

    public static void main(String[] args) {
        findAndSkipCount();
    }
}