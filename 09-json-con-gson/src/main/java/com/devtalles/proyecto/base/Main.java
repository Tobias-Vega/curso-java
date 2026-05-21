package com.devtalles.proyecto.base;

import com.devtalles.proyecto.Person;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Juan", 25, true);

        Gson gson = new Gson();

        String json = gson.toJson(person);

        System.out.println(json);

        //json = "{\"name\":\"Juan\",\"age\":25,\"student\":true}";

        json = """
                {
                    "name": "Juan",
                    "age": 25,
                    "student": true
                }
               
                """;

        Person person2 = gson.fromJson(json, Person.class);

        System.out.println("Nombre: " + person2.getName());
        System.out.println("Edad: " + person2.getAge());
        System.out.println("Es estudiante: " + person2.isStudent());
    }
}
