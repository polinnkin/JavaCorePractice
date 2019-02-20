package com.Module4_Generics.task1;

import com.Module4_Generics.task1.Vehicle.Car;
import com.Module4_Generics.task1.Vehicle.Van;

public class TestGarage {
    public static void main(String[] args) {
        Garage garage = new Garage();
        Car car1 = new Car();
        Van van1 = new Van();

        garage.addVehicle(van1);

        garage.addVehicle(car1);
        System.out.println(garage.getCompactSpotCount());

        Car car2 = new Car();
        garage.addVehicle(car2);
        System.out.println(garage.getCompactSpotCount());

        garage.removeVehicle(car2);
        System.out.println(garage.getCompactSpotCount());

        Car car3 = new Car();
        garage.addVehicle(car3);
        System.out.println(garage.getCompactSpotCount());

        Car car4 = new Car();
        garage.addVehicle(car4);
        System.out.println(garage.getCompactSpotCount());
    }
}
