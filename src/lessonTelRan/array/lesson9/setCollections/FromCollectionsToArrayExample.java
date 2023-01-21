package lessonTelRan.array.lesson9.setCollections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FromCollectionsToArrayExample {
    public static void main(String[] args) {
        String[] stringArray = new String[5];

        stringArray[0] = "January";
        stringArray[1] = "February";
        stringArray[2] = "March";
        stringArray[3] = "April";
        stringArray[4] = "May";

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();
        Set<String> set4 = new HashSet<>();
        Set<String> set5 = new HashSet<>();

        set1 = convertArrayToSet(stringArray);
        set2 = convertArrayToSetWithArraysMethod(stringArray);
        set3 = convertArrayToSetWithCollectionsMethod(stringArray);
        set4 = convertArrayToSetWithSetMethod(stringArray);
        set5 = convertArrayToSetWithStream(stringArray);

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
        System.out.println(set4);
        System.out.println(set5);

        for (String str : set3) {
            System.out.print(str);
        }


        System.out.println(convertArrayToSet(stringArray));
        System.out.println(convertArrayToSetWithArraysMethod(stringArray));
        System.out.println(convertArrayToSetWithCollectionsMethod(stringArray));
        System.out.println(convertArrayToSetWithSetMethod(stringArray));
        System.out.println(convertArrayToSetWithStream(stringArray));
        // каждый последующий метод выполняет реализацию одного действия
    }
    public static Set<String> convertArrayToSet (String[] workingArray) {
        Set<String> setForReturn = new HashSet<>();
        for (int i = 0; i < workingArray.length; i++) {
            setForReturn.add(workingArray[i]);
        }
        return setForReturn;
    }
    public static Set<String> convertArrayToSetWithArraysMethod (String[] workingArray) {
        Set<String> setForReturn = new HashSet<>(Arrays.asList(workingArray));

        return setForReturn;
    }

    public static Set<String> convertArrayToSetWithCollectionsMethod (String[] workingArray) {
        Set<String> setForReturn = new HashSet<>();
        Collections.addAll(setForReturn, Arrays.toString(workingArray));

        return setForReturn;
    }

    public static Set<String> convertArrayToSetWithSetMethod (String[] workingArray) {
        Set<String> setForReturn = new HashSet<>(Set.of(workingArray));
        return setForReturn;
    }

    public static Set<String> convertArrayToSetWithStream (String[] workingArray) {
        Set<String> setForReturn = new HashSet<>();
        setForReturn = Arrays.stream(workingArray).collect(Collectors.toSet());
        return setForReturn;
    }
}
