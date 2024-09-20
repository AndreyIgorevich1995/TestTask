package Model;

//Состояние лифта
public class ElevatorCondition {
    private MovementElevator movementElevator;
    private Doors doors;

    public ElevatorCondition(MovementElevator movementElevator, Doors doors) {
        this.movementElevator = movementElevator;
        this.doors = doors;
    }

    public ElevatorCondition() {
        this.movementElevator = MovementElevator.movementNo;
        this.doors = Doors.doorsAreOpen;
    }

    public MovementElevator getMovementElevator() {
        return movementElevator;
    }

    public void setMovementElevator(MovementElevator movementElevator) {
        this.movementElevator = movementElevator;
    }

    public Doors getDoors() {
        return doors;
    }

    public void setDoors(Doors doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "ElevatorCondition{" +
                "movementElevator=" + movementElevator +
                ", doors=" + doors +
                '}';
    }
}
