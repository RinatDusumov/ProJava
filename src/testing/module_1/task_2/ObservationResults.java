package testing.module_1.task_2;

public class ObservationResults {
    public static void main(String[] args) {
        Pterodactyls pterodactyls = new Pterodactyls();
        Lizards lizards = new Lizards();
        Birds birds = new Birds();
        pterodactyls.wayToTravel();
        birds.wayToTravel();
        lizards.wayToTravel();
    }
}