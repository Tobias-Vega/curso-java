public class Motorcycle extends Vehicle {
    private boolean hasSideCar;
    private Engine engine;

    public Motorcycle(String brand, String model, int year, boolean hasSideCar) {
        super(brand, model, year);
        this.hasSideCar = hasSideCar;
        this.engine = new Engine();
    }

    public void popWheelie() {
        System.out.println("La moto está haciendo willy");
    }

    public void start() {
        System.out.println("La moto está encendida");
        engine.start();
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "hasSideCar=" + hasSideCar +
                '}' + super.toString();
    }
}
