package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.List;
import java.util.Map;

public class ToPerformADownload implements Runnable {
    PlannedWorks plannedWorks;
    List<MerchantShip> listOfShips;
    Map<Integer, Integer> forDownload;

    public ToPerformADownload(PlannedWorks plannedWorks, List<MerchantShip> listOfShips, Map<Integer, Integer> forDownload) {
        this.plannedWorks = plannedWorks;
        this.listOfShips = listOfShips;
        this.forDownload = forDownload;
    }

    @Override
    public void run() {
        for (MerchantShip merchantShip : listOfShips) {
            if (merchantShip.getTotalWeightAfterLoading() <= merchantShip.getCarryingCapacity()) {
                plannedWorks.loading(merchantShip, forDownload);
                plannedWorks.reductionOfGoodsInStock(forDownload);
            } else {
                System.out.println("Грузоподъёмность торгового судна - " + merchantShip.getShipName() + ", была превышена!");
            }
        }
    }
}