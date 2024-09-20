package View;

import Model.Elevator;
import Model.Floor;

import java.util.Scanner;

public class CallTheElevator {
    Floor floor;

    public CallTheElevator(Floor floor) throws InterruptedException {
        this.floor = floor;
        System.out.println("Вызвать лифт?");
        System.out.println("1 - ДА");
        System.out.println("2 - НЕТ");
        Scanner scanner = new Scanner(System.in);
        int coll = scanner.nextInt();
        switch (coll) {
            case 1:
                System.out.println("Уточните - на каком Вы сейчас этаже?");
                System.out.println("Наберите от 1 до 20");
                int thisFloor = scanner.nextInt();
                if (thisFloor >= 1 && thisFloor <= 20) {
                    floor.setNumber(thisFloor);
                    System.out.println("Лифт вызван");

                    Elevator priorityElevator = floor.pressingButtonCallTheElevator(thisFloor);
                    System.out.println("Выберите этаж");
                    System.out.println("Наберите от 1 до 20");

                    int thisFloorFinish = scanner.nextInt();
                    if (thisFloorFinish >= 1 && thisFloorFinish <= 20) {
                        priorityElevator.passengerTransportation(thisFloorFinish);
                        new CallTheElevator(floor);;
                    } else {
                        System.out.println("Такого этажа нет");
                    }
                    priorityElevator.passengerTransportation(thisFloorFinish);
                    new CallTheElevator(floor);
                } else {
                    System.out.println("Такого этажа нет");
                    new CallTheElevator(floor);
                }
            case 2:
                break;
            default:
                System.out.println("Неверная команда.");
                new CallTheElevator(floor);
        }
    }
}
