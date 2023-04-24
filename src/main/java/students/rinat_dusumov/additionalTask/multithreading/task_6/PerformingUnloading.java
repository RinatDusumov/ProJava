package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.List;
import java.util.Map;

public class PerformingUnloading implements Runnable{
    PlannedWorks plannedWorks;
    List<MerchantShip> listOfShips;
    Map<Integer,Integer> forUnloading;
    public PerformingUnloading(PlannedWorks plannedWorks, List<MerchantShip> listOfShips, Map<Integer, Integer> forUnloading) {
        this.plannedWorks = plannedWorks;
        this.listOfShips = listOfShips;
        this.forUnloading = forUnloading;
    }

    @Override
    public void run() {
        boolean isThereAnyFreeSpace = plannedWorks.checkForAvailabilityOfSpace(forUnloading);
        if (isThereAnyFreeSpace) {
            for (MerchantShip merchantShip : listOfShips) {
                plannedWorks.unloading(merchantShip, forUnloading);
                plannedWorks.increaseInGoodsInStock(forUnloading);
            }
        }
    }
}
