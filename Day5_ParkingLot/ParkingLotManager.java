package Day5_ParkingLot;

import java.util.*;

public class ParkingLotManager {
    private final Map<SlotType, SlotGroup> slotMap;
    private final Map<String, SlotType> vehicleSlotMap;

    public ParkingLotManager() {
        slotMap = new HashMap<>();
        vehicleSlotMap = new HashMap<>();

        // SlotGroup(slotType, capacity, perMinuteRate)
        slotMap.put(SlotType.SMALL, new SlotGroup(SlotType.SMALL, 2, 1));
        slotMap.put(SlotType.MEDIUM, new SlotGroup(SlotType.MEDIUM, 2, 2));
        slotMap.put(SlotType.LARGE, new SlotGroup(SlotType.LARGE, 1, 3));
    }

    public boolean parkVehicle(VehicleType type, String licensePlate) {
        if (vehicleSlotMap.containsKey(licensePlate)) {
            System.out.println("Vehicle already parked.");
            return false;
        }

        Vehicle v = new Vehicle(type, licensePlate);
        List<SlotType> pref = getPreferredSlots(type);

        for (SlotType st : pref) {
            SlotGroup group = slotMap.get(st);
            if (group.hasSpace()) {
                group.addVehicle(v);
                vehicleSlotMap.put(licensePlate, st);
                System.out.println("Parked " + licensePlate + " in " + st + " slot.");
                return true;
            }
        }

        System.out.println("No available slot for " + type);
        return false;
    }

    public boolean unparkVehicle(String licensePlate) {
        if (!vehicleSlotMap.containsKey(licensePlate)) {
            System.out.println("Vehicle not found.");
            return false;
        }

        SlotType st = vehicleSlotMap.remove(licensePlate);
        SlotGroup group = slotMap.get(st);
        Vehicle v = group.removeVehicle(licensePlate);

        if (v != null) {
            long minutes = group.calculateFee(v);
            int fee= (int) (minutes*group.getPerMinuteRate());
            System.out.println("Unparked " + licensePlate + " from " + st + ". Fee: Rs. " + fee);
            return true;
        }

        return false;
    }

    public void printOccupancy() {
        for (SlotGroup group : slotMap.values()) {
            System.out.println(group.getType() + ": " + group.getOccupancy() + "/" + group.getCapacity()
                    + " | Rate: ₹" + group.getPerMinuteRate() + "/min");
            for (Vehicle v : group.getVehicles().values()) {
                System.out.println("  " + v.getLicensePlate() + " (" + v.getType() + ")");
            }
        }
    }

    private List<SlotType> getPreferredSlots(VehicleType type) {
        return switch (type) {
            case BIKE -> List.of(SlotType.SMALL, SlotType.MEDIUM, SlotType.LARGE);
            case CAR -> List.of(SlotType.MEDIUM, SlotType.LARGE);
            case TRUCK -> List.of(SlotType.LARGE);
        };
    }

    public static void main(String[] args) throws InterruptedException {
        ParkingLotManager manager = new ParkingLotManager();

        manager.parkVehicle(VehicleType.BIKE, "KA01A1234");
        manager.parkVehicle(VehicleType.CAR, "KA01B2345");
        manager.parkVehicle(VehicleType.TRUCK, "KA01C3456");
        manager.parkVehicle(VehicleType.BIKE, "KA01A12333");
        manager.parkVehicle(VehicleType.BIKE, "KA01A12334");

        Thread.sleep(3000);

        manager.unparkVehicle("KA01C3456");
        manager.printOccupancy();
    }
}
