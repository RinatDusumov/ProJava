package lessonTelRan.array.lesson7.shape.util;

import java.util.Scanner;

public class InputData {
    public double userInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter " + message + " -");
        double inputData = scanner.nextDouble();
        return inputData;
    }
    public double randomValue(int range) {
        double randomValue = Math.round((Math.random() + 0.01) * range * 1000) / 1000.0;
        return randomValue;
    }
}
