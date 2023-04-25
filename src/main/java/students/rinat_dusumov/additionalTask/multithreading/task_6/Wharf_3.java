package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wharf_3 implements Runnable{
    VesselRegistration vesselRegistration;
    PlannedWorks plannedWorks;

    public Wharf_3(VesselRegistration vesselRegistration, PlannedWorks plannedWorks) {
        this.vesselRegistration = vesselRegistration;
        this.plannedWorks = plannedWorks;
    }

    @Override
    public void run() {
        List<MerchantShip> listOfShips = vesselRegistration.registration();
        Map<Integer, Integer> forUnloading = new HashMap<>();
        Map<Integer, Integer> forDownload = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            forUnloading = vesselRegistration.receivingDataForOffloading(forUnloading);
            forDownload = vesselRegistration.gettingDataToLoad(forDownload);
        }

        Thread unloading = new Thread(new PerformingUnloading(plannedWorks, listOfShips, forUnloading));
        Thread download = new Thread(new ToPerformADownload(plannedWorks, listOfShips, forDownload));

        unloading.start();
        download.start();
        try {
            unloading.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            download.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}