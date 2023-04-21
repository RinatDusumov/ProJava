package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.Map;

public class UnloadingThread implements Runnable{
    private static final Wharf wharf = new Wharf();
    private static final Object lock_2 = new Object();
    private final LoadingThread loading = new LoadingThread();
    @Override
    public void run() {
        unloading();
    }
    void unloading() {
        synchronized (lock_2) {
            for (MerchantShip merchantShip : PortDemo.getAllShipsOnTheMoorings()) {
                if (merchantShip.getUnloadingContainers() > 0) {
                    for (Map.Entry<Integer, Integer> entryMerchantShip : merchantShip.getAccountingOfContainersForUnloading().
                            entrySet()) {
                        for (Map.Entry<Integer, Integer> freePlace : PortDemo.getAmountOfFreeSpace().entrySet()) {
                            if (entryMerchantShip.getKey().equals(freePlace.getKey()) &&
                                    entryMerchantShip.getValue() < freePlace.getValue()) {
                                freePlace.setValue(freePlace.getValue() - entryMerchantShip.getValue());
                                entryMerchantShip.setValue(0);
                                wharf.availabilityControl();
                            }
                        }
                    }
                    if (merchantShip.getContainersOfLoading() > 0) {
                        loading.loading();
                    }
                }
            }
        }
    }
}