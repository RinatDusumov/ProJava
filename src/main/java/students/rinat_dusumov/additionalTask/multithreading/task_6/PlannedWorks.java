package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class PlannedWorks {
    private final Object lock_2 = new Object();
    private static final Scanner scr = new Scanner(System.in);

    static int gettingTheNumberOfMerchantShips() {
        System.out.print("Количество кораблей? - ");
        return scr.nextInt();

    }

    boolean comparisonWithTheLimit(Map.Entry<Integer, Integer> unloading, Map.Entry<Integer, Integer> terminalLimit) {
        return Objects.equals(unloading.getKey(), terminalLimit.getKey());
    }

    boolean checkForAvailabilityOfSpace(Map.Entry<Integer, Integer> unloading) {
        boolean emptySpaces = false;
        for (Map.Entry<Integer, Integer> terminalLimit : PortDemo.getCargoTerminalCapacity().entrySet()) {
            if (comparisonWithTheLimit(unloading, terminalLimit)) {
                for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                    if (unloading.getKey().equals(inStock.getKey()) && (terminalLimit.getValue() -
                            inStock.getValue()) >= unloading.getValue()) {
                        emptySpaces = true;
                        break;
                    }
                }
            }
        }
        return emptySpaces;
    }

    boolean checkForThePresenceOfCargo(Map.Entry<Integer, Integer> download) {
        boolean isThereAProduct = false;
        for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
            if (download.getKey().equals(inStock.getKey()) && inStock.getValue() >= download.getValue()) {
                isThereAProduct = true;
                break;
            }

        }
        return isThereAProduct;
    }

    void unloading(MerchantShip merchantShip, Map<Integer, Integer> forUnloading) {
        synchronized (lock_2) {
            for (Map.Entry<Integer, Integer> unloading : forUnloading.entrySet()) {
                if (checkForAvailabilityOfSpace(unloading)) {
                    increaseInGoodsInStock(unloading);
                    performanceOfUnloadingOperations(merchantShip, unloading);
                    lock_2.notify();
                } else {
                    try {
                        lock_2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock_2.notify();
                }
            }
        }
    }

    void increaseInGoodsInStock(Map.Entry<Integer, Integer> unloading) {
        for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
            if (unloading.getKey().equals(inStock.getKey())) {
                inStock.setValue(unloading.getValue() + inStock.getValue());
                break;
            }
        }
    }

    void performanceOfUnloadingOperations(MerchantShip merchantShip, Map.Entry<Integer, Integer> unloading) {
        for (Map.Entry<Integer, Integer> ship : merchantShip.getPresenceOnTheVessel().entrySet()) {
            if (unloading.getKey().equals(ship.getKey())) {
                ship.setValue(ship.getValue() - unloading.getValue());
            }
        }
    }

    void loading(MerchantShip merchantShip, Map<Integer, Integer> forDownload) {
        synchronized (lock_2) {
            for (Map.Entry<Integer, Integer> download : forDownload.entrySet()) {
                if (checkForThePresenceOfCargo(download)) {
                    reductionOfGoodsInStock(download);
                    executionOfLoadingWorks(merchantShip, download);
                    lock_2.notify();
                } else {
                    try {
                        lock_2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock_2.notify();
                }
            }
        }
    }

    void reductionOfGoodsInStock(Map.Entry<Integer, Integer> download) {
        for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
            if (download.getKey().equals(inStock.getKey())) {
                inStock.setValue(inStock.getValue() - download.getValue());
                break;
            }
        }
    }

    void executionOfLoadingWorks(MerchantShip merchantShip, Map.Entry<Integer, Integer> download) {
        for (Map.Entry<Integer, Integer> ship : merchantShip.getPresenceOnTheVessel().entrySet()) {
            if (download.getKey().equals(ship.getKey())) {
                ship.setValue(ship.getValue() + download.getValue());
            }
        }
    }
}