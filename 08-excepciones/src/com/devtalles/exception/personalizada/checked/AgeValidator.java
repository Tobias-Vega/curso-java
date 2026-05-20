package com.devtalles.exception.personalizada.checked;

public class AgeValidator {
    public static void main(String[] args) {
        Person person = null;
        try {
            person = Person.createPerson("Juan", 15);
            System.out.println(person.toString());

        } catch (AgeValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Fin");

    }
}
