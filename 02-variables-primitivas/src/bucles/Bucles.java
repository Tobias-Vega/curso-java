package bucles;

public class Bucles {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            System.out.println("Valor: " + i);
        }

        System.out.println("sale");

        int counter = 0;
        int acumulador = 0;

        while (counter < 5) {
            System.out.println("Counter " + counter);
            counter++;

            acumulador = acumulador + counter;
        }

        System.out.println("Acumulador: " + acumulador);

        int counter2 = 0;
        do {
            System.out.println("Counter 2: " + counter2);
            counter2++;
        } while (counter2 < 5);

    }
}
