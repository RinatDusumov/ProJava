package lesson.basicsOOP.lesson4.example3;

import com.sun.source.tree.NewArrayTree;

public class AnimalTest {
    public static void main(String[] args) {
        NewAnimal newAnimal = new NewAnimal();
        NewAnimal newDog = new NewDog();

        newAnimal.move();
        newDog.move();
    }
}
