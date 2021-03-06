package com.Module4_Generics.task1;

/**
 * This program represents a garage with 3 types of parking spots - COMPACT, MOTORCYCLE, BICYCLE.
 * Only CAR, MOTORCYCLE, BICYCLE types of vehicle can park in the garage.
 * TRUCK and VAN vehicle types are too large to park in the garage
 *
 * @author Polina Bochkareva
 */
import com.Module4_Generics.task1.ParkingSpot.BicycleSpot;
import com.Module4_Generics.task1.ParkingSpot.CompactSpot;
import com.Module4_Generics.task1.ParkingSpot.MotorcycleSpot;
import com.Module4_Generics.task1.ParkingSpot.ParkingSpot;
import com.Module4_Generics.task1.Vehicle.*;

import java.util.HashMap;

public class Garage {

    // max numbers of parking spots for different vehicle types
    public static final int MAX_COMPACT_COUNT = 3;
    public static int MAX_MOTORCYCLE_COUNT = 5;
    public static int MAX_BICYCLE_COUNT = 5;

    // maps where currently parked vehicles are stored
    private HashMap<BicycleSpot, Bicycle> bicycleMap = new HashMap<>();
    private HashMap<CompactSpot, Car> carMap = new HashMap<>();
    private HashMap<MotorcycleSpot, Motorcycle> motorcycleMap = new HashMap<>();

    // current numbers of available parking spots for different vehicle types
    private int compactSpotCount;
    private int motorcycleSpotCount;
    private int bicycleSpotCount;

    /**
     * getCompactSpotCount method returns current number of available compact parking spots
     *
     * @return int Returns number of available compact parking spots
     */
    public int getCompactSpotCount() {
        return compactSpotCount;
    }

    /**
     * getMotorcycleSpotCount method returns current number of available Motorcycle parking spots
     *
     * @return int Returns number of available Motorcycle parking spots
     */
    public int getMotorcycleSpotCount() {
        return motorcycleSpotCount;
    }

    /**
     * getBicycleSpotCount method returns current number of available Bicycle parking spots
     *
     * @return int Returns number of available Bicycle parking spots
     */
    public int getBicycleSpotCount() {
        return bicycleSpotCount;
    }

    /**
     * This method adds allowed types of vehicles (CAR, MOTORCYCLE, BICYCLE) in the garage.
     *
     * @param vehicle This is the first parameter to addVehicle method
     * @return boolean This returns true if the vehicle was successfully added to the garage and false otherwise
     */
    public boolean addVehicle(Vehicle vehicle) {
        boolean isAdded = false;
        if (vehicle.getType() == VehicleType.VAN || vehicle.getType() == VehicleType.TRUCK) {
            System.out.println("Couldn't add the vehicle. TRUCKS and VANS are too large to enter the garage!");
        } else if (vehicle.getType() == VehicleType.CAR) {
            if (carMap.containsValue(vehicle)) {
                System.out.println("Couldn't add the vehicle. This vehicle already parked at the " +
                        getSpotByVehicle(carMap, (Car) vehicle) + " spot.");
            } else {
                if (compactSpotCount < MAX_COMPACT_COUNT) {
                    CompactSpot spot = new CompactSpot();
                    spot.assignVehicle(vehicle);
                    carMap.put(spot, (Car) vehicle);
                    compactSpotCount++;
                    System.out.println("Successfully added a vehicle to a COMPACT spot.");
                    isAdded = true;
                } else {
                    System.out.println("Couldn't add the vehicle. There is no available COMPACT spot in the garage.");
                }
            }
        } else if (vehicle.getType() == VehicleType.MOTORCYCLE) {
            if (motorcycleMap.containsValue(vehicle)) {
                System.out.println("Couldn't add the vehicle. This vehicle already parked at the " +
                        getSpotByVehicle(motorcycleMap, (Motorcycle) vehicle) + " spot.");
            } else {
                if (motorcycleSpotCount < MAX_MOTORCYCLE_COUNT) {
                    MotorcycleSpot spot = new MotorcycleSpot();
                    spot.assignVehicle(vehicle);
                    motorcycleMap.put(spot, (Motorcycle) vehicle);
                    motorcycleSpotCount++;
                    System.out.println("Successfully added a vehicle to a MOTORCYCLE spot.");
                    isAdded = true;
                } else {
                    System.out.println("Couldn't add the vehicle. There is no available MOTORCYCLE spot in the garage.");
                }
            }
        } else if (vehicle.getType() == VehicleType.BICYCLE) {
            if (bicycleMap.containsValue(vehicle)) {
                System.out.println("Couldn't add the vehicle. This vehicle already parked at the BICYCLE spot.");
            } else {
                if (bicycleSpotCount < MAX_BICYCLE_COUNT) {
                    BicycleSpot spot = new BicycleSpot();
                    spot.assignVehicle(vehicle);
                    bicycleMap.put(spot, (Bicycle) vehicle);
                    bicycleSpotCount++;
                    System.out.println("Successfully added a vehicle to a BICYCLE spot.");
                    isAdded = true;
                } else {
                    System.out.println("Couldn't add the vehicle. There is no available BICYCLE spot in the garage.");
                }
            }
        }
        return isAdded;
    }

    /**
     * This method removes a vehicle from the garage
     *
     * @param vehicle This is the first parameter to removeVehicle method
     * @return boolean This returns true if the vehicle was successfully removed from the garage and false otherwise
     */
    public boolean exitGarage(Vehicle vehicle) {
        boolean isExited = false;
        if (vehicle.getType() == VehicleType.CAR) {
            if (carMap.containsValue(vehicle)) {
                getSpotByVehicle(carMap, (Car) vehicle).removeVehicle();
                carMap.remove(getSpotByVehicle(carMap, (Car) vehicle));
                compactSpotCount--;
                isExited = true;
                System.out.println("Removed this compact vehicle in the garage.");
            } else {
                System.out.println("Couldn't find this compact vehicle in the garage.");
            }
        } else if (vehicle.getType() == VehicleType.MOTORCYCLE) {
            if (motorcycleMap.containsValue(vehicle)) {
                getSpotByVehicle(motorcycleMap, (Motorcycle) vehicle).removeVehicle();
                motorcycleMap.remove(getSpotByVehicle(motorcycleMap, (Motorcycle) vehicle));
                motorcycleSpotCount--;
                isExited = true;
            } else {
                System.out.println("Couldn't find the vehicle in the garage.");
            }
        } else if (vehicle.getType() == VehicleType.BICYCLE) {
            if (bicycleMap.containsValue(vehicle)) {
                getSpotByVehicle(bicycleMap, (Bicycle) vehicle).removeVehicle();
                bicycleMap.remove(getSpotByVehicle(bicycleMap, (Bicycle) vehicle));
                bicycleSpotCount--;
                isExited = true;
            } else {
                System.out.println("Couldn't find the vehicle in the garage.");
            }
        } else {
            isExited = false;
            System.out.println("Couldn't find the vehicle in the garage.");
        }
        return isExited;
    }

    /**
     * This method checks is the garage if full for specified Vehicle Type
     *
     * @param type This is the first parameter to isFull method
     * @return boolean This returns true if there is no available parking spot for a specified VehicleType
     * and false otherwise
     */
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

    /**
     * This method finds a parking spot by Vehicle
     *
     * @param map     This is the first parameter to getSpotByVehicle method
     * @param vehicle This is the second parameter to getSpotByVehicle method
     * @return ParkingSpot This returns a Parking Spot fo a specified vehicle
     * and false otherwise
     */
    private <S extends ParkingSpot, V extends Vehicle> S getSpotByVehicle(HashMap<S, V> map, V vehicle) {
        for (S o : map.keySet()) {
            if (map.get(o).equals(vehicle)) {
                return o;
            }
        }
        return null;
    }
}