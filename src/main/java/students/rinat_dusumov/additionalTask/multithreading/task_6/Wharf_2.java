package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.List;
import java.util.Map;

public class Wharf_2 implements Runnable{
    VesselRegistration vesselRegistration;

    public Wharf_2(VesselRegistration vesselRegistration) {
        this.vesselRegistration = vesselRegistration;
    }

    @Override
    public void run() {
        List<MerchantShip> listOfShips = vesselRegistration.registration();
        Map<Integer, Integer> forUnloading = null;
        Map<Integer, Integer> forDownload = null;
        for (int i = 0; i < 4; i++) {
            forUnloading = vesselRegistration.receivingDataForOffloading();
            forDownload = vesselRegistration.gettingDataToLoad();
        }

        PlannedWorks plannedWorks = new PlannedWorks();
        Thread unloading = new Thread(new PerformingUnloading(plannedWorks, listOfShips, forUnloading));
        Thread download = new Thread(new ToPerformADownload(new PlannedWorks(), listOfShips, forDownload));

        unloading.start();
        download.start();
    }
}