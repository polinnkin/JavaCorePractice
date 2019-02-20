package main.java.com.Module4_Generics.task1.Vehicle;

public abstract class Vehicle {

    private VehicleType type;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }
}
