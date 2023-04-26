package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.HashMap;
import java.util.Map;

/**
 Написать программу, моделирующую работу порта. Корабли могут заходить в порт
 для разгрузки / загрузки контейнеров. Количество контейнеров, находящихся в текущий
 момент в порту и на корабле, не должно превышать заданную грузоподъемность судна и
 емкость порта. В порту работает несколько причалов. В одном причале может стоять
 только один корабль. Корабль может загружаться у причала, разгружаться или выполнять оба действия.
 Нужны любые Ваши идеи. Можете даже менять условие задачи (упростить, например), но
 модель многопоточной системы должна работать.
 */

public class PortDemo {
    private static final Map<Integer, Integer> cargoTerminalCapacity = new HashMap<>(); // вес и количество по лимиту на терминале
    private static volatile Map<Integer, Integer> stockAvailability = new HashMap<>(); // наличие на складе
    private static final VesselRegistration vesselRegistration = new VesselRegistration();
    private static final PlannedWorks plannedWorks = new PlannedWorks();
    public static Map<Integer, Integer> getCargoTerminalCapacity() {
        return cargoTerminalCapacity;
    }

    public static Map<Integer, Integer> getStockAvailability() {
        return stockAvailability;
    }

    public static void main(String[] args) throws InterruptedException {
        settingAFixedLimit();
        addingTheNameOfTheProductToTheWarehouse();
        openingOfBerthsForTheReceptionOfMerchantShips();
        outputOfTheResultAfterTheWorkIsCompleted();
    }
    static void settingAFixedLimit () {
        cargoTerminalCapacity.put(1500, 100_000);
        cargoTerminalCapacity.put(5000, 100_000);
        cargoTerminalCapacity.put(3000, 100_000);
        cargoTerminalCapacity.put(10000, 100_000);
    }
    static void addingTheNameOfTheProductToTheWarehouse () {
        stockAvailability.put(1500,0);
        stockAvailability.put(3000,0);
        stockAvailability.put(5000,0);
        stockAvailability.put(10000,0);
    }
    static void openingOfBerthsForTheReceptionOfMerchantShips () throws InterruptedException {
        Wharf_1 wharf_1 = new Wharf_1(vesselRegistration, plannedWorks);
        Wharf_2 wharf_2 = new Wharf_2(vesselRegistration, plannedWorks);
        Wharf_3 wharf_3 = new Wharf_3(vesselRegistration, plannedWorks);

        Thread thread1 = new Thread(wharf_1, "Wharf_1");
        Thread thread2 = new Thread(wharf_2, "Wharf_2");
        Thread thread3 = new Thread(wharf_3, "Wharf_3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }
    static void outputOfTheResultAfterTheWorkIsCompleted () {
        System.out.println("Остаток товара на складе: ");
        for (Map.Entry<Integer, Integer> inStock : getStockAvailability().entrySet()) {
            System.out.println(inStock);
        }
    }
}