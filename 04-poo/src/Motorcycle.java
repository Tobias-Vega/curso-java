public class Motorcycle extends Vehicle {
    private boolean hasSideCar;

    public Motorcycle(String brand, String model, int year, boolean hasSideCar) {
        super(brand, model, year);
        this.hasSideCar = hasSideCar;
    }

    public void popWheelie() {
        System.out.println("La moto está haciendo willy");
    }

    @Override
    public void start() {
        System.out.println("La moto está encendida");
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "hasSideCar=" + hasSideCar +
                '}' + super.toString();
    }
}
