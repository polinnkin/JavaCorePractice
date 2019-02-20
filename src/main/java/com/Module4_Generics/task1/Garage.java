package main.java.com.Module4_Generics.task1;

import main.java.com.Module4_Generics.task1.ParkingSpot.BicycleSpot;
import main.java.com.Module4_Generics.task1.ParkingSpot.CompactSpot;
import main.java.com.Module4_Generics.task1.ParkingSpot.MotorcycleSpot;
import main.java.com.Module4_Generics.task1.Vehicle.*;

import java.util.HashMap;

public class Garage {
    public static final int MAX_COMPACT_COUNT = 3;
    public static int MAX_MOTORCYCLE_COUNT = 100;
    public static int MAX_BICYCLE_COUNT = 100;



    private int compactSpotCount;
    private int motorcycleSpotCount;
    private int bicycleSpotCount;
    HashMap<BicycleSpot, Bicycle> bicycleMap = new HashMap<>();

    HashMap<CompactSpot, Car> carMap = new HashMap<>();
    HashMap<MotorcycleSpot, Motorcycle> motorcycleMap = new HashMap<>();

    public boolean addVehicle(Vehicle vehicle) {
        boolean success = true;
        if (vehicle.getType() == VehicleType.CAR) {
            if(compactSpotCount < MAX_COMPACT_COUNT) {
                CompactSpot spot = new CompactSpot();
                spot.assignVehicle(vehicle);
                carMap.put(spot, (Car) vehicle);
                compactSpotCount++;
                System.out.println("Successfully added a vehicle to a COMPACT spot.");
            }
            else {
                success = false;
                System.out.println("Couldn't add the vehicle. There is no available COMPACT spot in the garage.");
            }
        } else {
            success = false;
            System.out.println("Couldn't add the vehicle. TRUCKS and VANS are too large to enter the garage!");
        }
        return success;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        boolean success = true;
        if (vehicle.getType() == VehicleType.CAR) {
            if(carMap.containsValue(vehicle)){
                getKeyFromValue(carMap, (Car) vehicle).removeVehicle();
                carMap.remove(getKeyFromValue(carMap, (Car) vehicle));
                compactSpotCount--;
            }
            else {
                success = false;
                System.out.println("Couldn't find the vehicle in the garage.");
            }
        } else {
            success = false;
            System.out.println("Couldn't find the vehicle in the garage.");
        }
        return success;
    }


    public boolean isFull(VehicleType type) {
        // motorbikes can only be parked at motorbike spots
        if (type == VehicleType.MOTORCYCLE) {
            return motorcycleSpotCount >= MAX_MOTORCYCLE_COUNT;
        }

        // cars can be parked at compact or large spots
        else if (type == VehicleType.CAR) {
            return compactSpotCount >= MAX_COMPACT_COUNT;
        } else {
            return bicycleSpotCount >= MAX_BICYCLE_COUNT;
        }
    }

    public HashMap<CompactSpot, Car> getCarMap() {
        return carMap;
    }

    public static CompactSpot getKeyFromValue(HashMap<CompactSpot, Car> map, Car value) {
        for (CompactSpot o : map.keySet()) {
            if (map.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

    public int getCompactSpotCount() {
        return compactSpotCount;
    }

    public int getMotorcycleSpotCount() {
        return motorcycleSpotCount;
    }

    public int getBicycleSpotCount() {
        return bicycleSpotCount;
    }

}