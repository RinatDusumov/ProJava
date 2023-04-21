package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.Map;

public class LoadingThread implements Runnable {
    private static final Wharf wharf = new Wharf();
    private static final Object lock_2 = new Object();

    @Override
    public void run() {
        loading();
    }

    void loading() {
        synchronized (lock_2) {
            for (MerchantShip merchantShip : PortDemo.getAllShipsOnTheMoorings()) {
                if (merchantShip.getContainersOfLoading() > 0) {
                    for (Map.Entry<Integer, Integer> entryMerchantShip : merchantShip.getContainerAccounting().entrySet()) {
                        for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                            for (Map.Entry<Integer, Integer> freePlace : PortDemo.getAmountOfFreeSpace().entrySet()) {
                                for (Map.Entry<Integer, Integer> cargo_for_loading : merchantShip.getAccountingOfContainersForLoading().entrySet()) {
                                    if (entryMerchantShip.getKey().equals(cargo_for_loading.getKey()) &&
                                            cargo_for_loading.getValue() <= inStock.getValue()) {
                                        do {
                                            entryMerchantShip.setValue(cargo_for_loading.getValue());
                                            freePlace.setValue(freePlace.getValue() + cargo_for_loading.getValue());
                                            merchantShip.setTotalNumberOfContainers(merchantShip.getTotalNumberOfContainers() +
                                                    cargo_for_loading.getValue());
                                            merchantShip.setTotalWeightOfContainers(merchantShip.getTotalWeightOfContainers() +
                                                    (cargo_for_loading.getValue() * cargo_for_loading.getKey()));
                                            wharf.availabilityControl();
                                        } while (merchantShip.getTotalWeightOfContainers() <= merchantShip.getCarryingCapacity());
                                    }
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("Грузоподъёмность была превышена!");
                }
            }
        }
    }
}