package scannerExample;

import java.util.Scanner;

public class NumberCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primero número");
        int a = sc.nextInt();
        System.out.println("Imprimir a: " + a);

        System.out.println("Ingrese el segundo número");
        int b = sc.nextInt();
        System.out.println("La suma de a + b = " + (a + b));
        System.out.println("La diferencia de a - b = " + (a - b));

        if (a > b) {
            System.out.println("El primer número es mayor");
        } else {
            System.out.println("El segundo número es mayor o igual");
        }
    }
}
