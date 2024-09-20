package Model;

public class BigElevator extends Elevator {
    private int loadCapacity;

    public BigElevator(ElevatorCondition elevatorCondition, int loadCapacity) {
        super(elevatorCondition);
        this.loadCapacity = 800;
    }

    public BigElevator(ElevatorCondition elevatorCondition) {
        super(elevatorCondition, new Floor());
        this.loadCapacity = 800;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

}
