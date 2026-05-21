package com.devtalles.proyecto.nested;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class ConfigSaver {
    public static void saveConfig(AppConfig config, String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(config, writer);
            System.out.println("configuración guardada correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }

    }

    public static void main(String[] args) {
        AppConfig config = ConfigLoader.loadConfig("config.json");

        if (config != null) {
            config.getSettings().setTheme("Light");
            saveConfig(config, "config.json");
        }
    }
}
