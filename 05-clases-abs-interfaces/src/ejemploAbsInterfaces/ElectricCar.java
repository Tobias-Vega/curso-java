package ejemploAbsInterfaces;

public class ElectricCar extends Vehicle implements Electric, SelfDriving {

    private int batteryLevel;

    public ElectricCar(String brand, String model, int year, int batteryLevel) {
        super(brand, model, year);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void drive() {
        System.out.println("El auto eléctrico está en marcha");
    }

    @Override
    public void chargeBattery() {
        batteryLevel = MAX_BATTERY_CAPACITY;
        System.out.println("La batería está cargada al 100%");
    }

    @Override
    public void activateAutopilot() {
        System.out.println("Modo piloto automático activado");
    }
}
