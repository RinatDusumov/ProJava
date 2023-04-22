package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Wharf implements Runnable {
    private static final Object lock = new Object();
    private static final Scanner scr = new Scanner(System.in);
    private final Map<Integer, Integer> accounting = new HashMap<>();
    private int sumNumberOfContainers = 0;
    private int sumWeightOfContainers = 0;

    @Override
    public void run() {
        registration();
    }

    void unloading(MerchantShip merchantShip) {
        for (Map.Entry<Integer, Integer> entryMerchantShip : merchantShip.getContainerAccounting().entrySet()) {
            for (Map.Entry<Integer, Integer> freePlace : PortDemo.getAmountOfFreeSpace().entrySet()) {
                if (entryMerchantShip.getKey().equals(freePlace.getKey()) &&
                        entryMerchantShip.getValue() < freePlace.getValue()) {
                    controlOfAvailabilityOfPlacesDuringUnloading(freePlace, entryMerchantShip);
                    entryMerchantShip.setValue(0);
                }
            }
        }
    }

    void controlOfAvailabilityOfPlacesDuringUnloading(Map.Entry<Integer, Integer> freePlace,
                                                      Map.Entry<Integer, Integer> entryMerchantShip) {
        synchronized (lock) {
            if (PortDemo.amountOfFreeSpace.containsKey(freePlace.getKey())) {
                PortDemo.amountOfFreeSpace.put(freePlace.getKey(), freePlace.getValue() - entryMerchantShip.getValue());

                for (Map.Entry<Integer, Integer> terminalLimit : PortDemo.getCargoTerminalCapacity().entrySet()) {
                    for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                        if (terminalLimit.getKey().equals(inStock.getKey())) {
                            inStock.setValue(terminalLimit.getValue() - freePlace.getValue());
                        }
                    }
                }
            }
        }
    }

    void monitoringTheAvailabilityOfSeatsWhenLoading(Map.Entry<Integer, Integer> inStock,
                                                     Map.Entry<Integer, Integer> cargo_for_loading) {
        synchronized (lock) {
            if (cargo_for_loading.getKey().equals(inStock.getKey())) {
                inStock.setValue(inStock.getValue() + cargo_for_loading.getValue());
                for (Map.Entry<Integer, Integer> terminalLimit : PortDemo.getCargoTerminalCapacity().entrySet()) {
                    for (Map.Entry<Integer, Integer> freePlace : PortDemo.getAmountOfFreeSpace().entrySet()) {
                        if (terminalLimit.getKey().equals(inStock.getKey())) {
                            freePlace.setValue(terminalLimit.getValue() - inStock.getValue());
                            System.out.println(PortDemo.amountOfFreeSpace);
                        }
                    }
                }
            }
        }
    }
    void loading(MerchantShip merchantShip) {
        // сколько нужно загрузить
        synchronized (this) {
            classificationOfContainers();
            merchantShip.setTotalNumberOfContainers(sumNumberOfContainers);
            merchantShip.setTotalWeightOfContainers(sumWeightOfContainers);
        }

        if (merchantShip.getTotalWeightOfContainers() <= merchantShip.getCarryingCapacity()) {
            for (Map.Entry<Integer, Integer> entryMerchantShip : merchantShip.getContainerAccounting().entrySet()) {
                for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                    for (Map.Entry<Integer, Integer> cargo_for_loading : accounting.entrySet()) { // груз для загрузки
                        if (entryMerchantShip.getKey().equals(cargo_for_loading.getKey()) &&
                                cargo_for_loading.getValue() <= inStock.getValue()) {
                            do {
                                entryMerchantShip.setValue(entryMerchantShip.getValue() + cargo_for_loading.getValue());
                                monitoringTheAvailabilityOfSeatsWhenLoading(inStock, cargo_for_loading);
                            } while (merchantShip.getTotalWeightOfContainers() <= merchantShip.getCarryingCapacity());
                            System.out.println("Судно загружено");
                        }
                    }
                }
            }
        }
    }

    synchronized void registration() {
        synchronized (lock) {
            String shipName = getting_a_name();
            int carryingCapacity = obtaining_maximum_load_capacity();
            classificationOfContainers();
            for (Map.Entry<Integer, Integer> account : accounting.entrySet()) {
                PortDemo.getAllShipsOnTheMoorings().add(new MerchantShip(shipName, carryingCapacity,
                        account.getKey(), account.getValue(), sumNumberOfContainers, sumWeightOfContainers));
            }
            System.out.println("Торговое судно - " + shipName + " зарегистрировано и ожидает на причале " +
                    Thread.currentThread().getName());
            distribution();
        }
    }

    void distribution() {
        for (MerchantShip merchantShip : PortDemo.getAllShipsOnTheMoorings()) {
                if (merchantShip.getTotalNumberOfContainers() > 0) {
                    unloading(merchantShip);
                }
                if (merchantShip.getTotalNumberOfContainers() == 0) {
                    loading(merchantShip);
                }

        }
    }

    private void classificationOfContainers() {
        int containerWeight;
        int numberOfContainers;
        for (int i = 0; i < 4; i++) {
            System.out.println("Укажите вес группы (1500, 3000, 5000, 10000)");
            containerWeight = scr.nextInt();
            System.out.println("Количество контейнеров на судне в указанной выше группе?");
            numberOfContainers = scr.nextInt();
            accounting.put(containerWeight, numberOfContainers);
            sumNumberOfContainers += numberOfContainers;
            sumWeightOfContainers += (containerWeight * numberOfContainers);
        }
    }

    private int obtaining_maximum_load_capacity() {
        System.out.println("Максимальная грузоподъёмность корабля?");
        return scr.nextInt();
    }

    private String getting_a_name() {
        System.out.println("Укажите название корабля.");
        return scr.next();
    }
}