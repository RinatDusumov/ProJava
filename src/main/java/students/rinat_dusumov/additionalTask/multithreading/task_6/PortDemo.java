package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.HashMap;
import java.util.Map;

public class PortDemo {
    static volatile Map<Integer, Integer> cargoTerminalCapacity = new HashMap<>(); // вес и количество по лимиту на терминале
    static volatile Map<Integer, Integer> stockAvailability = new HashMap<>(); // наличие на складе

    public static Map<Integer, Integer> getCargoTerminalCapacity() {
        return cargoTerminalCapacity;
    }

    public static Map<Integer, Integer> getStockAvailability() {
        return stockAvailability;
    }

    public static void main(String[] args) {
        cargoTerminalCapacity.put(1500, 100_000);
        cargoTerminalCapacity.put(5000, 100_000);
        cargoTerminalCapacity.put(3000, 100_000);
        cargoTerminalCapacity.put(10000, 100_000);

        stockAvailability.put(1500,0);
        stockAvailability.put(3000,0);
        stockAvailability.put(5000,0);
        stockAvailability.put(10000,0);

        VesselRegistration vesselRegistration = new VesselRegistration();

        Wharf_1 wharf_1 = new Wharf_1(vesselRegistration);
        Wharf_2 wharf_2 = new Wharf_2(vesselRegistration);
        Wharf_3 wharf_3 = new Wharf_3(vesselRegistration);

        Thread thread1 = new Thread(wharf_1, "Wharf_1");
        Thread thread2 = new Thread(wharf_2, "Wharf_2");
        Thread thread3 = new Thread(wharf_3, "Wharf_3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}