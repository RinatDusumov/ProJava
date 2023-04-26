package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.Map;

public class PlannedWorks {
    private static final Object lock_2 = new Object();

    boolean checkForAvailabilityOfSpace(Map.Entry<Integer, Integer> unloading) {
        boolean emptySpaces = false;
        for (Map.Entry<Integer, Integer> terminalLimit : PortDemo.getCargoTerminalCapacity().entrySet()) {
            for (Map.Entry<Integer, Integer> inStock : PortDemo.stockAvailability.entrySet()) {
                if (inStock.getKey().equals(unloading.getKey()) && (terminalLimit.getValue() -
                        inStock.getValue()) >= unloading.getValue()) {
                    emptySpaces = true;
                    break;
                }

            }
        }
        return emptySpaces;
    }

    boolean checkForThePresenceOfCargo(Map.Entry<Integer, Integer> download) {
        boolean isThereAProduct = false;
        for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
            if (inStock.getKey().equals(download.getKey()) && inStock.getValue() >= download.getValue()) {
                isThereAProduct = true;
                break;
            }

        }
        return isThereAProduct;
    }

    void unloading(MerchantShip merchantShip, Map<Integer, Integer> forUnloading) {
        for (Map.Entry<Integer, Integer> unloading : forUnloading.entrySet()) {
            if (checkForAvailabilityOfSpace(unloading)) {
                for (Map.Entry<Integer, Integer> ship : merchantShip.getPresenceOnTheVessel().entrySet()) {
                    if (ship.getKey().equals(unloading.getKey())) {
                        ship.setValue(ship.getValue() - unloading.getValue());
                    }
                }
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify();
            }
        }
    }

    void increaseInGoodsInStock(Map<Integer, Integer> forUnloading) {
        synchronized (lock_2) {
            for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                for (Map.Entry<Integer, Integer> unloading : forUnloading.entrySet()) {
                    if (inStock.getKey().equals(unloading.getKey())) {
                        inStock.setValue(unloading.getValue() + inStock.getValue());
                    }
                }
            }
        }
    }

    void loading(MerchantShip merchantShip, Map<Integer, Integer> forDownload) {
        for (Map.Entry<Integer, Integer> download : forDownload.entrySet()) {
            if (checkForThePresenceOfCargo(download)) {
                for (Map.Entry<Integer, Integer> ship : merchantShip.getPresenceOnTheVessel().entrySet()) {
                    if (ship.getKey().equals(download.getKey())) {
                        ship.setValue(ship.getValue() + download.getValue());
                    }
                }
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify();
            }
        }
    }

    void reductionOfGoodsInStock(Map<Integer, Integer> forDownload) {
        synchronized (lock_2) {
            for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                for (Map.Entry<Integer, Integer> download : forDownload.entrySet()) {
                    if (inStock.getKey().equals(download.getKey())) {
                        inStock.setValue(inStock.getValue() - download.getValue());
                    }
                }
            }
        }
    }
}