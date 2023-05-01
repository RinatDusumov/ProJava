package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Wharf implements Runnable {
    private static VesselRegistration vesselRegistration = null;
    private static PlannedWorks plannedWorks = null;
    private static final Object lock_4 = new Object();
    private final Semaphore numberOfSeats;
    private Map<Integer, Integer> forUnloading = new HashMap<>();
    private Map<Integer, Integer> forDownload = new HashMap<>();

    public Wharf(VesselRegistration vesselRegistrationValue, PlannedWorks plannedWorksValue, Semaphore numberOfSeats) {

        vesselRegistration = vesselRegistrationValue;
        plannedWorks = plannedWorksValue;
        this.numberOfSeats = numberOfSeats;
    }
    @Override
    public void run() {
        ExecutorService threadShips;
        synchronized (lock_4) {
            int numberOfShips = PlannedWorks.gettingTheNumberOfMerchantShips();
            threadShips = Executors.newFixedThreadPool(numberOfShips);
        }
        threadShips.execute(new Runnable() {
            @Override
            public void run() {
                List<MerchantShip> listOfShips = new LinkedList<>();
                try {
                    numberOfSeats.acquire();
                    synchronized (lock_4) {
                        listOfShips.add(vesselRegistration.registration());
                    }
                    for (MerchantShip merchantShip : listOfShips) {
                        gettingUnloadingAndLoadingLists(merchantShip);
                        commencementOfWork(merchantShip);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    numberOfSeats.release();
                }
            }
            private void gettingUnloadingAndLoadingLists (MerchantShip merchantShip){
                for (int i = 0; i < 4; i++) {
                    forUnloading = vesselRegistration.receivingDataForOffloading(forUnloading, merchantShip);
                    forDownload = vesselRegistration.gettingDataToLoad(forDownload, merchantShip);
                }
            }
            private void commencementOfWork (MerchantShip merchantShip) throws InterruptedException {
                ExecutorService unloading_download = Executors.newFixedThreadPool(2);
                unloading_download.execute(() -> plannedWorks.unloading(merchantShip,forUnloading));
                unloading_download.execute(() -> plannedWorks.forTheDownloadDepartment(merchantShip, forDownload));
                unloading_download.shutdown();
                unloading_download.awaitTermination(10, TimeUnit.MINUTES);
            }
        });
        threadShips.shutdown();
        try {
            threadShips.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}