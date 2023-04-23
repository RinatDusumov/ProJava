package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class MerchantShip {
    private final String shipName;
    private final int carryingCapacity; // грузоподъёмность (kg)
    private Map<Integer, Integer> containerAccounting = new HashMap<>(); // вес и количество контейнеров на корабле
    private final Map<Integer, Integer> forDownload = new HashMap<>();
    private final Map<Integer,Integer> forUnloading = new HashMap<>();
    private int totalNumberOfContainers; // общее количество
    private int totalWeightOfContainers; // общий вес

    public Map<Integer, Integer> getForDownload() {
        return forDownload;
    }

    public Map<Integer, Integer> getForUnloading() {
        return forUnloading;
    }

    public MerchantShip(String shipName, int carryingCapacity,
                        int containerWeight, int numberOfContainers, int totalNumberOfContainers,
                        int totalWeightOfContainers, int forDownloadKey, int forDownloadValue,
                        int forUnloadingKey, int forUnloadingValue) {
        this.shipName = shipName;
        this.carryingCapacity = carryingCapacity;
        this.containerAccounting.put(containerWeight, numberOfContainers);
        this.totalNumberOfContainers = totalNumberOfContainers;
        this.totalWeightOfContainers = totalWeightOfContainers;
        this.forDownload.put(forDownloadKey,forDownloadValue);
        this.forUnloading.put(forUnloadingKey, forUnloadingValue);
    }

    public String getShipName() {
        return shipName;
    }

    public void setContainerAccounting(Map<Integer, Integer> containerAccounting) {
        this.containerAccounting = containerAccounting;
    }

    void setTotalNumberOfContainers(int totalNumberOfContainers) {
        this.totalNumberOfContainers = totalNumberOfContainers;
    }

    void setTotalWeightOfContainers(int totalWeightOfContainers) {
        this.totalWeightOfContainers = totalWeightOfContainers;
    }

    int getTotalWeightOfContainers() {
        return totalWeightOfContainers;
    }

    int getCarryingCapacity() {
        return carryingCapacity;
    }

    Map<Integer, Integer> getContainerAccounting() {
        return containerAccounting;
    }

    int getTotalNumberOfContainers() {
        return totalNumberOfContainers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchantShip that = (MerchantShip) o;
        return carryingCapacity == that.carryingCapacity && Objects.equals(shipName, that.shipName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipName, carryingCapacity);
    }

    @Override
    public String toString() {
        return "MerchantShip{" +
                "shipName='" + shipName + '\'' +
                ", carryingCapacity=" + carryingCapacity +
                ", containerAccounting=" + containerAccounting +
                ", totalNumberOfContainers=" + totalNumberOfContainers +
                ", totalWeightOfContainers=" + totalWeightOfContainers +
                '}';
    }
}