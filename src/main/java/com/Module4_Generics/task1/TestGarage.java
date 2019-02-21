package com.Module4_Generics.task1;

/**
 * This program a test program for Garage class.
 *
 * @author Polina Bochkareva
 */
import com.Module4_Generics.task1.Vehicle.Car;
import com.Module4_Generics.task1.Vehicle.Truck;
import com.Module4_Generics.task1.Vehicle.Van;

public class TestGarage {
    /**
     * This is the main method where Garage class is tested.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        Garage garage = new Garage();
        Car car1 = new Car();
        Van van1 = new Van();
        Truck truck1 = new Truck();

        garage.addVehicle(van1);
        garage.addVehicle(truck1);

        garage.addVehicle(car1);
        System.out.println("Number of compact cars parked in the garage is " + garage.getCompactSpotCount());

        Car car2 = new Car();
        garage.addVehicle(car2);
        System.out.println("Number of compact cars parked in the garage is " + garage.getCompactSpotCount());

        garage.addVehicle(car2);
        System.out.println("Number of compact cars parked in the garage is " + garage.getCompactSpotCount());

        Car car3 = new Car();
        garage.addVehicle(car3);
        System.out.println("Number of compact cars parked in the garage is " + garage.getCompactSpotCount());

        Car car4 = new Car();
        garage.addVehicle(car4);
        System.out.println("Number of compact cars parked in the garage is " + garage.getCompactSpotCount());
    }
}
