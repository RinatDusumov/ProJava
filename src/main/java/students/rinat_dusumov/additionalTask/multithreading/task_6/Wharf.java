package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Wharf implements Runnable {
    private static final Object lock = new Object();
    private static final Scanner scr = new Scanner(System.in);
    private final Map<Integer, Integer> accounting = new HashMap<>();
    private Map<Integer, Integer> forLoading = new HashMap<>();
    private Map<Integer, Integer> forUnloading = new HashMap<>();
    private int sumNumberOfContainers = 0;
    private int sumWeightOfContainers = 0;
    private int numberOfGroups;
    private int unloadingContainers;
    private int containersOfLoading;

    @Override
    public void run() {
        registration();
    }

    Map<Integer, Integer> getAccounting() {
        return accounting;
    }

    synchronized void unloading(MerchantShip merchantShip) {
        for (Map.Entry<Integer, Integer> entryMerchantShip : merchantShip.getContainerAccounting().entrySet()) {
            for (Map.Entry<Integer, Integer> freePlace : PortDemo.getAmountOfFreeSpace().entrySet()) {
                if (entryMerchantShip.getKey().equals(freePlace.getKey()) &&
                        entryMerchantShip.getValue() < freePlace.getValue()) {
                    freePlace.setValue(freePlace.getValue() - entryMerchantShip.getValue());
                    entryMerchantShip.setValue(0);
                    availabilityControl();
                }
            }
        }
    }

    synchronized void availabilityControl() {
        for (Map.Entry<Integer, Integer> terminalLimit : PortDemo.getCargoTerminalCapacity().entrySet()) {
            for (Map.Entry<Integer, Integer> freePlace : PortDemo.getAmountOfFreeSpace().entrySet()) {
                if (terminalLimit.getKey().equals(freePlace.getKey())) {
                    PortDemo.getStockAvailability().put(terminalLimit.getKey(),
                            terminalLimit.getValue() - freePlace.getValue());
                }
            }
        }
    }

    synchronized void loading(MerchantShip merchantShip) {
        classification_of_containers(); // сколько нужно загрузить
        merchantShip.setTotalNumberOfContainers(sumNumberOfContainers);
        merchantShip.setTotalWeightOfContainers(sumWeightOfContainers);

        if (merchantShip.getTotalWeightOfContainers() <= merchantShip.getCarryingCapacity()) {
            for (Map.Entry<Integer, Integer> entryMerchantShip : merchantShip.getContainerAccounting().entrySet()) {
                for (Map.Entry<Integer, Integer> inStock : PortDemo.getStockAvailability().entrySet()) {
                    for (Map.Entry<Integer, Integer> freePlace : PortDemo.getAmountOfFreeSpace().entrySet()) {
                        for (Map.Entry<Integer, Integer> cargo_for_loading : getAccounting().entrySet()) { // груз для загрузки
                            if (entryMerchantShip.getKey().equals(cargo_for_loading.getKey()) &&
                                    cargo_for_loading.getValue() <= inStock.getValue()) {
                                do {
                                    entryMerchantShip.setValue(cargo_for_loading.getValue());
                                    freePlace.setValue(freePlace.getValue() + cargo_for_loading.getValue());
                                    availabilityControl();
                                } while (merchantShip.getTotalWeightOfContainers() <= merchantShip.getCarryingCapacity());
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Грузоподъёмность была превышена!");
        }
    }

    void registration() {
        synchronized (lock) {
            String shipName = getting_a_name();
            int carryingCapacity = obtaining_maximum_load_capacity();
            classification_of_containers();
            PortDemo.getAllShipsOnTheMoorings().add(new MerchantShip(shipName, carryingCapacity,
                    getAccounting(), sumNumberOfContainers, sumWeightOfContainers, forUnloading, forLoading,
                    unloadingContainers, containersOfLoading));
            System.out.println("Торговое судно - " + shipName + " зарегистрировано и ожидает на причале " +
                    Thread.currentThread().getName());
            distribution();

        }
    }

    void distribution() {
        for (MerchantShip merchantShip : PortDemo.getAllShipsOnTheMoorings()) {
//            if (merchantShip.getTotalNumberOfContainers() > 0) {
//                unloading(merchantShip);
//            }
//            if (merchantShip.getTotalNumberOfContainers() == 0) {
//                loading(merchantShip);
//            }
            Thread unloadingThread = new Thread(new UnloadingThread());
            Thread loadingThread = new Thread(new LoadingThread());

            unloadingThread.start();
            loadingThread.start();

        }
    }

    int numberOfGroupsByContainerWeight() {
        System.out.println("Укажите количество групп контейнеров по весу (кг)");
        return scr.nextInt();
    }

    private void classification_of_containers() {
        int containerWeight = 0;
        int numberOfContainers = 0;
        numberOfGroups = numberOfGroupsByContainerWeight();

        for (int i = 0; i < numberOfGroups; i++) {
            System.out.println("Укажите вес группы");
            containerWeight = scr.nextInt();
            System.out.println("Количество контейнеров на судне в указанной выше группе?");
            numberOfContainers = scr.nextInt();
            if (numberOfContainers > 0) {
                System.out.println("Количество контейнеров для разгрузки?");
                unloadingContainers = scr.nextInt();
                System.out.println("Количество контейнеров для загрузки?");
                containersOfLoading = scr.nextInt();
            } else {
                System.out.println("Количество контейнеров для загрузки?");
                containersOfLoading = scr.nextInt();
            }
        }
        sumNumberOfContainers += numberOfContainers;
        sumWeightOfContainers += (containerWeight * numberOfContainers);
//        getAccounting().put(containerWeight, numberOfContainers);
        forLoading.put(containerWeight, containersOfLoading);
        forUnloading.put(containerWeight, unloadingContainers);

    }

    private int obtaining_maximum_load_capacity() {
        System.out.println("Максимальная грузоподъёмность корабля?");
        return scr.nextInt();
    }

    private String getting_a_name() {
        System.out.println("Укажите название корабля.");
        return scr.next();
    }
}