package ParkingLot.Vehicles;

import ParkingLot.Vehicle;
import ParkingLot.VehicleSize;

public class Bike implements Vehicle {
    private String vehicleNumber;

    public Bike(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.SMALL;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }
}
