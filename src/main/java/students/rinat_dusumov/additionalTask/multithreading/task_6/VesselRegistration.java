package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.*;

public class VesselRegistration {
    private static final Object lock = new Object();
    private static final Scanner scr = new Scanner(System.in);
    private int sumNumberOfContainers = 0;
    private int sumWeightOfContainers = 0;
    private volatile int loadWeight = 0;

    List<MerchantShip> registration() {
        synchronized (lock) {
            String shipName = getting_a_name();
            int carryingCapacity = obtaining_maximum_load_capacity();
            Map<Integer,Integer> goodsOnTheShip = classificationOfContainers();

            List<MerchantShip> listOfShips = new LinkedList<>();
            listOfShips.add(new MerchantShip(Thread.currentThread().getName(),
                    shipName, carryingCapacity, goodsOnTheShip, sumNumberOfContainers,
                    sumWeightOfContainers));

            outputOfTheRegistrationResult(shipName, Thread.currentThread().getName());

            return listOfShips;
       }
    }
    private String getting_a_name() {
        System.out.println("Укажите название текущего торгового судна.");
        return scr.next();
    }
    private int obtaining_maximum_load_capacity() {
        System.out.println("Максимальная грузоподъёмность корабля?");
        return scr.nextInt();
    }
    private Map<Integer,Integer> classificationOfContainers() {
        Map<Integer, Integer> goodsOnTheShip = new HashMap<>();     // товар на судне
        int containerWeight;
        int numberOfContainers;
        System.out.println("Вес контейнеров и количество на корабле");
        for (int i = 0; i < 4; i++) {
            containerWeight = weightInput();
            numberOfContainers = quantityInput();

            goodsOnTheShip.put(containerWeight, numberOfContainers);
            countingTheTotalNumberOfContainers(numberOfContainers);
            calculationOfTheTotalWeightOfContainers(containerWeight, numberOfContainers);
        }
        return goodsOnTheShip;
    }
    private int weightInput() {
        System.out.print("Укажите вес группы (1500, 3000, 5000, 10000) - ");
        return scr.nextInt();
    }
    private int quantityInput() {
        System.out.print("Укажите количество контейнеров - ");
        return scr.nextInt();
    }
    private void countingTheTotalNumberOfContainers (int numberOfContainers) {
        sumNumberOfContainers += numberOfContainers;
    }
    private void calculationOfTheTotalWeightOfContainers (int containerWeight, int numberOfContainers) {
        sumWeightOfContainers += (containerWeight * numberOfContainers);
    }

    Map<Integer, Integer> receivingDataForOffloading (Map<Integer,Integer> forUnloading, MerchantShip merchantShip) {
        synchronized (lock) {
            System.out.println("Данные для разгрузки судна - " + merchantShip.getShipName());
            int containerWeight = weightInput();
            System.out.print("Количество контейнеров - ");
            int quantityForUnloading = scr.nextInt();
            forUnloading.put(containerWeight, quantityForUnloading);
            return forUnloading;
        }
    }
    Map<Integer,Integer> gettingDataToLoad (Map<Integer, Integer> forDownload, MerchantShip merchantShip) {
        synchronized (lock) {
            System.out.println("Данные для загрузки судна - " + merchantShip.getShipName());
            int containerWeight = weightInput();
            System.out.print("Количество контейнеров - ");
            int quantityToDownload = scr.nextInt();
            forDownload.put(containerWeight, quantityToDownload);
            loadWeight += (containerWeight * quantityToDownload);
            calculationOfTheTotalWeightAfterLoading (merchantShip);
            return forDownload;
        }
    }
    void calculationOfTheTotalWeightAfterLoading (MerchantShip merchantShip) {
        merchantShip.setTotalWeightAfterLoading(merchantShip.getTotalWeightOfContainers() + loadWeight);
    }
    void outputOfTheRegistrationResult (String shipName, String nameThread) {
        System.out.println("Торговое судно - " + shipName + ", зарегистрировано и ожидает на причале " +
                nameThread);
    }
}