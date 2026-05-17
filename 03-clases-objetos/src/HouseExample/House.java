package HouseExample;

public class House {
    int doors;
    int windows;
    double size;

    public House() {
        
    }

    public House (int doors, int windows, double size) {
        this.doors = doors;
        this.windows = windows;
        this.size = size;
    }

    void openDoor() {
        System.out.println("La puerta está abierta");
    }

    double calculateArea() {
        return size * size;
    }
}


