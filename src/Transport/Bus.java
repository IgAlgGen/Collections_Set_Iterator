package Transport;

import Drivers.License_D;
import Maintenance.Mechanic;

import java.util.List;
import java.util.Objects;

public class Bus extends Transport<License_D> {

    private Capacity capacity;

    public Bus(String mark, String model, double engineVolume, int capacityE, License_D driverInfo, List<Mechanic> mechanicList) {
        super(mark, model, engineVolume, driverInfo, mechanicList);
        this.capacity = Capacity.getValue(capacityE);
    }

    public Bus(String mark, String model, double engineVolume, License_D driverInfo, List<Mechanic> mechanicList, Capacity capacity) {
        super(mark, model, engineVolume, driverInfo, mechanicList);
        this.capacity = capacity;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public enum Capacity {
        EXTRA_SMALL(0, 10),
        SMALL(11, 25),
        MEDIUM(40, 50),
        LARGE(60, 80),
        EXTRA_LARGE(100, 120);

        private final int min;
        private final int max;

        Capacity(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public static Capacity getValue(int value) {
            for (Capacity e : Capacity.values()) {
                if (value >= e.getMin() && value <= e.getMax()) {
                    return e;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return super.toString() + " : " + getMin() + " — " + getMax() + " мест.";
        }
    }


    public boolean isNeedDiagnostics() {
        throw new TransportTypeException("Автобусы не должны проходить диагностику.");
    }

    @Override
    public void printType() {
        if (capacity != null) {
            System.out.println(capacity.toString());
        } else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    public void startMoving() {
        System.out.println("Транспортное средство " + getMark() + " " + getModel() + " начало движение.");
    }

    public void finishMoving() {
        System.out.println("Транспортное средство " + getMark() + " " + getModel() + " закончило движение.");
    }

    @Override
    public void pitStop() {
        System.out.println("Время пит-стоп ");
    }

    @Override
    public void bestTimeLap() {
        System.out.println("Лучший круг ");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return capacity == bus.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity);
    }
}
