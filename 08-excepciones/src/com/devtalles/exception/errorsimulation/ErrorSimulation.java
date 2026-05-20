package com.devtalles.exception.errorsimulation;

public class ErrorSimulation {

    public static void simulateError() {
        causeError();
    }

    public static void causeError() {
        throw new RuntimeException("Error crítico en la aplicación");
    }

    public static void main(String[] args) {

        try {
            simulateError();

        } catch (RuntimeException e) {
            System.out.println("Error detectado: " + e.getMessage());
            System.out.println("Detalles del error:");
            e.printStackTrace();
        }
    }
}
