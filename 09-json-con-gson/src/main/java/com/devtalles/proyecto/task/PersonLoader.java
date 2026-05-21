package com.devtalles.proyecto.task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PersonLoader {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Person> people;

        try (FileReader reader = new FileReader("person.json")) {
            Type listType = new TypeToken<List<Person>>() {}.getType();
            people = gson.fromJson(reader, listType);
            for (Person person : people) {
                System.out.println("Nombre: " + person.getName());
                System.out.println("Edad: " + person.getAge());
                System.out.println("Está activo: " + person.isActive());
                System.out.println("Hobbies: " + person.getHobbies());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
