package Day8_ElevatorSystem;

import java.util.*;

public class ElevatorController {
    private List<ElevatorCar> elevatorCarList=new ArrayList<>();
    private Queue<Request> upRequest=new LinkedList<>();
    private Queue<Request> downRequest=new LinkedList<>();

    public ElevatorController(int numberOfElevators){
        for(int i=0;i<numberOfElevators;i++){
            elevatorCarList.add(new ElevatorCar(i+1));
        }
    }

    public List<ElevatorCar> getElevatorCars(){
        return this.elevatorCarList;
    }

    public void pickup(int floor, Direction direction){
        Request request=new Request(floor,direction);
        if(direction==Direction.UP)
            upRequest.offer(request);
        else
            downRequest.offer(request);
    }

    //passenger is inside the lift and selecting floor inside
    public void selectFloor(int elevatorId, int floor){
        ElevatorCar elevatorCar=elevatorCarList.stream().filter(e->e.getId()==elevatorId).findFirst().orElseThrow();
        elevatorCar.addDestination(floor);
    }

    public void step() {
        assignHallRequests();
        for (ElevatorCar car : elevatorCarList) {
            car.step();
        }
    }


    public void assignHallRequests(){
        assignQueue(upRequest,Direction.UP);
        assignQueue(downRequest,Direction.DOWN);
    }

    private void assignQueue(Queue<Request> requests, Direction direction){
        Iterator<Request> it=requests.iterator();
        while (it.hasNext()) {
            Request request=it.next();
            ElevatorCar bestCar=findBestCar(request.getFloor(),direction);
            if(bestCar!=null) {
                bestCar.addDestination(request.getFloor());
                it.remove();
            }
            else
                break;
        }
    }

    private ElevatorCar findBestCar(int floor,Direction direction){
        ElevatorCar bestCar=null;
        int maxDist=Integer.MAX_VALUE;
        for(ElevatorCar elevatorCar:elevatorCarList){
            if(elevatorCar.getDirection()==Direction.IDLE || elevatorCar.getDirection()==direction){
                int dist=Math.abs(floor-elevatorCar.getCurrentFloor());
                if(dist<maxDist) {
                    maxDist = dist;
                    bestCar = elevatorCar;
                }
            }
        }
        return bestCar;
    }

    // For monitoring and testing
    public List<String> statusReport() {
        List<String> report = new ArrayList<>();
        for (ElevatorCar car : elevatorCarList) {
            report.add(String.format("Car %d: floor=%d, dir=%s",
                    car.getId(), car.getCurrentFloor(), car.getDirection()));
        }
        return report;
    }
}
