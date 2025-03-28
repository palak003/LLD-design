package ParkingLot.ParkingSpots;

import ParkingLot.ParkingSpot;
import ParkingLot.Vehicle;
import ParkingLot.VehicleSize;

public class BasicParkingSpot implements ParkingSpot {
    private final VehicleSize spotsize;
    private boolean available;
    private final String spotId;
    private Vehicle parkedVehicle;

    public BasicParkingSpot(VehicleSize spotsize, String spotId) {
        this.spotsize = spotsize;
        this.spotId = spotId;
        this.available = true;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getVehicleSize().ordinal() <= spotsize.ordinal();
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {
        if(isAvailable() && canFitVehicle(vehicle)){
            parkedVehicle=vehicle;
            available=false;
        }
    }

    @Override
    public void removeVehicle() {
        if(isAvailable())
        {
            System.out.println("Spot is already empty");
            return;
        }
        parkedVehicle=null;
        available=true;
    }

    @Override
    public String getSpotInfo() {
        return "Spot " + spotId + " [" + spotsize + "] - " + (available ? "Available" : "Occupied");
    }

    @Override
    public VehicleSize getSpotSize() {
        return spotsize;
    }
}
