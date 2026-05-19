package com.devtalles.estructurasdedatos.equals;

public class ExampleEquals {
    public static void main(String[] args) {
        Integer numberA = 128; // 100
        Integer numberB = 128; // 100 da true

        System.out.println(numberB == numberA);
        System.out.println(numberB.equals(numberA));
    }
}
