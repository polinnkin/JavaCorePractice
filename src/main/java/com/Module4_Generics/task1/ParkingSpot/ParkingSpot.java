package com.Module4_Generics.task1.ParkingSpot;

/**
 * This abstract class represents a parking spot for different vehicle types .
 *
 * @author Polina Bochkareva
 */
import com.Module4_Generics.task1.Vehicle.Vehicle;

public abstract class ParkingSpot {
    private boolean free;
    private Vehicle vehicle;

    private ParkingSpotType type;

    //construct a new Parking Spot spot with given parking spot type
    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    /**
     * getType method returns type of Parking Spot Type
     *
     * @return ParkingSpotType
     */
    public ParkingSpotType getType() {
        return type;
    }

    /**
     * getType method checks if a Parking Spot is available
     *
     * @return boolean Returns true is a Parking Spot is available and false otherwise
     */
    public boolean IsFree() {
        return free;
    }

    /**
     * This method assigns a vehicle to the parking Spot
     * @param vehicle This is the first parameter to assignVehicle
     */
    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
    }

    /**
     * This method removes a vehicle from the parking spot
     */
    public void removeVehicle() {
        this.vehicle = null;
        free = true;
    }
}