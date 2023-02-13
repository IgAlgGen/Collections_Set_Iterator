package Transport;

import Drivers.License_C;
import Maintenance.Mechanic;

import java.util.List;

public class Track extends Transport<License_C> {
    private TypeOfLoad typeOfLoad;

    public Track(String mark, String model, double engineVolume, double typeOfLoadE, License_C driverInfo, List<Mechanic> mechanicList) {
        super(mark, model, engineVolume, driverInfo, mechanicList);
        this.typeOfLoad = TypeOfLoad.getValue(typeOfLoadE);
    }

    public TypeOfLoad getTypeOfLoad() {
        return typeOfLoad;
    }

    public void setTypeOfLoad(TypeOfLoad typeOfLoad) {
        this.typeOfLoad = typeOfLoad;
    }

    public enum TypeOfLoad {
        N1(0, 3.5),
        N2(3.5, 12),
        N3(12, 500);

        private final double min;
        private final double max;

        TypeOfLoad(double min, double max) {
            this.min = min;
            this.max = max;
        }

        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }

        public static TypeOfLoad getValue(double value) {
            for (TypeOfLoad e : TypeOfLoad.values()) {
                if (value >= e.getMin() && value <= e.getMax()) {
                    return e;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return super.toString() + " : от " + getMin() + " тонн до " + getMax() + " тонн.";
        }
    }


    public boolean isNeedDiagnostics() {
        return getTypeOfLoad() != null;
    }

    @Override
    public void printType() {
        if (typeOfLoad != null) {
            System.out.println(typeOfLoad.toString());
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

}
