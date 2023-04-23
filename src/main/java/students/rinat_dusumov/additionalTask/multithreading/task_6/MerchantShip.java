package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class MerchantShip {
    private final String shipName;
    private final String nameThread;
    private final int carryingCapacity; // грузоподъёмность (kg)
    private Map<Integer, Integer> presenceOnTheVessel = new HashMap<>(); // наличие на судне
    private final int totalNumberOfContainers; // общее количество
    private final int totalWeightOfContainers; // общий вес

    public String getNameThread() {
        return nameThread;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public int getTotalWeightOfContainers() {
        return totalWeightOfContainers;
    }

    Map<Integer, Integer> getPresenceOnTheVessel() {
        return presenceOnTheVessel;
    }

    public MerchantShip(String nameThread, String shipName, int carryingCapacity,
                        int key, int value, int totalNumberOfContainers,
                        int totalWeightOfContainers) {
        this.nameThread = nameThread;
        this.shipName = shipName;
        this.carryingCapacity = carryingCapacity;
        this.presenceOnTheVessel.put(key, value);
        this.totalNumberOfContainers = totalNumberOfContainers;
        this.totalWeightOfContainers = totalWeightOfContainers;
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
                ", containerAccounting=" + presenceOnTheVessel +
                ", totalNumberOfContainers=" + totalNumberOfContainers +
                ", totalWeightOfContainers=" + totalWeightOfContainers +
                '}';
    }
}