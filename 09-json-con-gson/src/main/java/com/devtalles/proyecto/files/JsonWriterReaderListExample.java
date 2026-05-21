package com.devtalles.proyecto.files;

import com.devtalles.proyecto.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonWriterReaderListExample {
    public static void main(String[] args) {

        Gson gson = new Gson();

        List<Person> people = new ArrayList<>();

        people.add(new Person("Fernando Gabriel", 25, false));
        people.add(new Person("Juan", 30, true));
        people.add(new Person("María", 22, true));

        try (FileWriter writer = new FileWriter("person.json")) {
            gson.toJson(people, writer);
            System.out.println("Las personas fueron guardadas con éxito");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileReader reader = new FileReader("person.json")) {
            Type listType = new TypeToken<List<Person>>() {}.getType();
            people = gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (Person person1 : people) {
            System.out.println("Nombre: " + person1.getName());
            System.out.println("Edad: " + person1.getAge());
            System.out.println("Es estudiante: " + person1.isStudent());
            System.out.println("----------------------------------------");
        }
    }
}
