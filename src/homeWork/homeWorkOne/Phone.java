package homeWork.homeWorkOne;

public class Phone extends Person {
    private int number;
    private String model;
    private int weight;

    public Phone (int number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Phone {" +
                "number = " + number +
                ", model = '" + model + '\'' +
                ", weight = " + weight +
                '}';
    }
    void receiveCall() {
        String name = "Nameless третий";
        System.out.printf("Звонит %s", name +
                ". Номер телефона " + getNumber() + "\n");
    }
    int getNumber() {
        return number;
    }
}
