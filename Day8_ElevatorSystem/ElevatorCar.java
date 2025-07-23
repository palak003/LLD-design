package Day8_ElevatorSystem;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorCar {
    private int id;
    private  int currentFloor=1;
    private  Direction direction=Direction.IDLE;

    private final Queue<Integer> upQueue=new PriorityQueue<>(); //min queue: bcoz needs: 7,8,9 while moving up
    private final Queue<Integer> downQueue =
            new PriorityQueue<>(Collections.reverseOrder()); //max queue : bcoz need 3,2,1 while going down

    public ElevatorCar(int id){
        this.id=id;
    }

    public int getId(){
        return this.id;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public int getCurrentFloor(){
        return this.currentFloor;
    }

    public void addDestination(int floor){
        if(floor==currentFloor)
            return;
        else if(floor>currentFloor){
            upQueue.offer(floor);
            if(direction==Direction.IDLE) direction=Direction.UP;
        }
        else {
            downQueue.offer(floor);
            if (direction == Direction.IDLE) direction = Direction.DOWN;
        }
    }

    public synchronized void step() {
        if (direction == Direction.UP) {
            // Move up one floor
            currentFloor++;
            // Check if this floor was requested
            Integer nextUp = upQueue.peek();
            if (nextUp != null && nextUp == currentFloor) {
                upQueue.poll(); // serve request
                // Decide next direction
                if (!upQueue.isEmpty()) {
                    direction = Direction.UP;      // more ups remain
                } else if (!downQueue.isEmpty()) {
                    direction = Direction.DOWN;    // switch to downs
                } else {
                    direction = Direction.IDLE;    // no more requests
                }
            }
        }
        else if (direction == Direction.DOWN) {
            // Move down one floor
            currentFloor--;
            // Check if this floor was requested
            Integer nextDown = downQueue.peek();
            if (nextDown != null && nextDown == currentFloor) {
                downQueue.poll(); // serve request
                // Decide next direction
                if (!downQueue.isEmpty()) {
                    direction = Direction.DOWN;    // more downs remain
                } else if (!upQueue.isEmpty()) {
                    direction = Direction.UP;      // switch to ups
                } else {
                    direction = Direction.IDLE;    // no more requests
                }
            }
        }
        // else IDLE: nothing to do until a new destination is added
    }

}
