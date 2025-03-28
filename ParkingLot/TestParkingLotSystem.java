package ParkingLot;

import ParkingLot.ParkingSpots.BasicParkingSpot;
import ParkingLot.Vehicles.Bike;
import ParkingLot.Vehicles.Car;
import ParkingLot.Vehicles.Truck;

public class TestParkingLotSystem {

    public static void main(String[] args){
        ParkingLot lot=new ParkingLot();

        lot.addSpot(new BasicParkingSpot(VehicleSize.SMALL, "S1"));
        lot.addSpot(new BasicParkingSpot(VehicleSize.LARGE, "L1"));
        lot.addSpot(new BasicParkingSpot(VehicleSize.COMPACT, "C1"));

        // Display initial status
        System.out.println("Initial spot status:");
        lot.displaySpots();
        System.out.println();

        // Park vehicles
        Vehicle bike = new Bike("BIKE123");
        Vehicle car = new Car("CAR456");
        Vehicle truck = new Truck("TRUCK789");

        lot.parkVehicle(bike);
        lot.parkVehicle(car);
        lot.parkVehicle(truck);
        System.out.println();

        // Show updated status
        System.out.println("After parking:");
        lot.displaySpots();
        System.out.println();

        // Free up a spot
        System.out.println("Freeing up one large spot:");
        for (ParkingSpot spot : lot.parkingSpotList) {
            if (!spot.isAvailable()) {
                spot.removeVehicle();
                break;
            }
        }

        // Try parking again
        System.out.println("\nAfter removing vehicle:");
        lot.displaySpots();
        System.out.println();

        EntryGate e=new EntryGate(lot);
        e.generateTicket(bike);
        lot.displaySpots();


    }
}
