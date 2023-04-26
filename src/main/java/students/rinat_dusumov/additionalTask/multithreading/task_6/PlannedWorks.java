package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.Map;

public class PlannedWorks {
    private static final Object lock_2 = new Object();

    boolean comparisonWithTheLimit(Map.Entry<Integer, Integer> unloading, Map.Entry<Integer, Integer> terminalLimit) {
        boolean theKeysAreIdentical = false;
        if (unloading.getKey().equals(terminalLimit.getKey())) {
            theKeysAreIdentical = true;
        }
        return theKeysAreIdentical;
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
        for (Map.Entry<Integer, Integer> unloading : forUnloading.entrySet()) {
            if (checkForAvailabilityOfSpace(unloading)) {
                increaseInGoodsInStock(unloading);
                for (Map.Entry<Integer, Integer> ship : merchantShip.getPresenceOnTheVessel().entrySet()) {
                    if (unloading.getKey().equals(ship.getKey())) {
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

    void increaseInGoodsInStock(Map.Entry<Integer, Integer> unloading) {
        synchronized (lock_2) {
            for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                if (unloading.getKey().equals(inStock.getKey())) {
                    inStock.setValue(unloading.getValue() + inStock.getValue());
                    break;
                }
            }
        }
    }

    void loading(MerchantShip merchantShip, Map<Integer, Integer> forDownload) {
        for (Map.Entry<Integer, Integer> download : forDownload.entrySet()) {
            if (checkForThePresenceOfCargo(download)) {
                reductionOfGoodsInStock(download);
                for (Map.Entry<Integer, Integer> ship : merchantShip.getPresenceOnTheVessel().entrySet()) {
                    if (download.getKey().equals(ship.getKey())) {
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

    void reductionOfGoodsInStock(Map.Entry<Integer, Integer> download) {
        synchronized (lock_2) {
            for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                if (download.getKey().equals(inStock.getKey())) {
                    inStock.setValue(inStock.getValue() - download.getValue());
                    break;
                }
            }
        }
    }
}