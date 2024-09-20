import Model.*;
import View.CallTheElevator;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SmallElevator smallElevator = new SmallElevator(new ElevatorCondition(MovementElevator.movementNo, Doors.doorsAreOpen));
        BigElevator bigElevator = new BigElevator(new ElevatorCondition(MovementElevator.movementNo, Doors.doorsAreOpen));
        Floor floor = new Floor(smallElevator, bigElevator);

        new CallTheElevator(floor);
    }
}