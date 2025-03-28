package ParkingLot;

public interface ParkingSpot {

    boolean isAvailable();
    boolean canFitVehicle(Vehicle vehicle);
    void parkVehicle(Vehicle vehicle);
    void removeVehicle();
    String getSpotInfo();
    VehicleSize getSpotSize();


}
