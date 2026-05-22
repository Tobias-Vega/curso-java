package com.devtalles.proyecto;

import com.devtalles.proyecto.task.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonValidatorWithGson {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (
                FileReader jsonReader = new FileReader("person.json");
                FileReader schemaReader = new FileReader("person-schema.json");
                FileReader jsonArrayReader = new FileReader("person.json")
        ) {
            Type listType = new TypeToken<List<Person>>() {}.getType();
            List<Person> people = gson.fromJson(jsonReader, listType);

            // Cargar el esquema Json como JSONObject
            JSONObject schemaObject = new JSONObject(new JSONTokener(schemaReader));

            //Cargar el esquema desde schemaObject
            Schema schema = SchemaLoader.load(schemaObject);

            JSONArray peopleJsonArray = new JSONArray(new JSONTokener(jsonArrayReader));
            for (Person person : people) {
                System.out.println("Nombre: " + person.getName());
                System.out.println("Edad: " + person.getAge());
                System.out.println("Está activo: " + person.isActive());
                System.out.println("Hobbies: " + person.getHobbies());
            }
            System.out.println("Archivo validado correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
