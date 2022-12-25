package lesson.basicsOOP.lesson4.example4ArrayObj;

import java.util.Arrays;

public class CatArrayDemo {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i * 5;
        }
        System.out.println(Arrays.toString(intArray));

        Cat[] catArray = new Cat[3];
        Cat cat1 = new Cat("barsik", "black");
        Cat cat2 = new Cat("murzik", "grey");
        Cat cat3 = new Cat("murka", "white");

        catArray[0] = cat1;
        catArray[1] = cat2;
        catArray[2] = cat3;

        Cat newCat = catArray[1];
        System.out.println(newCat.toString());
        System.out.println(Arrays.toString(catArray));

        Cat[] catArraySmall = {new Cat("barsik", "black"),
            new Cat("murzik", "grey")};

        System.out.println(catArraySmall[0].name);
        catArraySmall[1].meow();
    }
}
