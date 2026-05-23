package com.devtalles.proyecto;


public class Main {
    public static void main(String[] args) {
        Person person = Person.builder().name("Tobías").age(20).lastName("Vega").build();
        System.out.println(person);
    }
}
