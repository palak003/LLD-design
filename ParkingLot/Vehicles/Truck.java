package ParkingLot.Vehicles;

import ParkingLot.Vehicle;
import ParkingLot.VehicleSize;

public class Truck implements Vehicle {
    private String vehicleNumber;

    public Truck(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.LARGE;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }
}
