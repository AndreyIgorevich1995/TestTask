package Model;

public class Floor implements FloorFunctions {
    private int number;
    private Elevator elevator1;
    private Elevator elevator2;
    private ButtonCallTheElevator buttonCallTheElevator;


    public Floor(Elevator elevator1, Elevator elevator2) {
        this.elevator1 = elevator1;
        this.elevator2 = elevator2;
        this.buttonCallTheElevator = ButtonCallTheElevator.noCall;
        this.number = 1;
    }

    public Floor(int number, Elevator elevator1, Elevator elevator2) {
        this.number = number;
        this.elevator1 = elevator1;
        this.elevator2 = elevator2;
        this.buttonCallTheElevator = ButtonCallTheElevator.noCall;
    }

    public Floor() {
        this.number = 1;
        this.buttonCallTheElevator = ButtonCallTheElevator.noCall;
    }


    @Override
    public Elevator pressingButtonCallTheElevator(int floor) throws InterruptedException {
        int distanceToЕlevator1 = Math.abs(this.getNumber() - this.elevator1.getFloor().number);
        int distanceToЕlevator2 = Math.abs(this.getNumber() - this.elevator2.getFloor().number);
        if (distanceToЕlevator1 == distanceToЕlevator2) {
            this.elevator1.pressingButtonClosingDoors();
            this.elevator1.pressingButtonTheFloor(this.getNumber());
            return elevator1;
        } else if (distanceToЕlevator1 < distanceToЕlevator2) {
            this.elevator1.pressingButtonClosingDoors();
            this.elevator1.pressingButtonTheFloor(this.getNumber());
            return elevator1;
        } else {
            this.elevator2.pressingButtonClosingDoors();
            this.elevator2.pressingButtonTheFloor(this.getNumber());
            return elevator2;
        }
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Elevator getElevator1() {
        return elevator1;
    }

    public void setElevator1(Elevator elevator1) {
        this.elevator1 = elevator1;
    }

    public Elevator getElevator2() {
        return elevator2;
    }

    public void setElevator2(Elevator elevator2) {
        this.elevator2 = elevator2;
    }

    public ButtonCallTheElevator getButtonCallTheElevator() {
        return buttonCallTheElevator;
    }

    public void setButtonCallTheElevator(ButtonCallTheElevator buttonCallTheElevator) {
        this.buttonCallTheElevator = buttonCallTheElevator;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "number=" + number +
                ", elevator1=" + elevator1 +
                ", elevator2=" + elevator2 +
                ", buttonCallTheElevator=" + buttonCallTheElevator +
                '}';
    }
}
