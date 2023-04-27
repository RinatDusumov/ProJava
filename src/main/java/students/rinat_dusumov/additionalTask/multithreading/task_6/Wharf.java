package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wharf implements Runnable {
    private final VesselRegistration vesselRegistration;
    private final PlannedWorks plannedWorks;
    private Map<Integer, Integer> forUnloading = new HashMap<>();
    private Map<Integer, Integer> forDownload = new HashMap<>();

    public Wharf(VesselRegistration vesselRegistration, PlannedWorks plannedWorks) {

        this.vesselRegistration = vesselRegistration;
        this.plannedWorks = plannedWorks;
    }
    @Override
    public void run() {
        List<MerchantShip> listOfShips = vesselRegistration.registration();
        for (MerchantShip merchantShip : listOfShips) {
            gettingUnloadingAndLoadingLists(merchantShip);
            try {
                commencementOfWork(merchantShip);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void gettingUnloadingAndLoadingLists(MerchantShip merchantShip) {
        for (int i = 0; i < 4; i++) {
            forUnloading = vesselRegistration.receivingDataForOffloading(forUnloading, merchantShip);
            forDownload = vesselRegistration.gettingDataToLoad(forDownload, merchantShip);
        }
    }

    private void commencementOfWork(MerchantShip merchantShip) throws InterruptedException {
        Thread unloading = new Thread(() -> plannedWorks.unloading(merchantShip, forUnloading));
        Thread download = new Thread(() -> plannedWorks.forTheDownloadDepartment(merchantShip, forDownload));
        unloading.start();
        download.start();
        unloading.join();
        download.join();
    }
}