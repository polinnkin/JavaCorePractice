package com.Module4_Generics.task1.ParkingSpot;

import com.Module4_Generics.task1.Vehicle.Vehicle;

public abstract class ParkingSpot {

    private String number;
    private boolean free;
    private Vehicle vehicle;
    private ParkingSpotType type;

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public boolean IsFree() {
        return free;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        free = true;
    }
}