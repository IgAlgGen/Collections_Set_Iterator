package Drivers;

import java.util.Objects;

import static Verifications.Verifications.verificationDouble;
import static Verifications.Verifications.verificationString;


public abstract class DriverInfo {
    final private String fullName;
    final private boolean havingLicense;
    private double experience;

    public DriverInfo(String fullName, boolean havingLicense, double experience) {
        this.fullName = verificationString(fullName,"default");
        this.havingLicense = havingLicense;
        this.experience = verificationDouble(experience, 0.1);
    }

    public void startDriving() {

    }

    public void stopDriving() {

    }

    public void refuelCar() {

    }

     public void setExperience(double experience) {
        this.experience = verificationDouble(experience, 0.2);
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isHavingLicense() {
        return havingLicense;
    }

    public double getExperience() {
        return experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverInfo that = (DriverInfo) o;
        return havingLicense == that.havingLicense && Double.compare(that.experience, experience) == 0 && fullName.equals(that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, havingLicense, experience);
    }

    @Override
    public String toString() {
        return fullName +
                ", вод. уд. " + (havingLicense ? "есть" : "нет") +
                ", опыт " + experience;
    }
}