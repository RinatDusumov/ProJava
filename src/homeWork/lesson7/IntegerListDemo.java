package homeWork.lesson7;

import java.util.ArrayList;

public class IntegerListDemo {
    public static void main(String[] args) {
        // task 1
        int[] number = {45,3,21,3,65,3,78};
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            numberList.add(i, number[i]);
        }

        numberList.add(0,7);
        Integer newNumber = 55;
        numberList.add(newNumber);

        int lengthList = numberList.size();

        numberList.remove(1);
        numberList.remove(newNumber);

//        if (numberList.size() != 0) {
//            System.out.println("Список не пустой");
//        }
        System.out.println(numberList.isEmpty());

        for (int i : numberList) {
            System.out.print(i + " ");
        }
        System.out.println();

        // task 2
        boolean possibility_Of_Storing_Duplicates = false;
        for (int i = 0; i < numberList.size(); i++) {
            for (int j = 1; j < numberList.size(); j++) {
                if(i == j) continue;
                if (numberList.get(i).equals(numberList.get(j))) {
                    possibility_Of_Storing_Duplicates = true;
                }
            }
        }
        System.out.println("Могут ли реализации интерфейса java.util.List хранить одинаковые " +
                "элементы (дубликаты)? - " + possibility_Of_Storing_Duplicates);
    }
}
