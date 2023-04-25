package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.Map;

public class PerformingUnloading implements Runnable {
    PlannedWorks plannedWorks;
    MerchantShip merchantShip;
    Map<Integer, Integer> forUnloading;

    public PerformingUnloading(PlannedWorks plannedWorks, MerchantShip merchantShip, Map<Integer, Integer> forUnloading) {
        this.plannedWorks = plannedWorks;
        this.merchantShip = merchantShip;
        this.forUnloading = forUnloading;
    }

    @Override
    public void run() {
        plannedWorks.unloading(merchantShip, forUnloading);
        plannedWorks.increaseInGoodsInStock(forUnloading);

    }
}