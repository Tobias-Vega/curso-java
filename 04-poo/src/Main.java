public class Main {
    public  static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Fiat", "Duna", 2000);

        // vehicle.setYear(170);
        vehicle.setYear(2001);

        System.out.println(vehicle.toString());
    }
}
