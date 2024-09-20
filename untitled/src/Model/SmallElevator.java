package Model;

public class SmallElevator extends Elevator {

    int loadCapacity;

    public SmallElevator(ElevatorCondition elevatorCondition, int loadCapacity) {
        super(elevatorCondition);
        this.loadCapacity = 400;
    }

    public SmallElevator(ElevatorCondition elevatorCondition) {
        super(elevatorCondition, new Floor());
        this.loadCapacity = 400;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
