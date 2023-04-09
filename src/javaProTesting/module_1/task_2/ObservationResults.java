package javaProTesting.module_1.task_2;

import java.util.*;

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