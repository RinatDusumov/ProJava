package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.*;

public class VesselRegistration {
    private static final Object lock = new Object();
    private static final Scanner scr = new Scanner(System.in);
    private final Map<Integer, Integer> goodsOnTheShip = new HashMap<>();     // товар на судне
    private int sumNumberOfContainers = 0;
    private int sumWeightOfContainers = 0;
    private int loadWeight = 0;

    MerchantShip registration() {
        synchronized (lock) {
            String shipName = getting_a_name();
            int carryingCapacity = obtaining_maximum_load_capacity();
            classificationOfContainers();
            MerchantShip merchantShip = new MerchantShip(Thread.currentThread().getName(),
                    shipName, carryingCapacity, goodsOnTheShip, sumNumberOfContainers,
                    sumWeightOfContainers);

            outputOfTheRegistrationResult(shipName);

            return merchantShip;
       }
    }
    private String getting_a_name() {
        System.out.println("\nУкажите название текущего торгового судна.");
        return scr.next();
    }
    private int obtaining_maximum_load_capacity() {
        System.out.println("Максимальная грузоподъёмность корабля?");
        return scr.nextInt();
    }
    private void classificationOfContainers() {
        System.out.println("Вес контейнеров и количество на корабле");
        for (int i = 0; i < 4; i++) {
            int containerWeight = weightInput();
            int numberOfContainers = quantityInput();
            goodsOnTheShip.put(containerWeight, numberOfContainers);
            sumNumberOfContainers += numberOfContainers;
            sumWeightOfContainers += (containerWeight * numberOfContainers);
        }
    }
    private int weightInput() {
        System.out.print("Укажите вес группы (1500, 3000, 5000, 10000) - ");
        return scr.nextInt();
    }
    private int quantityInput() {
        System.out.print("Укажите количество контейнеров - ");
        return scr.nextInt();
    }

    Map<Integer, Integer> receivingDataForOffloading (Map<Integer,Integer> forUnloading, MerchantShip merchantShip) {
        synchronized (lock) {
            System.out.println("Данные для разгрузки судна - " + merchantShip.getShipName());
            int containerWeight = weightInput();
            int quantityForUnloading = quantityInput();
            forUnloading.put(containerWeight, quantityForUnloading);
            return forUnloading;
        }
    }
    Map<Integer,Integer> gettingDataToLoad (Map<Integer, Integer> forDownload, MerchantShip merchantShip) {
        synchronized (lock) {
            System.out.println("Данные для загрузки судна - " + merchantShip.getShipName());
            int containerWeight = weightInput();
            int quantityToDownload = quantityInput();
            forDownload.put(containerWeight, quantityToDownload);
            calculationOfTheWeightOfTheLoadedCargo (containerWeight, quantityToDownload, merchantShip);
            return forDownload;
        }
    }
    void calculationOfTheWeightOfTheLoadedCargo (int containerWeight, int quantityToDownload, MerchantShip merchantShip) {
        loadWeight += (containerWeight * quantityToDownload);
        merchantShip.setTotalWeightAfterLoading(merchantShip.getTotalWeightOfContainers() + loadWeight);
    }
    void outputOfTheRegistrationResult (String shipName) {
        System.out.println("Торговое судно - " + shipName + ", зарегистрировано");
    }
}