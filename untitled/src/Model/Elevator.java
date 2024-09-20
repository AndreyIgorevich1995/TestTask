package Model;

public abstract class Elevator implements ElevatorFunctions {
    private ElevatorCondition elevatorCondition;
    private Floor floor;

    public Elevator(ElevatorCondition elevatorCondition) {
        this.elevatorCondition = elevatorCondition;
    }

    public Elevator(ElevatorCondition elevatorCondition, Floor floor) {
        this.elevatorCondition = elevatorCondition;
        this.floor = floor;
    }

    @Override
    public void pressingButtonTheFloor(int floor) throws InterruptedException {
        if (floor == this.getFloor().getNumber()) {
            this.getElevatorCondition().setMovementElevator(MovementElevator.movementNo);
            this.getElevatorCondition().setDoors(Doors.doorsOpening);
            System.out.println(this.toString());
        }
        while (floor != this.getFloor().getNumber()) {
            if (floor < this.getFloor().getNumber()) {
                this.pressingButtonClosingDoors();
                this.getElevatorCondition().setMovementElevator(MovementElevator.movementDown);
                this.getFloor().setNumber(this.getFloor().getNumber() - 1);

                System.out.println(this.toString());
                Thread.sleep(1000);

            } else {
                this.pressingButtonClosingDoors();
                this.getElevatorCondition().setMovementElevator(MovementElevator.movementUp);
                this.getFloor().setNumber(this.getFloor().getNumber() + 1);
                System.out.println(this.toString());
                Thread.sleep(1000);

            }
        }
        this.getElevatorCondition().setMovementElevator(MovementElevator.movementNo);
        this.getElevatorCondition().setDoors(Doors.doorsOpening);
        this.getElevatorCondition().setDoors(Doors.doorsAreOpen);
        System.out.println(this.toString());
    }

    @Override
    public void passengerTransportation(int floorFinish) throws InterruptedException {
        while (this.getFloor().getNumber() != floorFinish) {
            if (this.getFloor().getNumber() < floorFinish) {
                this.pressingButtonClosingDoors();
                this.getElevatorCondition().setMovementElevator(MovementElevator.movementUp);
                this.getFloor().setNumber(this.getFloor().getNumber() + 1);

                System.out.println(this.toString());
                Thread.sleep(1000);
            } else {
                this.pressingButtonClosingDoors();
                this.getElevatorCondition().setMovementElevator(MovementElevator.movementDown);
                this.getFloor().setNumber(this.getFloor().getNumber() - 1);
                System.out.println(this.toString());
                Thread.sleep(1000);
            }
        }
        this.getElevatorCondition().setMovementElevator(MovementElevator.movementNo);
        this.getElevatorCondition().setDoors(Doors.doorsOpening);
        this.getElevatorCondition().setDoors(Doors.doorsAreOpen);
        System.out.println(this.toString());
    }


    @Override
    public void pressingButtonClosingDoors() throws InterruptedException {
        if (this.sensorYesMotion() == false && this.sensorNoMotion()) {
            this.setElevatorCondition(new ElevatorCondition(MovementElevator.movementNo, Doors.doorsClosing));
            Thread.sleep(2000);
//            this.setElevatorCondition(new ElevatorCondition(MovementElevator.movementNo, Doors.doorsAreOpen));
        }
    }

    @Override
    public void pressingButtonOpeningDoors() {
        this.setElevatorCondition(new ElevatorCondition(MovementElevator.movementNo, Doors.doorsOpening));
    }

    @Override
    public void pressingButtonDispatcher() {
        System.out.println("Звоним диспетчеру");
    }

    @Override
    public boolean sensorNoMotion() {
        return true;
    }

    @Override
    public boolean sensorYesMotion() {
        return false;
    }

    public ElevatorCondition getElevatorCondition() {
        return elevatorCondition;
    }

    public void setElevatorCondition(ElevatorCondition elevatorCondition) {
        this.elevatorCondition = elevatorCondition;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "elevatorCondition=" + elevatorCondition +
                ", floor=" + floor +
                '}';
    }
}
