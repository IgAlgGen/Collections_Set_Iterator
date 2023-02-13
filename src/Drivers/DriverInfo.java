package Drivers;

import static Verifications.Verifications.verificationDouble;
import static Verifications.Verifications.verificationString;


public abstract class DriverInfo {
    private String fullName;
    private boolean havingLicense;
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

    public void setFullName(String fullName) {
        this.fullName = verificationString(fullName, "default");
    }

    public void setHavingLicense(boolean havingLicense) {
        this.havingLicense = havingLicense;
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
    public String toString() {
        return fullName +
                ", вод. уд. " + (havingLicense ? "есть" : "нет") +
                ", опыт " + experience;
    }
}