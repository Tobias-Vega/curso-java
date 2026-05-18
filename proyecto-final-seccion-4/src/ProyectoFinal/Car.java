package ProyectoFinal;

public class Car extends Vehicle {
    private CarType type;

    public Car(String brand, String model, int year, CarType type) {
        super(brand, model, year);
        this.type = type;
    }

    @Override
    public void start() {
        System.out.println("El auto arrancó");
    }

    @Override
    public String toString() {
        return "Car{" +
                "type=" + type +
                '}' + super.toString();
    }
}
