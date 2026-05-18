package ProyectoFinal;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Vehicle> vehicles = new ArrayList<>();
    private int capacity;


    public Garage(int capacity) {
        this.capacity = capacity;
    }

    public boolean addVehicle(Vehicle vehicle) {

        if (vehicles.size() >= capacity) {
            System.out.println("Capacidad máxima alcanzada");
            return false;
        }

        vehicles.add(vehicle);
        System.out.println("Vehículo añadido");
        return true;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        boolean existsVehicle = vehicles.remove(vehicle);

        if (!existsVehicle) {
            System.out.println("Vehículo no encontrado");
            return false;
        }

        System.out.println("Vehículo eliminado");
        return true;
    }

    public List<Vehicle> listVehicles() {
        System.out.println("Listá de vehículos " + vehicles);
        return vehicles;
    }

    public void startAllVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.start();
        }
    }

    public void chargeAllElectricCars() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof ElectricCar) {
                ((ElectricCar)vehicle).chargeBattery();
            }
        }
    }
}
