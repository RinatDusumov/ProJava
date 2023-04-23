package main.java.students.rinat_dusumov.additionalTask.multithreading.task_6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
class PortDemo {
    private static final Map<Integer, Integer> cargoTerminalCapacity = new HashMap<>(); // вес и количество по лимиту на терминале
    static volatile Map<Integer, Integer> stockAvailability = new HashMap<>(); // наличие на складе на складе
    public static Map<Integer, Integer> getStockAvailability() {
        return stockAvailability;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread wharf_1 = new Thread(new Wharf(), "Wharf_1");
        Thread wharf_2 = new Thread(new Wharf(), "Wharf_2");
        Thread wharf_3 = new Thread(new Wharf(), "Wharf_3");
        cargoTerminalCapacity.put(1500, 100_000);
        cargoTerminalCapacity.put(5000, 100_000);
        cargoTerminalCapacity.put(3000, 100_000);
        cargoTerminalCapacity.put(10000, 100_000);
        stockAvailability.put(1500,0);
        stockAvailability.put(3000,0);
        stockAvailability.put(5000,0);
        stockAvailability.put(10000,0);
        wharf_1.start();
        wharf_2.start();
        wharf_3.start();
        wharf_1.join();
        wharf_2.join();
        wharf_3.join();

        for (int i = 0; i < getStockAvailability().size(); i++) {
            System.out.println(getStockAvailability().get(i));
        }
    }
}