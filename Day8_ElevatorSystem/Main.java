package Day8_ElevatorSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(2);

        // Two people press hall buttons before simulation starts:
        controller.pickup(3, Direction.UP);
        controller.pickup(5, Direction.DOWN);

        // Run 10 time-steps
        for (int tick = 1; tick <= 10; tick++) {
            System.out.println("Tick " + tick + ":");

            // At tick 3, someone inside Car #1 selects floor 7
            if (tick == 3) {
                controller.selectFloor(1, 7);
                System.out.println("  [Cab Call] Inside Car 1: floor 7 requested");
            }

            // 1) Dispatch any waiting hall calls
            controller.step();

            // 3) Print status
            for (String status : controller.statusReport()) {
                System.out.println("  " + status);
            }
            System.out.println();
        }
    }
}
