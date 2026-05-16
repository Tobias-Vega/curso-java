package finalProject;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean repeat;

        do {

            System.out.println("Ingresa la edad");
            int age = scanner.nextInt();

            System.out.println("Ingrese tres calificaciones");
            int grade1 = scanner.nextInt();
            int grade2 = scanner.nextInt();
            int grade3 = scanner.nextInt();

            int sum = grade1 + grade2 + grade3;
            double average = sum / 3.0;

            if (average >= 6) {
                System.out.println("Aprobado " + "Edad: " + age);
            } else {
                System.out.println("Desaprobado " + "Edad: " + age);
            }

            System.out.println("¿Desea ingresar nuevos datos? (1 para si, 0 para no)");
            int option = scanner.nextInt();

            repeat = option == 1;
        } while (repeat);

        System.out.println("Programa finalizado");
        scanner.close();
    }
}
