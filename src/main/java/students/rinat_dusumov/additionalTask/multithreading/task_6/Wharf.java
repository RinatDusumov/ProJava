package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Wharf implements Runnable {
    private static final Object lock = new Object();
    private static final Scanner scr = new Scanner(System.in);
    private final Map<Integer, Integer> accounting = new HashMap<>();
    private final Map<Integer, Integer> forDownload = new HashMap<>();
    private final Map<Integer, Integer> forUnloading = new HashMap<>();
    private int sumNumberOfContainers = 0;
    private int sumWeightOfContainers = 0;


    @Override
    public void run() {
        registration();
    }

    void unloading(MerchantShip merchantShip, Map.Entry<Integer, Integer> forUnloading) {
        synchronized (lock) {
            for (Map.Entry<Integer, Integer> entryMerchantShip : merchantShip.getContainerAccounting().entrySet()) {
                for (Map.Entry<Integer, Integer> freePlace : PortDemo.getAmountOfFreeSpace().entrySet()) {
                    if ((forUnloading.getKey().equals(freePlace.getKey()) &&
                            forUnloading.getValue() < freePlace.getValue()) &&
                            forUnloading.getKey().equals(entryMerchantShip.getKey())) {
                        PortDemo.amountOfFreeSpace.put(freePlace.getKey(), freePlace.getValue() - forUnloading.getValue());
                        entryMerchantShip.setValue(entryMerchantShip.getValue() - forUnloading.getValue());
                        for (Map.Entry<Integer, Integer> terminalLimit : PortDemo.getCargoTerminalCapacity().entrySet()) {
                            for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                                if (terminalLimit.getKey().equals(inStock.getKey())) {
                                    PortDemo.stockAvailability.put(inStock.getKey(), terminalLimit.getValue() -
                                            freePlace.getValue());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void loading(MerchantShip merchantShip, Map.Entry<Integer, Integer> forDownload) {
        synchronized (lock) {
            if (merchantShip.getTotalWeightOfContainers() <= merchantShip.getCarryingCapacity()) {
                for (Map.Entry<Integer, Integer> entryMerchantShip : merchantShip.getContainerAccounting().entrySet()) {
                    for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                        if ((inStock.getKey().equals(forDownload.getKey()) &&
                                forDownload.getValue() <= inStock.getValue()) &&
                                forDownload.getKey().equals(entryMerchantShip.getKey())) {
                            PortDemo.stockAvailability.put(inStock.getKey(), inStock.getValue() + forDownload.getValue());
                            entryMerchantShip.setValue(entryMerchantShip.getValue() + forDownload.getValue());
                        }
                    }
                }
            }
        }
    }

    void registration() {
        synchronized (lock) {
            String shipName = getting_a_name();
            int carryingCapacity = obtaining_maximum_load_capacity();
            classificationOfContainers();
            for (Map.Entry<Integer, Integer> account : accounting.entrySet()) {
                for (Map.Entry<Integer, Integer> forDownload : forDownload.entrySet()) {
                    for (Map.Entry<Integer, Integer> forUnloading : forUnloading.entrySet()) {
                        PortDemo.getAllShipsOnTheMoorings().add(new MerchantShip(shipName, carryingCapacity,
                                account.getKey(), account.getValue(), sumNumberOfContainers,
                                sumWeightOfContainers, forDownload.getKey(), forDownload.getValue(),
                                forUnloading.getKey(), forUnloading.getValue()));
                    }
                }
            }
            System.out.println("Торговое судно - " + shipName + " зарегистрировано и ожидает на причале " +
                    Thread.currentThread().getName());
            distribution();
        }
    }

    void distribution() {
        for (MerchantShip merchantShip : PortDemo.getAllShipsOnTheMoorings()) {
            for (Map.Entry<Integer, Integer> unloading : merchantShip.getForUnloading().entrySet()) {
                if (unloading.getValue() > 0) {
                    unloading(merchantShip, unloading);
                }
            }
            for (Map.Entry<Integer, Integer> download : merchantShip.getForDownload().entrySet()) {
                if (download.getValue() > 0) {
                    loading(merchantShip, download);
                }
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
            System.out.println("Укажите количество контейнеров для разгрузки");
            int quantityForUnloading = scr.nextInt();
            System.out.println("Укажите количество контейнеров для загрузки");
            int quantityToDownload = scr.nextInt();
            accounting.put(containerWeight, numberOfContainers);
            sumNumberOfContainers += numberOfContainers;
            sumWeightOfContainers += (containerWeight * numberOfContainers);
            forDownload.put(containerWeight, quantityToDownload);
            forUnloading.put(containerWeight, quantityForUnloading);
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