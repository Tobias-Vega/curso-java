package com.devtalles.estructurasdedatos.map;

import java.util.HashMap;
import java.util.Map;

public class ExampleHashMap {
    public static void main(String[] args) {
        Map<String, Integer> prouductPrices = new HashMap<>();

        prouductPrices.put("Laptop", 1200);
        prouductPrices.put("Smartphone", 1000);
        prouductPrices.put("Tablet", 1500);

        System.out.println(prouductPrices);

        System.out.println(prouductPrices.get("Laptop"));

        prouductPrices.put("Tablet", 1234);

        System.out.println(prouductPrices);

        prouductPrices.remove("Laptop");

        System.out.println(prouductPrices);

    }
}
