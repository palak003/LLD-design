package ParkingLot.Vehicles;

import ParkingLot.Vehicle;
import ParkingLot.VehicleSize;

public class Car implements Vehicle {
    private String vehicleNumber;

    public Car(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.COMPACT;
    }

    @Override
    public String getVehicleNumber() {
        return vehicleNumber;
    }
}
