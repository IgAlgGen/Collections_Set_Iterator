package Transport;

import Drivers.License_B;
import Maintenance.Mechanic;

import java.util.List;
import java.util.Objects;

public class Car extends Transport<License_B> {
    private BodyType bodyType;


    public Car(String mark, String model, double engineVolume, String bodyTypeE, License_B driverInfo, List<Mechanic> mechanicList) {
        super(mark, model, engineVolume, driverInfo, mechanicList);
        this.bodyType = BodyType.getValue(bodyTypeE);

    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбэк"),
        COUPE("Купе"),
        STATION_WAGON("Универсал"),
        OFF_ROAD_VEHICLE("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private final String bodyType;


        BodyType(String bodyType) {
            this.bodyType = bodyType;
        }

        public String getBodyType() {
            return bodyType;
        }

        public static BodyType getValue(String value) {
            switch (value) {
                case "Седан":
                    return SEDAN;
                case "Хетчбэк":
                    return HATCHBACK;
                case "Купе":
                    return COUPE;
                case "Универсал":
                    return STATION_WAGON;
                case "Внедорожник":
                    return OFF_ROAD_VEHICLE;
                case "Кроссовер":
                    return CROSSOVER;
                case "Пикап":
                    return PICKUP;
                case "Фургон":
                    return VAN;
                case "Минивэн":
                    return MINIVAN;
            }
            return null;
        }

        @Override
        public String toString() {
            return super.toString() + " " + getBodyType() + ".";

        }
    }

    public boolean isNeedDiagnostics() {
        return getBodyType() != null;
    }

    @Override
    public void printType() {
        if (bodyType != null) {
            System.out.println(bodyType.toString());
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
        Car car = (Car) o;
        return bodyType == car.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType);
    }
}
