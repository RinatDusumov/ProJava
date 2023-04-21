package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.Map;
import java.util.Objects;

class MerchantShip {
    private final String shipName;
    private final int carryingCapacity; // грузоподъёмность (kg)
    private Map<Integer, Integer> containerAccounting; // вес и количество контейнеров на корабле
    private volatile Map<Integer,Integer> accountingOfContainersForUnloading;
    private volatile Map<Integer,Integer> accountingOfContainersForLoading;
    private int totalNumberOfContainers; // общее количество
    private int totalWeightOfContainers; // общий вес
    private final int unloadingContainers;
    private final int containersOfLoading;

    public int getUnloadingContainers() {
        return unloadingContainers;
    }

    public int getContainersOfLoading() {
        return containersOfLoading;
    }

    Map<Integer, Integer> getAccountingOfContainersForUnloading() {
        return accountingOfContainersForUnloading;
    }

    Map<Integer, Integer> getAccountingOfContainersForLoading() {
        return accountingOfContainersForLoading;
    }

    public MerchantShip(String shipName, int carryingCapacity,
                        Map<Integer, Integer> containerAccounting, int totalNumberOfContainers,
                        int totalWeightOfContainers,
                        Map<Integer,Integer> accountingOfContainersForUnloading,
                        Map<Integer,Integer> accountingOfContainersForLoading, int unloadingContainers,
                        int containersOfLoading) {
        this.shipName = shipName;
        this.carryingCapacity = carryingCapacity;
        this.containerAccounting = containerAccounting;
        this.totalNumberOfContainers = totalNumberOfContainers;
        this.totalWeightOfContainers = totalWeightOfContainers;
        this.accountingOfContainersForLoading = accountingOfContainersForLoading;
        this.accountingOfContainersForUnloading = accountingOfContainersForUnloading;
        this.unloadingContainers = unloadingContainers;
        this.containersOfLoading = containersOfLoading;
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