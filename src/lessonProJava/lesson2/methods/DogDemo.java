package lessonProJava.lesson2.methods;

public class DogDemo {
    public static void main(String[] args) {
        Dog tusik = new Dog();

        tusik.setBreed("taksa");
        Animal newDog = tusik.createAnimal("black", "tusik");
        tusik.setType(newDog);
    }
}
