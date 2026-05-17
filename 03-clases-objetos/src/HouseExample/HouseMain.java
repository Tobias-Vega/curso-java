package HouseExample;

public class HouseMain {
    public static void main(String[] args) {
        House myHouse = new House();
        myHouse.doors = 2;
        myHouse.windows = 4;
        myHouse.size = 10;

        House myHouse2 = new House();
        myHouse2.doors = 4;
        myHouse2.windows = 6;
        myHouse2.size = 20;

        System.out.println("La cantidad de puertas de la casa es: " + myHouse2.doors);
        myHouse2.openDoor();

        double area = myHouse2.calculateArea();

        System.out.println("El área de la casa es: " + area);
    }
}
