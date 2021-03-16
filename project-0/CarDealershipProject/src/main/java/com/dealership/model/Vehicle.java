package com.dealership.model;

import java.util.Objects;

public class Vehicle {

    private String vin;
    private String make;
    private String model;
    private Integer year;
    private Integer ownerId;

    public Vehicle() {
    }

    public Vehicle(String vin, String make, String model, Integer year, int ownerId) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.ownerId = ownerId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return getOwnerId() == vehicle.getOwnerId() && Objects.equals(getVin(), vehicle.getVin()) && Objects.equals(getMake(), vehicle.getMake()) && Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getYear(), vehicle.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVin(), getMake(), getModel(), getYear(), getOwnerId());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", ownerId=" + ownerId +
                '}';
    }
}
