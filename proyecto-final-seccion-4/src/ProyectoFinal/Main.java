package ProyectoFinal;

public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car("Fiat", "Duna", 2000, CarType.SPORTS);

        Vehicle myElectricCar = new ElectricCar("Tesla", "Model 3", 2025, CarType.SEDAN, 20);

//        myCar.start();
//        myElectricCar.start();
//
//        ((ElectricCar)myElectricCar).chargeBattery();
//
//        myCar.toString();
//        myElectricCar.toString();

        Garage myGarage = new Garage(4);

        myGarage.addVehicle(myCar);
        myGarage.addVehicle(myElectricCar);

        myGarage.listVehicles();
        myGarage.startAllVehicles();
        myGarage.chargeAllElectricCars();
        myGarage.listVehicles();

    }
}
