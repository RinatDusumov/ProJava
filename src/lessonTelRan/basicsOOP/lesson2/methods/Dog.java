package lessonTelRan.basicsOOP.lesson2.methods;

public class Dog {
    private String breed;
    private Animal type;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Animal getType() {
        return type;
    }

    public void setType(Animal type) {
        this.type = type;
    }

    public void voice (String text) {
        System.out.println(text);
    }

    public Animal createAnimal (String color, String name) {
        Animal newAnimal = new Animal(color, name);
        return newAnimal;
    }
}
