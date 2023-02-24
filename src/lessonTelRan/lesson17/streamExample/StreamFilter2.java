package lessonTelRan.lesson17.streamExample;

import java.util.Arrays;
import java.util.Collection;

class StreamFilter2 {
    /**
     * anyMatch - true, если условие выполняется хотя бы для одного элемента.
     * allMatch - true, если условие выполняется для всех элементов.
     * noneMatch - true, если условие не выполняется ни для одного элемента.
     */
    private static void differentMatch() {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1", "a10", "a2", "a3", "a1");
        System.out.println("different match");

        boolean isAnyOne = collection.stream().anyMatch("a1"::equals);
        System.out.println("Any one is - " + isAnyOne);

        boolean isAll = collection.stream().allMatch(s -> s.contains("1"));
        System.out.println("isAll is - " + isAll);

        boolean isNotEquals = collection.stream().noneMatch("a5"::equals);
//        boolean isNotEquals = collection.stream().noneMatch(s -> s.contains("a"));
        System.out.println("isNotEquals is - " + isNotEquals);
    }

    public static void main(String[] args) {
        differentMatch();
    }
}