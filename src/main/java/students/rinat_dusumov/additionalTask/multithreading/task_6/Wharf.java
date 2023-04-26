package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Wharf implements Runnable {
    private final VesselRegistration vesselRegistration;
    private Map<Integer, Integer> forUnloading = new HashMap<>();
    private Map<Integer, Integer> forDownload = new HashMap<>();
    private final Object lock_2 = new Object();

    public Wharf(VesselRegistration vesselRegistration) {

        this.vesselRegistration = vesselRegistration;
    }

    @Override
    public void run() {
        List<MerchantShip> listOfShips = vesselRegistration.registration();
        for (MerchantShip merchantShip : listOfShips) {
            gettingUnloadingAndLoadingLists(merchantShip);
            commencementOfWork(merchantShip);
        }
    }

    private void gettingUnloadingAndLoadingLists(MerchantShip merchantShip) {
        for (int i = 0; i < 4; i++) {
            forUnloading = vesselRegistration.receivingDataForOffloading(forUnloading);
            forDownload = vesselRegistration.gettingDataToLoad(forDownload, merchantShip);
        }
    }

    private void commencementOfWork(MerchantShip merchantShip) {
        Thread unloading = new Thread(() -> unloading(merchantShip, forUnloading));
        Thread download = new Thread(() -> forTheDownloadDepartment(merchantShip));
        unloading.start();
        download.start();
        try {
            unloading.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            unloading.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    void forTheDownloadDepartment(MerchantShip merchantShip) {
        if (merchantShip.getTotalWeightAfterLoading() <= merchantShip.getCarryingCapacity()) {
            loading(merchantShip, forDownload);
        } else {
            System.out.println("Грузоподъёмность торгового судна - " + merchantShip.getShipName() + ", была превышена!");
            for (int i = 0; i < 4; i++) {
                forDownload = vesselRegistration.gettingDataToLoad(forDownload, merchantShip);
            }
            forTheDownloadDepartment(merchantShip);
        }
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
        for (Map.Entry<Integer, Integer> unloading : forUnloading.entrySet()) {
            if (checkForAvailabilityOfSpace(unloading)) {
                increaseInGoodsInStock(unloading);
                performanceOfUnloadingOperations(merchantShip, unloading);
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
    void performanceOfUnloadingOperations (MerchantShip merchantShip, Map.Entry<Integer, Integer> unloading) {
        for (Map.Entry<Integer, Integer> ship : merchantShip.getPresenceOnTheVessel().entrySet()) {
            if (unloading.getKey().equals(ship.getKey())) {
                ship.setValue(ship.getValue() - unloading.getValue());
            }
        }
    }
    void loading(MerchantShip merchantShip, Map<Integer, Integer> forDownload) {
        for (Map.Entry<Integer, Integer> download : forDownload.entrySet()) {
            if (checkForThePresenceOfCargo(download)) {
                reductionOfGoodsInStock(download);
                executionOfLoadingWorks(merchantShip, download);
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
    void executionOfLoadingWorks (MerchantShip merchantShip, Map.Entry<Integer, Integer> download) {
        for (Map.Entry<Integer, Integer> ship : merchantShip.getPresenceOnTheVessel().entrySet()) {
            if (download.getKey().equals(ship.getKey())) {
                ship.setValue(ship.getValue() + download.getValue());
            }
        }
    }
}