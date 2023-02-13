package Transport;

import Drivers.DriverInfo;
import Maintenance.Mechanic;

import java.util.List;
import java.util.Objects;

import static Verifications.Verifications.verificationDouble;
import static Verifications.Verifications.verificationString;


public abstract class Transport<T extends DriverInfo> implements Emulous {
    final private String mark, model;
    final private double engineVolume;
    final private T driverInfo;
    private List<Mechanic> mechanicList;


    public Transport(String mark, String model, double engineVolume, T driverInfo, List<Mechanic> mechanicList) {
        this.mark = verificationString(mark, "default");
        this.model = verificationString(model, "default");
        this.engineVolume = verificationDouble(engineVolume, 1.5);
        this.driverInfo = driverInfo;
        this.mechanicList = mechanicList;

    }

    abstract public void printType();

    public void startMoving() {

    }

    public void finishMoving() {

    }

    abstract public boolean isNeedDiagnostics() throws TransportTypeException;

    public boolean isNeedService() {
        try {
            isNeedDiagnostics();
        } catch (TransportTypeException e) {
            return false;
        }
        return true;
    }

    public List<Mechanic> getMechanicList() {
        return mechanicList;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public T getDriverInfo() {
        return driverInfo;
    }

    @Override
    public String toString() {
        return "марка " + mark +
                ", модель " + model +
                ", объем двигателя " + engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport<?> transport = (Transport<?>) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && mark.equals(transport.mark) && model.equals(transport.model) && driverInfo.equals(transport.driverInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, model, engineVolume, driverInfo);
    }

}
