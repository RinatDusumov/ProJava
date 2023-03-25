package lessonTelRan.lesson18.lessonCode;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamCode {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        int[] arr2 = Arrays.stream(arr)
                .map(x->x+10)
                .toArray();

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

        Stream<String> aaa = Stream.of("1","2","3");
        String[] bbb = aaa.toArray(x -> new String[x]);

        System.out.println(Arrays.toString(bbb));


        Stream<Integer> intStream1 = Arrays.asList(1,2,3,4,5).stream();
        Stream<Integer> intStream2 = Arrays.asList(10,20,30,40,50).stream();

        System.out.println(Stream.concat(intStream1, intStream2).toList());
    }
}