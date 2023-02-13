package Maintenance;

import Transport.Transport;

import java.util.Objects;

import static Verifications.Verifications.verificationString;

public class Mechanic {
    final private String firstName, secondName;
    private String company;

    public Mechanic(String firstName, String secondName, String company) {
        this.firstName = verificationString(firstName, "default");
        this.secondName = verificationString(secondName, "default");
        this.company = verificationString(company, "default");
    }

    public <T extends Transport<?>> void doMaintenance(T vehicle) {
        System.out.println(vehicle.toString() + " обслуживается " + toString());
    }

    public <T extends Transport<?>> void fixTheVehicle(T vehicle) {
        System.out.println(vehicle.toString() + " ремонтируется " + this);
    }

    @Override
    public String toString() {
        return "механик" +
                " " + firstName +
                " " + secondName +
                ", компании " + company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = verificationString(company, "default");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return firstName.equals(mechanic.firstName) && secondName.equals(mechanic.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }
}
