package Model;

public interface ElevatorFunctions {
    void pressingButtonTheFloor(int floor) throws InterruptedException;

    void pressingButtonClosingDoors() throws InterruptedException;

    void pressingButtonOpeningDoors();

    void pressingButtonDispatcher();

    boolean sensorNoMotion();

    boolean sensorYesMotion();

    void passengerTransportation(int floorFinish) throws InterruptedException;

}
