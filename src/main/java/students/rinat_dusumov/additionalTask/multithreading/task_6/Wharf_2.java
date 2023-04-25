package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wharf_2 implements Runnable{
    private final VesselRegistration vesselRegistration;
    public final PlannedWorks plannedWorks;
    private Map<Integer, Integer> forUnloading = new HashMap<>();
    private Map<Integer, Integer> forDownload = new HashMap<>();
    public Wharf_2(VesselRegistration vesselRegistration, PlannedWorks plannedWorks) {
        this.vesselRegistration = vesselRegistration;
        this.plannedWorks = plannedWorks;
    }

    @Override
    public void run() {
        List<MerchantShip> listOfShips = vesselRegistration.registration();
        gettingUnloadingAndLoadingLists();
        commencementOfWork(listOfShips);
    }
    private void gettingUnloadingAndLoadingLists() {
        for (int i = 0; i < 4; i++) {
            forUnloading = vesselRegistration.receivingDataForOffloading(forUnloading);
            forDownload = vesselRegistration.gettingDataToLoad(forDownload);
        }
    }
    private void commencementOfWork(List<MerchantShip> listOfShips) {
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