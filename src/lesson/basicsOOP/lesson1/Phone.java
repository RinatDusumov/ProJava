package lesson.basicsOOP.lesson1;

public class Phone {
    private String model;
    private String color;
    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
