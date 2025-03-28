package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    public List<ParkingSpot> parkingSpotList;

    public ParkingLot() {
        this.parkingSpotList = new ArrayList<>();
    }

    public void addSpot(ParkingSpot parkingSpot){
        parkingSpotList.add(parkingSpot);
    }

    public void parkVehicle(Vehicle vehicle){
        ParkingSpot spot=findSpot(vehicle);
        if(spot!=null)
            spot.parkVehicle(vehicle);
        else
            System.out.println("No suitable spot found for " +vehicle.getVehicleNumber());
    }

    public ParkingSpot findSpot(Vehicle vehicle) {
        //this approach is first come first serve and not optimal space allocation
//        for(ParkingSpot parkingSpot: parkingSpotList){
//            if(parkingSpot.isAvailable() && parkingSpot.canFitVehicle(vehicle))
//                return parkingSpot;
//        }
//        return null;

        ParkingSpot bestFit=null;

        for(ParkingSpot spot: parkingSpotList){
            if(spot.isAvailable() && spot.canFitVehicle(vehicle)){
                if(bestFit==null || bestFit.getSpotSize().ordinal()>spot.getSpotSize().ordinal())
                    bestFit=spot;
            }
        }
        return bestFit;
    }

    public void displaySpots() {
        for (ParkingSpot spot : parkingSpotList) {
            System.out.println(spot.getSpotInfo());
        }
    }

}
