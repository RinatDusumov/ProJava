package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.Map;

public class ToPerformADownload implements Runnable {
    PlannedWorks plannedWorks;
    MerchantShip merchantShip;
    Map<Integer, Integer> forDownload;

    public ToPerformADownload(PlannedWorks plannedWorks, MerchantShip merchantShip, Map<Integer, Integer> forDownload) {
        this.plannedWorks = plannedWorks;
        this.merchantShip = merchantShip;
        this.forDownload = forDownload;
    }

    @Override
    public void run() {
        forTheDownloadDepartment(merchantShip);
    }

    void forTheDownloadDepartment(MerchantShip merchantShip) {
        if (merchantShip.getTotalWeightAfterLoading() <= merchantShip.getCarryingCapacity()) {
            plannedWorks.loading(merchantShip, forDownload);
            plannedWorks.reductionOfGoodsInStock(forDownload);
        } else {
            final VesselRegistration vesselRegistration = new VesselRegistration();
            System.out.println("Грузоподъёмность торгового судна - " + merchantShip.getShipName() + ", была превышена!");
            for (int i = 0; i < 4; i++) {
                forDownload = vesselRegistration.gettingDataToLoad(forDownload, merchantShip);
            }
            forTheDownloadDepartment(merchantShip);
        }
    }
}