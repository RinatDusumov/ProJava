package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.*;

public class MerchantShip {
    private final String shipName;
    private final String nameThread;
    private final int carryingCapacity; // грузоподъёмность (kg)
    private final Map<Integer, Integer> presenceOnTheVessel; // наличие на судне
    private final int totalNumberOfContainers; // общее количество
    private final int totalWeightOfContainers; // общий вес
    private int totalWeightAfterLoading = 0;
    private Map<Integer, Integer> forUnloading = new HashMap<>();
    private Map<Integer, Integer> forDownload = new HashMap<>();

    public Map<Integer, Integer> getForUnloading() {
        return forUnloading;
    }

    public void setForUnloading(Map<Integer, Integer> forUnloading) {
        this.forUnloading = forUnloading;
    }

    public Map<Integer, Integer> getForDownload() {
        return forDownload;
    }

    public void setForDownload(Map<Integer, Integer> forDownload) {
        this.forDownload = forDownload;
    }

    public String getShipName() {
        return shipName;
    }

    public int getTotalWeightOfContainers() {
        return totalWeightOfContainers;
    }

    public void setTotalWeightAfterLoading(int totalWeightAfterLoading) {
        this.totalWeightAfterLoading = totalWeightAfterLoading;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public Map<Integer, Integer> getPresenceOnTheVessel() {
        return presenceOnTheVessel;
    }

    public int getTotalWeightAfterLoading() {
        return totalWeightAfterLoading;
    }

    public MerchantShip(String nameThread, String shipName, int carryingCapacity,
                        Map<Integer, Integer> presenceOnTheVessel, int totalNumberOfContainers,
                        int totalWeightOfContainers) {
        this.shipName = shipName;
        this.nameThread = nameThread;
        this.carryingCapacity = carryingCapacity;
        this.presenceOnTheVessel = presenceOnTheVessel;
        this.totalNumberOfContainers = totalNumberOfContainers;
        this.totalWeightOfContainers = totalWeightOfContainers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchantShip that = (MerchantShip) o;
        return carryingCapacity == that.carryingCapacity && totalNumberOfContainers == that.totalNumberOfContainers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carryingCapacity, totalNumberOfContainers);
    }

    @Override
    public String toString() {
        return "MerchantShip{" +
                "shipName='" + shipName + '\'' +
                ", nameThread='" + nameThread + '\'' +
                ", carryingCapacity=" + carryingCapacity +
                ", presenceOnTheVessel=" + presenceOnTheVessel +
                ", totalNumberOfContainers=" + totalNumberOfContainers +
                ", totalWeightOfContainers=" + totalWeightOfContainers +
                '}';
    }
}