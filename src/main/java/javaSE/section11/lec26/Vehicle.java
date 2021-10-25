package javaSE.section11.lec26;

import java.util.Objects;

public class Vehicle {
    private String make;
    private String model;
    private int price;
    private boolean fourWDrive;

    public Vehicle(String make, String model, int price, boolean fourWDrive) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.fourWDrive = fourWDrive;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFourWDrive() {
        return fourWDrive;
    }

    public void setFourWDrive(boolean fourWDrive) {
        this.fourWDrive = fourWDrive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return getPrice() == vehicle.getPrice() && isFourWDrive() == vehicle.isFourWDrive() && Objects.equals(getMake(), vehicle.getMake()) && Objects.equals(getModel(), vehicle.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getPrice(), isFourWDrive());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", fourWDrive=" + fourWDrive +
                '}';
    }
}
