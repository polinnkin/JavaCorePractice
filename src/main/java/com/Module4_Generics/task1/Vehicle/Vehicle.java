package com.Module4_Generics.task1.Vehicle;

/**
 * This abstract class represents a vehicle with a specific VehicleType.
 *
 * @author Polina Bochkareva
 */

public abstract class Vehicle {

    private VehicleType type;
    private String name;

    //construct a new Vehicle  with given Vehicle  type
    public Vehicle(VehicleType type) {
        this.type = type;
    }

    //construct a new Vehicle  with given Vehicle name and type
    public Vehicle(String name, VehicleType type) {
        this.type = type;
        this.name = name;
    }

    /**
     * getName method returns a Vehicle name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * getType method returns type of a Vehicle
     *
     * @return VehicleType
     */
    public VehicleType getType() {
        return type;
    }

    /**
     * toString method returns Spring representation of a Vehicle
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "name=" + type +
                ", type='" + name + '\'' +
                '}';
    }
}
