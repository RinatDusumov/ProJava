package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.Map;

public class PlannedWorks {
    private static final Object lock_2 = new Object();

    boolean checkForAvailabilityOfSpace(Map<Integer, Integer> forUnloading) {
        for (Map.Entry<Integer, Integer> terminalLimit : PortDemo.getCargoTerminalCapacity().entrySet()) {
            for (Map.Entry<Integer, Integer> inStock : PortDemo.stockAvailability.entrySet()) {
                for (Map.Entry<Integer, Integer> unloading : forUnloading.entrySet()) {
                    if (inStock.getKey().equals(unloading.getKey()) && (terminalLimit.getValue() -
                            inStock.getValue()) >= unloading.getValue()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean checkForThePresenceOfCargo(Map<Integer, Integer> forDownload) {
        for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
            for (Map.Entry<Integer, Integer> download : forDownload.entrySet()) {
                if (inStock.getKey().equals(download.getKey()) && inStock.getValue() >= download.getValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    void unloading(MerchantShip merchantShip, Map<Integer, Integer> forUnloading) {
        for (Map.Entry<Integer, Integer> ship : merchantShip.getPresenceOnTheVessel().entrySet()) {
            for (Map.Entry<Integer, Integer> unloading : forUnloading.entrySet()) {
                if (ship.getKey().equals(unloading.getKey())) {
                    ship.setValue(ship.getValue() - unloading.getValue());
                }
            }
        }
    }

    void increaseInGoodsInStock(Map<Integer, Integer> forUnloading) {
        synchronized (lock_2) {
            for (Map.Entry<Integer, Integer> unloading : forUnloading.entrySet()) {
                for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                    if (unloading.getKey().equals(inStock.getKey())) {
                        PortDemo.getStockAvailability().put(unloading.getKey(), unloading.getValue() +
                                inStock.getValue());
                    }
                }
            }
        }
    }
    void loading(MerchantShip merchantShip, Map<Integer, Integer> forDownload) {
        for (Map.Entry<Integer, Integer> ship : merchantShip.getPresenceOnTheVessel().entrySet()) {
            for (Map.Entry<Integer, Integer> download : forDownload.entrySet()) {
                if (ship.getKey().equals(download.getKey()) && merchantShip.getTotalWeightAfterLoading() <=
                        merchantShip.getCarryingCapacity()) {
                    ship.setValue(ship.getValue() + download.getValue());
                } else {
                    System.out.println("Грузоподъёмность была превышена!");
                }
            }
        }
    }
    void reductionOfGoodsInStock (Map<Integer, Integer> forDownload) {
        synchronized (lock_2) {
            for (Map.Entry<Integer, Integer> download : forDownload.entrySet()) {
                for (Map.Entry<Integer,Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                    if (download.getKey().equals(inStock.getKey())) {
                        PortDemo.getStockAvailability().put(download.getKey(), inStock.getValue() -
                                download.getValue());
                    }
                }
            }
        }
    }
}