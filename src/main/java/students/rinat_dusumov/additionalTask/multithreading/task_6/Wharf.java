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
        Thread unloading = new Thread(new PerformingUnloading(plannedWorks, merchantShip, forUnloading));
        Thread download = new Thread(new ToPerformADownload(plannedWorks, merchantShip, forDownload));

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
}