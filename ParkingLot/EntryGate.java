package ParkingLot;


import static java.util.UUID.randomUUID;

public class EntryGate {

    private ParkingLot parkingLot;

    public EntryGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket generateTicket(Vehicle vehicle){
        ParkingSpot spot=parkingLot.findSpot(vehicle);
        if(spot!=null){
            parkingLot.parkVehicle(vehicle);
            Ticket ticket=new Ticket(randomUUID().toString(),vehicle,spot);
            return ticket;
        }
        else{
            System.out.println("No suitable spot available");
        }
        return null;
    }

}
