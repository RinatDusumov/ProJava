package lessonTelRan.basicsOOP.lesson2.animals;

public class AnimalDemo {
    public static void main(String[] args) {
        Fish firstAnimal = new Fish();
        Dog secondAnimal = new Dog();
        Worm thirdAnimal = new Worm();

        firstAnimal.breath();
        secondAnimal.breath();
        thirdAnimal.breath();

        System.out.println();

        Animal[] animals = {
                firstAnimal,
                secondAnimal,
                thirdAnimal
        };
        System.out.println(firstAnimal.isEatable());
        for (int i = 0; i < animals.length; i++) {
            Animal currentAnimal = animals[i];
            currentAnimal.breath();
        }
    }
}
