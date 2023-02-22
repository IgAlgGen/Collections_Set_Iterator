import Drivers.DriverInfo;
import Drivers.License_B;
import Drivers.License_C;
import Drivers.License_D;
import Maintenance.Mechanic;
import Maintenance.ServiceStation;
import Transport.*;

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Mechanic a1 = new Mechanic(
                "Геннадий",
                "Генадьев",
                "\"Рога и копыта\"");
        Mechanic a2 = new Mechanic(
                "Святослав",
                "Святов",
                "\"Чиним ломаем\"");
        Mechanic a3 = new Mechanic(
                "Добрыня",
                "Добров",
                "\"И так сойдет\"");

        List<Mechanic> mechanicList = new ArrayList<>(Arrays.asList(a1, a2, a3));

        Transport<License_B> car1 = new Car(
                "Lada",
                "Kalina",
                1.6,
                "Седан",
                new License_B(
                        "Ivan Ivanov",
                        true,
                        2.0),
                mechanicList);
        Transport<License_D> bus1 = new Bus(
                "LIaZ",
                "Moon Rider",
                3.,
                45,
                new License_D(
                        "Petr Petrov",
                        true,
                        10.),
                mechanicList);

        Transport<License_C> track1 = new Track(
                "Kamaz",
                "6520",
                8.,
                50,
                new License_C(
                        "Sidor Sidorov",
                        true,
                        6.),
                mechanicList);

        List<Transport<?>> transportList = new ArrayList<>(Arrays.asList(car1, bus1, track1));
        System.out.println(transportList);

        Queue<Transport<?>> stoList = new ArrayDeque<>();
        ServiceStation serviceStation = new ServiceStation(stoList);
        for (Transport<?> transport : transportList) {
            serviceStation.addTransport(transport);
        }

        passingDiagnostics(car1);
        passingDiagnostics(bus1);
        passingDiagnostics(track1);

        System.out.println();

        for (int i = 0; i < 4; i++) {
            serviceStation.doService();
        }

        System.out.println("\n----- Introduction_to_collections_Map -----\n");

        Map<Transport<?>, Mechanic> transportMechanicHashMap = new HashMap<>();
        transportMechanicHashMap.put(car1, a1);
        transportMechanicHashMap.put(bus1, a2);
        transportMechanicHashMap.put(track1, a3);

        for (Map.Entry<Transport<?>, Mechanic> objectObjectEntry : transportMechanicHashMap.entrySet()) {
            System.out.println(objectObjectEntry.getKey() + " - " + objectObjectEntry.getValue());
        }

        System.out.println("\n----- Collections_Set_Iterator -----\n");

        Set<DriverInfo> driverInfoSet = new HashSet<>();
        // driverInfoSet.add(new DriverInfo()); // Вот тут не совсем понятно делать новых водителей или как?
        driverInfoSet.add(car1.getDriverInfo());
        driverInfoSet.add(bus1.getDriverInfo());
        driverInfoSet.add(track1.getDriverInfo());
        driverInfoSet.add(new License_B("Kot", true, 1.));
        driverInfoSet.add(new License_B("Kot", true, 1.)); // Проверка на добавление дублей.

        Iterator<DriverInfo> iterator = driverInfoSet.iterator();
        while (iterator.hasNext()) {
            DriverInfo driverInfo = iterator.next();
            System.out.println(driverInfo);
        }

    }

    public static void printSolution(Transport<?> transport) {
        System.out.println("Водитель " + transport.getDriverInfo() + ", управляет автомобилем " + transport + " и будет участвовать в заезде.");
    }


    public static void passingDiagnostics(Transport<?> transport) {

        try {
            if (transport.isNeedDiagnostics()) {
                System.out.println("Транспортное средство " + transport + " прошло диагностику.");
            } else {
                System.out.println("Транспортное средство " + transport + " не опознано.");
            }
        } catch (TransportTypeException e) {
            System.out.println("Автобусы не должны проходить диагностику.");
        }
    }


}

