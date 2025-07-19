package Day5_ParkingLot;

import java.time.Duration;
import java.util.*;

public class SlotGroup {
    private final SlotType type;
    private final int capacity;
    private final int perMinuteRate;
    private final Map<String, Vehicle> vehicles;

    public SlotGroup(SlotType type, int capacity, int perMinuteRate) {
        this.type = type;
        this.capacity = capacity;
        this.perMinuteRate = perMinuteRate;
        this.vehicles = new LinkedHashMap<>();
    }

    public boolean hasSpace() {
        return vehicles.size() < capacity;
    }

    public void addVehicle(Vehicle v) {
        vehicles.put(v.getLicensePlate(), v);
    }

    public Vehicle removeVehicle(String licensePlate) {
        return vehicles.remove(licensePlate);
    }

    public long calculateFee(Vehicle v) {
        long mins = Duration.between(v.getEntryTime(), java.time.LocalDateTime.now()).toMinutes();
return mins;
    }

    public int getOccupancy() {
        return vehicles.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public SlotType getType() {
        return type;
    }

    public int getPerMinuteRate() {
        return perMinuteRate;
    }

    public Map<String, Vehicle> getVehicles() {
        return vehicles;
    }
}
