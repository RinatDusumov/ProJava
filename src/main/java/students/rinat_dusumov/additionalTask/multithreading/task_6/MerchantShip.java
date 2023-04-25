package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.Map;
import java.util.Objects;

public class MerchantShip {
    private final String shipName;
    private final String nameThread;
    private final int carryingCapacity; // грузоподъёмность (kg)
    private final Map<Integer, Integer> presenceOnTheVessel; // наличие на судне
    private final int totalNumberOfContainers; // общее количество
    private final int totalWeightOfContainers; // общий вес
    private final int totalWeightAfterLoading;

    public String getShipName() {
        return shipName;
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
                        int totalWeightOfContainers, int totalWeightAfterLoading) {
        this.shipName = shipName;
        this.nameThread = nameThread;
        this.carryingCapacity = carryingCapacity;
        this.presenceOnTheVessel = presenceOnTheVessel;
        this.totalNumberOfContainers = totalNumberOfContainers;
        this.totalWeightOfContainers = totalWeightOfContainers;
        this.totalWeightAfterLoading = totalWeightAfterLoading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        main.java.students.rinat_dusumov.additionalTask.multithreading.task_6.MerchantShip that = (main.java.students.rinat_dusumov.additionalTask.multithreading.task_6.MerchantShip) o;
        return carryingCapacity == that.carryingCapacity && totalNumberOfContainers == that.totalNumberOfContainers &&
                totalWeightOfContainers == that.totalWeightOfContainers && Objects.equals(shipName, that.shipName) &&
                Objects.equals(nameThread, that.nameThread) && Objects.equals(presenceOnTheVessel, that.presenceOnTheVessel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipName, nameThread, carryingCapacity, presenceOnTheVessel, totalNumberOfContainers, totalWeightOfContainers);
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