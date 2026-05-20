package com.devtalles.exception.basic;

public class Main {

    public static void recursive() {
        recursive();
    }

    public static void main(String[] args) {

        try {
            int result = 10 / 0;
            System.out.println("Resultado: " + result);
        } catch (ArithmeticException e) {
            System.out.println("División por cero");
        } finally {
            System.out.println("Este mensaje se ejecuta siempre");
        }

        System.out.println("El programa finaliza");

    }
}
