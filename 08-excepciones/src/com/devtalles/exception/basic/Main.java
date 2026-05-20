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
//            System.out.println("División por cero");
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Este mensaje se ejecuta siempre");
        }

        try {
            int[] numbers = new int[3];
            System.out.println(numbers[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            StackTraceElement[] stack = e.getStackTrace();

            for (StackTraceElement element : stack) {
                System.out.println("Clase: " + element.getClassName());
                System.out.println("Método: " + element.getMethodName());
                System.out.println("Archivo: " + element.getFileName());
                System.out.println("Línea: " + element.getLineNumber());
            }
        }

        System.out.println("El programa finaliza");
    }
}
