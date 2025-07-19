package Day5_ParkingLot;

import java.time.LocalDateTime;

public class Vehicle {
    private final VehicleType type;
    private final String licensePlate;
    private final LocalDateTime entryTime;

    public Vehicle(VehicleType type, String licensePlate) {
        this.type = type;
        this.licensePlate = licensePlate;
        this.entryTime = LocalDateTime.now();
    }

    public VehicleType getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
