package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.*;

class Wharf implements Runnable {
    private static final Object lock = new Object();
    private static final Object lock_2 = new Object();
    private static final Scanner scr = new Scanner(System.in);
    private final Map<Integer, Integer> accounting = new HashMap<>();
    private Map<Integer,Integer> forUnloadingGoods= new HashMap<>();
    private Map<Integer, Integer> toLoadTheGoods = new HashMap<>();
    private List<MerchantShip> listOfShips = new LinkedList<>();
    private int sumNumberOfContainers = 0;
    private int sumWeightOfContainers = 0;

    public Map<Integer, Integer> getAccounting() {
        return accounting;
    }

    public Map<Integer, Integer> getForUnloadingGoods() {
        return forUnloadingGoods;
    }

    public Map<Integer, Integer> getToLoadTheGoods() {
        return toLoadTheGoods;
    }

    @Override
    public void run() {

        registration();
    }

    void unloading(MerchantShip merchantShip) {
        synchronized (lock) {
            for (Map.Entry<Integer, Integer> forUnloading : getForUnloadingGoods().entrySet()) {
                if (merchantShip.getPresenceOnTheVessel().containsKey(forUnloading.getKey())) {
                    for (Map.Entry<Integer, Integer> presenceOnTheVessel : merchantShip.getPresenceOnTheVessel().entrySet()) {
                        for (Map.Entry<Integer, Integer> inStock : PortDemo.stockAvailability.entrySet()) {
                            if (presenceOnTheVessel.getKey().equals(forUnloading.getKey()) && inStock.getValue() >=
                                    forUnloading.getValue()) {
                                merchantShip.getPresenceOnTheVessel().put(presenceOnTheVessel.getKey(),
                                        presenceOnTheVessel.getValue() - forUnloading.getValue());

                                if (forUnloading.getKey().equals(inStock.getKey())) {
                                    PortDemo.getStockAvailability().put(forUnloading.getKey(), forUnloading.getValue()
                                            + inStock.getValue());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void loading(MerchantShip merchantShip) {
        synchronized (lock) {
            for (Map.Entry<Integer, Integer> forLoading : getToLoadTheGoods().entrySet()) {
                if (merchantShip.getPresenceOnTheVessel().containsKey(forLoading.getKey())) {
                    for (Map.Entry<Integer, Integer> presenceOnTheVessel : merchantShip.getPresenceOnTheVessel().entrySet()) {
                        for (Map.Entry<Integer, Integer> inStock : PortDemo.stockAvailability.entrySet()) {
                            if ((presenceOnTheVessel.getKey().equals(forLoading.getKey()) && merchantShip.getCarryingCapacity() <=
                                    merchantShip.getTotalWeightOfContainers()) && forLoading.getValue() <= inStock.getValue()) {
                                presenceOnTheVessel.setValue(presenceOnTheVessel.getValue() + forLoading.getValue());

                                if (forLoading.getKey().equals(inStock.getKey())) {
                                    PortDemo.getStockAvailability().put(forLoading.getKey(), inStock.getValue() -
                                            forLoading.getValue());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void registration() {
        synchronized (lock_2) {
            String shipName = getting_a_name();
            int carryingCapacity = obtaining_maximum_load_capacity();
            classificationOfContainers();

            for (Map.Entry<Integer,Integer> accounting : getAccounting().entrySet()) {
                listOfShips.add(new MerchantShip(Thread.currentThread().getName(), shipName, carryingCapacity,
                        accounting.getKey(), accounting.getValue(), sumNumberOfContainers,
                        sumWeightOfContainers));
            }
            System.out.println("Торговое судно - " + shipName + " зарегистрировано и ожидает на причале " +
                    Thread.currentThread().getName());
            for (MerchantShip listOfShip : listOfShips) {
                if (listOfShip.getNameThread().equalsIgnoreCase(Thread.currentThread().getName())) {
                    distribution(listOfShip);
                }
            }
        }
    }

    void distribution(MerchantShip merchantShip) {
        System.out.println("Данные для разгрузки / загрузки");
        int containerWeight = weightInput();
        System.out.print("Для разгрузки - ");
        int quantityForUnloading = scr.nextInt();
        System.out.print("Для загрузки - ");
        int quantityToDownload = scr.nextInt();
        commencementOfWork(merchantShip, containerWeight, quantityForUnloading, quantityToDownload);
    }

    private void commencementOfWork(MerchantShip merchantShip, int containerWeight, int quantityForUnloading,
                                    int quantityToDownload) {
        Thread unloadingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                forUnloadingGoods.put(containerWeight, quantityForUnloading);
                unloading(merchantShip);
            }
        });
        Thread loadingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                toLoadTheGoods.put(containerWeight, quantityToDownload);
                loading(merchantShip);
            }
        });
        unloadingThread.start();
        loadingThread.start();
    }
    private void classificationOfContainers() {
        int containerWeight;
        int numberOfContainers;
        System.out.println("Вес контейнеров и количество на корабле");
        for (int i = 0; i < 4; i++) {
            containerWeight = weightInput();
            numberOfContainers = quantityInput();

            accounting.put(containerWeight, numberOfContainers);
            sumNumberOfContainers += numberOfContainers;
            sumWeightOfContainers += (containerWeight * numberOfContainers);
        }
    }

    private int quantityInput() {
        System.out.println("Укажите количество контейнеров");
        return scr.nextInt();
    }

    private int weightInput() {
        System.out.println("Укажите вес группы (1500, 3000, 5000, 10000)");
        return scr.nextInt();
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